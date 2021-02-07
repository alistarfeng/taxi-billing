package com.alibaba.taxibilling.service.impl;

import com.alibaba.taxibilling.bean.RuleInfo;
import com.alibaba.taxibilling.common.CommonResult;
import com.alibaba.taxibilling.dao.RuleDao;
import com.alibaba.taxibilling.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleServiceImpl implements RuleService {

    @Autowired
    private RuleDao ruleDao;

    @Override
    public List<RuleInfo> getRuleInfoByTaxiTypeAndTime(String taxiType, String time) {
        return ruleDao.getRuleInfoByTaxiTypeAndTime(taxiType, time);
    }

    @Override
    public RuleInfo getRuleInfo(Integer id) {
        return ruleDao.getRuleInfo(id);
    }

    @Override
    public CommonResult add(RuleInfo rule) {
        //简单校验,实际中要做大量的校验工作
        if (getRuleInfo(rule.getId()) != null) {
            return CommonResult.failed("重复添加");
        }
        ruleDao.add(rule);
        return CommonResult.success(null, "添加成功");
    }

    @Override
    public CommonResult delete(Integer id) {
        if (getRuleInfo(id) == null) {
            return CommonResult.failed("该规则不存在");
        }
        ruleDao.delete(id);
        return CommonResult.success(null, "删除成功");
    }

    @Override
    public CommonResult update(RuleInfo rule) {
        if (getRuleInfo(rule.getId()) == null) {
            return CommonResult.failed("该规则不存在");
        }
        ruleDao.update(rule);
        return CommonResult.success(null, "修改成功");
    }

}
