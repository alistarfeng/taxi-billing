package com.alibaba.taxibilling.util;


import com.alibaba.taxibilling.bean.ChargingInfo;
import com.alibaba.taxibilling.bean.RuleInfo;

import java.util.List;

public class CalPriceUtils {

    public static double getResultOfPrice(ChargingInfo charging, List<RuleInfo> rules) {
        double resultPrice = rules.get(0).getInitialPrice();
        int initialDistance = rules.get(0).getInitialDistance();
        double distance = charging.getTotalDistance();
        //行驶总距离<=初始化距离
        if (distance <= initialDistance) {
            return resultPrice;
        }
        for (RuleInfo rule : rules) {
            //区间最小距离
            int minRangeDistance = rule.getMinRangeDistance();
            //区间最大距离
            int maxRangeDistance = rule.getMaxRangeDistance();
            //区间单价
            double rangePrice = rule.getRangePrice();

            if (distance > minRangeDistance && distance <= maxRangeDistance) { //在区间内
                resultPrice += (distance - minRangeDistance) * rangePrice;
                return resultPrice;
            } else if (distance > minRangeDistance && distance > maxRangeDistance) { //大于区间内
                resultPrice += (maxRangeDistance-minRangeDistance) * rangePrice;
            } else { //小于区间内,配置异常情况
                return -1;
            }
        }
        return resultPrice;
    }

}
