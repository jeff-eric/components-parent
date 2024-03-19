# 组件

##### 1.2.2.20240314-RELEASE

* fix: 修复disruptor包版本问题，4.0.0 降到 3.4.4
* feat: 增加磁盘容量检测工具类DiskSpaceUtil
* feat: components-starter-object-storage增加腾讯cos支持
* feat: components-starter-object-storage增加多数据源支持 @DSObjectStorage
* feat: @SProcessor 支持处理类本身实现断言ProcessorAssert接口

##### 1.2.1.20231221-RELEASE

* feat: 升级springboot到2.7.18
* feat: 升级相关类库版本
* feat: starter-redis增加多数据源支持 @DSRedis
* feat: starter-redis redisson支持多数据源 @DSRedisson
* feat: starter-database 支持多数据源 @DSDatabase
* feat: starter-database 支持多数据源垮库本地事务 @DSDatabaseTransactional
* fix: 修复starter-database自定义mapper地址后，无法扫描默认的SuperMapper
* refactor: 删除多余代码、工具类
* refactor: 命名修改
* refactor: core-common的IResult优化
* refactor: core-exception的Exception优化
* refactor: starter-annotation优化
* refactor: starter-web优化
* refactor: components-starter-compatible-ribbon-to-loadbalancer更名为components-extra-compatible-ribbon-to-loadbalancer
* refactor: 统一Properties配置类bool类型为boolean
