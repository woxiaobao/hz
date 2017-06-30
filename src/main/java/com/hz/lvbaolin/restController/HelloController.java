package com.hz.lvbaolin.restController;


import com.hz.lvbaolin.domain.User;
import com.hz.lvbaolin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by master-lv on 2017/6/27.
 */

@RestController
public class HelloController {

    protected static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Resource
    private UserService userService;

    @RequestMapping("/hello")
    public String index() {
        logger.info("baolin hello everyone!!!---");
        return "Greetings from Spring Boot!";
    }

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
        try {
            userService.save(user);
        }catch (Exception e){
            logger.error("发生异常，保存失败");
        }
        return user;
    }

    @RequestMapping("/user/list")
    public List<User> list(){
        userService.getAll();
    }

}
