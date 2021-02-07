package com.alibaba.taxibilling.bean;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * 计费信息类
 */
public class ChargingInfo implements Serializable {

    /**
     * 总的距离
     */
    @NotNull
    @Min(0)
    private Double totalDistance;

    /**
     * 上车时间
     */
    @NotBlank
    private String beginTime;

    public ChargingInfo() {
    }

    public Double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(Double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    @Override
    public String toString() {
        return "ChargingInfo{" +
                "totalDistance=" + totalDistance +
                ", beginTime='" + beginTime + '\'' +
                '}';
    }
}
