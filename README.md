### springboot gradle 的方式对三种数据库的测试

#### 说明: MYSQL 和 NOSQL(redis/mongodb)数据库进行一个数据持久化性能的比较高并发的处理

- 本项目需要在本地安装mysql redis MongoDB gradle-3.5 JDK1.8.0_05

    redis的下载与安装:  [https://github.com/MSOpenTech/redis/releases](https://github.com/MSOpenTech/redis/releases)
    
    MongoDB的下载与安装：[https://www.mongodb.com/download-center#community](https://www.mongodb.com/download-center#community)

- 通过springMVC的restful接口的方式进行数据的测试mysql、redis、mongodb

- 首先对性能测试，性能结果：redis > mongodb > mysql
    redis和MongoDB相差的是毫秒级别，差别并不是很明显，但是MongoDB和mysql的差距就很大了。

#### 结论：通过数据的测试nosql比关系型数据库在数据数据持久化快接近50倍

- httpclient(模拟高并发情况的http请求，多线程请求)

  #### 测试redis高并发情况下的数据安全性
    
    - 本地服务测试(本地开的端口是8081)
    
        同时发送多条请求  [http://localhost:8081/redis/concurrent](http://localhost:8081/redis/concurrent)
    	
    	我在本地发送了两次请求 理论结果是 "concurrent:data = 200" ,而实际的结果是"concurrent:data = 109".
    	
  - 总结：在高并发的情况下会有数据安全性的问题
  
  - 解决方法,单机的有两种方式处理 1、ReentrantLock  2、synchronized代码块来实现 (分布式待续……)
  
  
 synchronized实现线程锁   
 [http://localhost:8081/redis/concurrent](http://localhost:8081/redis/concurrent)
  
  ```java
  synchronized(this){
    //redis数据处理
    //业务代码            
  }
  
  ```
  
 ReentrantLock实现线程锁 
 [http://localhost:8081/redis/lock](http://localhost:8081/redis/lock) 

```java
private final Lock queueLock = new ReentrantLock();//定义线程锁
queueLock.lock();//加锁
queueLock.unlock();//解锁

```

#### 其他数据库在单机的情况下控制高并发同上
    
    
    