package com.hz.lvbaolin.restController;

import com.hz.lvbaolin.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by master-lv on 2017/8/18.
 */

@RestController
@RequestMapping("/mongodb")
public class MongodbController {


    protected static Logger logger = LoggerFactory.getLogger(MongodbController.class);

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
}
