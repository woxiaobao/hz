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
    
    
  ### 测试redis高并发情况下的数据安全性
    
    - 本地服务测试
    
    	- 同时发送多条请求 [http://localhost:8081/redis/concurrent](http://localhost:8081/redis/concurrent)
    	我在本地发送了两次请求 理论结果是 "concurrent:data = 200" ,而实际的结果是"concurrent:data = 109".
    	
  - 总结：在高并发的情况下会有数据安全性的问题
  
  - 解决方法（待续…………）