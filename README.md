### springboot学习

#### 说明 mysql和 NOSQL(redis/mongodb)数据库进行一个数据持久化性能的比较

- 本项目需要在本地安装mysql redis MongoDB gradle-3.5

- 通过restful接口的方式进行数据的测试

- springboot hibernate mysql

- springboot redis 

- springboot mongodb 

- httpclient(已加但是没有做功能)

- 性能结果redis > mongodb > mysql, redis和MongoDB相差的是毫秒级别，差别并不是很明显，但是MongoDB和mysql的差距就很大了。

#### 结论：通过数据的测试nosql比关系型数据库在数据数据持久化快接近50倍
    