package com.alibaba.taxibilling.service;

import com.alibaba.taxibilling.bean.ChargingInfo;
import com.alibaba.taxibilling.common.CommonResult;

public interface BillingService {

    /**
     * 计算车票账单
     * @param taxiId
     * @param charging
     * @return
     */
    CommonResult generateBilling(Integer taxiId, ChargingInfo charging);

}
