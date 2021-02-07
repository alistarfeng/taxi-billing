package com.alibaba.taxibilling.service.impl;

import com.alibaba.taxibilling.bean.ChargingInfo;
import com.alibaba.taxibilling.bean.RuleInfo;
import com.alibaba.taxibilling.bean.TaxiInfo;
import com.alibaba.taxibilling.common.CommonResult;
import com.alibaba.taxibilling.service.BillingService;
import com.alibaba.taxibilling.service.RuleService;
import com.alibaba.taxibilling.service.TaxiService;
import com.alibaba.taxibilling.util.CalPriceUtils;
import com.alibaba.taxibilling.vo.BillingVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingServiceImpl implements BillingService {

    @Autowired
    private TaxiService taxiService;

    @Autowired
    private RuleService ruleService;

    private static final Logger LOGGER = LoggerFactory.getLogger(BillingServiceImpl.class);

    @Override
    public CommonResult<BillingVO> generateBilling(Integer taxiId, ChargingInfo charging) {
        TaxiInfo taxi = taxiService.getTaxiInfo(taxiId);
        if (taxi == null) {
            LOGGER.error("该车辆不存在 :taxiId={}", taxiId);
            return CommonResult.failed("该车辆不存在！");
        }
        String taxiType = taxi.getTaxiType();

        List<RuleInfo> rules = ruleService.getRuleInfoByTaxiTypeAndTime(taxiType, charging.getBeginTime());
        if (rules.size() == 0) {
            LOGGER.error("计算规则有误 :taxiType={}, beginTime={}", taxiType, charging.getBeginTime());
            return CommonResult.failed("计算规则有误！");
        }
        double price = CalPriceUtils.getResultOfPrice(charging, rules);
        if (price <= 0) {
            LOGGER.error("计算规则有误 :taxiType={}, beginTime={}", taxiType, charging.getBeginTime());
            return CommonResult.failed("计算规则有误！");
        }
        BillingVO billing = new BillingVO();
        billing.setTaxiId(taxiId);
        billing.setTaxiType(taxiType);
        billing.setDistance(charging.getTotalDistance());
        billing.setBeginTime(charging.getBeginTime());
        billing.setPrice(price);
        return CommonResult.success(billing);
    }
}
