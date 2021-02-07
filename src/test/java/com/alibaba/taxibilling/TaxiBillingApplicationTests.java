package com.alibaba.taxibilling;

import com.alibaba.taxibilling.bean.ChargingInfo;
import com.alibaba.taxibilling.common.CommonResult;
import com.alibaba.taxibilling.controller.BillingController;
import com.alibaba.taxibilling.vo.BillingVO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TaxiBillingApplicationTests {

	@Autowired
	private BillingController billingController;

	/**
	 * 甲出租车白班
	 */
	@Test
	void testATaxiAndDay_case() {
		ChargingInfo chargingInfo = new ChargingInfo();
		chargingInfo.setBeginTime("12:59");
		chargingInfo.setTotalDistance(12d);
		//taxiId为1表示甲出租车
		CommonResult<BillingVO> result = billingController.generateBilling(1, chargingInfo);
		Assert.assertEquals(38.5d, result.getData().getPrice(), 0.0d);
	}

	/**
	 * 甲出租车夜班
	 */
	@Test
	void testATaxiAndNight_case() {
		ChargingInfo chargingInfo = new ChargingInfo();
		chargingInfo.setBeginTime("23:59");
		chargingInfo.setTotalDistance(10d);
		//taxiId为1表示甲出租车
		CommonResult<BillingVO> result = billingController.generateBilling(1, chargingInfo);
		Assert.assertEquals(39.0d, result.getData().getPrice(), 0.0d);

	}

	/**
	 * 乙出租车白班
	 */
	@Test
	void testBTaxiAndDay_case() {
		ChargingInfo chargingInfo = new ChargingInfo();
		chargingInfo.setBeginTime("12:59");
		chargingInfo.setTotalDistance(5d);
		//taxiId为2表示乙出租车
		CommonResult<BillingVO> result = billingController.generateBilling(2, chargingInfo);
		Assert.assertEquals(19d, result.getData().getPrice(), 0.0d);

	}

	/**
	 * 乙出租车夜班
	 */
	@Test
	void testBTaxiAndNight_case2() {
		ChargingInfo chargingInfo = new ChargingInfo();
		chargingInfo.setBeginTime("20:59");
		chargingInfo.setTotalDistance(50d);
		//taxiId为2表示乙出租车
		CommonResult<BillingVO> result = billingController.generateBilling(2, chargingInfo);
		Assert.assertEquals(159.0d, result.getData().getPrice(), 0.0d);
	}
}
