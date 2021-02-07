### 工程结构
- 项目采用了springboot 工程
- jdk1.8 
- springboot 2.4.2

### 实现思路
1. 前端传入 车辆id，行驶总距离，上车时间 
2. 模拟数据库返回计费规则
3. 计算得到价钱


### 入口 BillingController

参数传递
- taxiId 车辆id
- ChargingInfo 计费信息类
    - totalDistance 行驶总距离
    - beginTime 上车时间 

### TaxiDao，模拟数据库返回车租车信息

- 根据taxiId（车辆id）确定出车辆类型 taxiType
- 目前模拟了俩种
1. taxiId=1 为甲出租车
2. taxiId=2 为乙出租车

### RuleInfo 规则类
定义了计费规则的字段，比如3-10公里每公里2.5元，3为区间距离最小值，10为区间距离最大值，2.5为区间价格
- id 
- taxiType 车辆类型
- initialPrice  起步价
- initialDistance    起步价距离
- rangePrice 区间距离价格
- minRangeDistance  区间距离最小值
- maxRangeDistance  区间距离最大值
- beginTime 开始时间
- endTime   结束时间


      
### RuleDao， 模拟数据库返回收费规则

根据taxiType（车辆类型） 和 beginTime（上车时间）判断出收费规则

模拟数据库返回四种规则
1. 甲白天出租车规则
2. 甲黑夜出租车规则
3. 乙白天出租车规则
4. 乙黑夜出租车规则

### 计算价格CalPriceUtils
根据车辆类型，行驶距离，上车时间 和 数据库中返回的规则计算得到价钱

### 返回车票 BillingVO 
- taxiId 车辆id
- taxiType 车量类型
- beginTime 上车时间
- distance 总距离
- price 价格

### 扩展性
1. 提供了RuleController 方便增删改规则
2. 提供了TaxiController 方便增删改taxi


### 问题规避
1. 如果发生跨时间段的话比如说17：00上车，19：00 下车，
白班和夜班切换时间为18：00， 统一按照上车时间为标准 

### 测试类TaxiBillingApplicationTests
模拟了四种情况进行了单元测试



