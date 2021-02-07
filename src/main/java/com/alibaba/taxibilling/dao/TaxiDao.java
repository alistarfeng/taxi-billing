package com.alibaba.taxibilling.dao;

import com.alibaba.taxibilling.bean.TaxiInfo;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用于模拟数据库获取数据
 */
@Repository
public class TaxiDao {

    private static List<TaxiInfo> taxis = new ArrayList<>();

    static {
        taxis.add(new TaxiInfo(1, "甲"));
        taxis.add(new TaxiInfo(2, "乙"));
    }

    /**
     * 获取车辆信息
     */
    public TaxiInfo getTaxiInfoById(Integer id) {
        TaxiInfo taxi = taxis.stream().filter(item -> id.equals(item.getId())).findAny().orElse(null);
        return taxi;
    }


    /**
     * 增加车辆信息
     */
    public void add(TaxiInfo taxi) {
        taxis.add(taxi);
    }

    /**
     * 删除车辆信息
     */
    public void delete(Integer taxiId) {
        taxis =taxis.stream().filter(item ->!taxiId.equals(item.getId())).collect(Collectors.toList());
    }

    /**
     * 修改车辆信息
     */
    public void update(TaxiInfo taxi) {
        TaxiInfo oldTaxi = getTaxiInfoById(taxi.getId());
        oldTaxi.setTaxiType(taxi.getTaxiType());
    }
}
