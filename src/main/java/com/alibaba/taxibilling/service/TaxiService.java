package com.alibaba.taxibilling.service;

import com.alibaba.taxibilling.bean.TaxiInfo;
import com.alibaba.taxibilling.common.CommonResult;

import java.util.stream.Collectors;

public interface TaxiService {

    public TaxiInfo getTaxiInfo(Integer id);

    /**
     * 增加车辆信息
     */
    public CommonResult add(TaxiInfo taxi);

    /**
     * 删除车辆信息
     */
    public CommonResult delete(Integer id);
    /**
     * 修改车辆信息
     */
    public CommonResult update(TaxiInfo taxi);
}
