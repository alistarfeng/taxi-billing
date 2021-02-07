package com.alibaba.taxibilling.dao;

import com.alibaba.taxibilling.bean.RuleInfo;
import com.alibaba.taxibilling.util.TimeOperateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 从数据库获取计费参数信息
 */
@Repository
public class RuleDao {

    public static List<RuleInfo> rules = new ArrayList<>();

    /**
     * 模拟数据库初始化数据
     */
    static {
        //甲白天规则
        rules.add(new RuleInfo(1, "甲",14d,3,2.5,3,10,"06:00", "18:00"));
        rules.add(new RuleInfo(2, "甲",14d,3,3.5,10,Integer.MAX_VALUE,"06:00", "18:00"));

        //甲晚上规则
        rules.add(new RuleInfo(3, "甲",18d,3,3d,3,10,"18:00", "06:00"));
        rules.add(new RuleInfo(4, "甲",18d,3,4.7,10,Integer.MAX_VALUE,"18:00", "06:00"));

        //乙白天规则
        rules.add(new RuleInfo(5, "乙",14d,3,2.5,3,Integer.MAX_VALUE,"06:00", "18:00"));

        //乙晚上规则
        rules.add(new RuleInfo(6, "乙",18d,3,3d,3,Integer.MAX_VALUE,"18:00", "06:00"));

    }

    /**
     * 根据车辆类型和时间获取规则
     *
     * @param taxiType
     * @param time
     * @return
     */
    public List<RuleInfo> getRuleInfoByTaxiTypeAndTime(String taxiType, String time) {
        List<RuleInfo> list = rules.stream().filter(item -> {
            Date nowTime = TimeOperateUtil.parse(time, "HH:mm");
            Date beginTime = TimeOperateUtil.parse(item.getBeginTime(), "HH:mm");
            Date endTime = TimeOperateUtil.parse(item.getEndTime(), "HH:mm");
            return taxiType.equals(item.getTaxiType()) && TimeOperateUtil.timeBetween(nowTime, beginTime, endTime);
        }).collect(Collectors.toList());
        return list;
    }


    public RuleInfo getRuleInfo(Integer id) {
        RuleInfo ruleInfo = rules.stream().filter(item -> {
            return id.equals(item.getId());
        }).findAny().orElse(null);
        return ruleInfo;
    }

    public void add(RuleInfo rule){
        rules.add(rule);
    }

    public void delete(Integer id){
        rules =rules.stream().filter(item ->!id.equals(item.getId())).collect(Collectors.toList());
    }

    /**
     * 修改车辆信息
     */
    public void update(RuleInfo rule) {
        RuleInfo oldRule = getRuleInfo(rule.getId());
        BeanUtils.copyProperties(rule, oldRule);
    }

}
