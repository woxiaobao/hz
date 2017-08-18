package com.hz.lvbaolin.restController;

import com.hz.lvbaolin.domain.User;
import com.hz.lvbaolin.utils.SerializeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by master-lv on 2017/8/18.
 */

@RestController
@RequestMapping("/redis")
public class RedisController {

    protected static Logger logger = LoggerFactory.getLogger(RedisController.class);

    @RequestMapping("/user")
    public User add() {
        logger.info("add to user");
        User user = new User();
        user.setUsername("宝林");
        user.setBirthday(new Date());
        user.setPassword("111111");
        user.setPhone("18801424045");
        user.setAddress("北京朝阳");
        user.setSex("1");
        user.setToken("1234567890");

        return user;
    }

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Resource(name="stringRedisTemplate")
    ValueOperations<String,String> valOpsStr;

    @Resource(name = "redisTemplate")
    ValueOperations<Object,Object> valueOperations;


    @RequestMapping("set")
    public String setKeyAndValue(){
        long start = System.currentTimeMillis();
        for (long i=0;i<100;i++){
            User user = new User();
            user.setId(i);
            user.setUsername("宝林");
            user.setBirthday(new Date());
            user.setPassword("111111");
            user.setPhone("18801424045");
            user.setAddress("北京朝阳");
            user.setSex("1");
            user.setToken("1234567890");

            String key = "user:"+user.getId();
            String value = SerializeUtil.objectSerialiable(user);
            logger.info(key + "------" + value);
            valOpsStr.set(key, value);
        }
        logger.info((System.currentTimeMillis()-start )+ "");


        return "Set Ok";
    }

    @RequestMapping("get")
    public List<User> getKey(){
        long start = System.currentTimeMillis();
        List<User> userList = new ArrayList<>();
        for (int i=0;i<100;i++){
            String key = "user:"+i;
            String value = valOpsStr.get(key);
            logger.info(key + "------" + value);
            User user = (User) SerializeUtil.objectDeserialization(value);
            userList.add(user);
        }
        logger.info((System.currentTimeMillis()-start )+ "");
        return userList;
    }


    @RequestMapping("set1")
    public String setKeyAndValue1(){
        long start = System.currentTimeMillis();
        for (long i=0;i<100;i++){
            User user = new User();
            user.setId(i);
            user.setUsername("宝林");
            user.setBirthday(new Date());
            user.setPassword("111111");
            user.setPhone("18801424045");
            user.setAddress("北京朝阳");
            user.setSex("1");
            user.setToken("1234567890");

            String key = "user:"+user.getId();
            byte[] value = SerializeUtil.serialize(user);
            logger.info(key + "------" + value);
            valueOperations.set(key, value);
        }
        logger.info((System.currentTimeMillis()-start )+ "");


        return "Set Ok";
    }

    @RequestMapping("get1")
    public List<User> getKey1(){
        long start = System.currentTimeMillis();
        List<User> userList = new ArrayList<>();
        for (int i=0;i<100;i++){
            String key = "user:"+i;
            byte[] value = (byte[])valueOperations.get(key);
            logger.info(key + "------" + value);
            User user = (User) SerializeUtil.unserialize(value);
            userList.add(user);
        }
        logger.info((System.currentTimeMillis()-start )+ "");
        return userList;
    }
}
