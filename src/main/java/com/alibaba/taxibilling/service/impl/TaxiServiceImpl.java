package com.alibaba.taxibilling.service.impl;

import com.alibaba.taxibilling.bean.TaxiInfo;
import com.alibaba.taxibilling.common.CommonResult;
import com.alibaba.taxibilling.dao.TaxiDao;
import com.alibaba.taxibilling.service.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxiServiceImpl implements TaxiService {

    @Autowired
    private TaxiDao taxiDao;

    @Override
    public TaxiInfo getTaxiInfo(Integer id) {
        return taxiDao.getTaxiInfoById(id);
    }

    /**
     * 增加车辆信息
     */
    public CommonResult add(TaxiInfo taxi) {

        //简单的拿taxiId做了重复判断
        if (getTaxiInfo(taxi.getId()) != null){
            return CommonResult.failed("重复添加车辆");
        }
        taxiDao.add(taxi);
        return CommonResult.success(null, "添加成功");
    }

    /**
     * 删除车辆信息
     */
    public CommonResult delete(Integer id) {
        if (getTaxiInfo(id) == null){
            return CommonResult.failed("该车辆不存在");
        }
        taxiDao.delete(id);
        return CommonResult.success(null, "删除成功");
    }

    /**
     * 修改车辆信息
     */
    public CommonResult update(TaxiInfo taxi) {
        if (getTaxiInfo(taxi.getId()) == null){
            return CommonResult.failed("该车辆不存在");
        }
        taxiDao.update(taxi);
        return CommonResult.success(null, "修改成功");
    }
}
