package com.hz.lvbaolin.restController;


import com.hz.lvbaolin.domain.User;
import com.hz.lvbaolin.service.UserService;
import com.hz.lvbaolin.utils.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by master-lv on 2017/6/27.
 */

@RestController
@RequestMapping("/hello")
public class HelloController {


    protected static Logger logger = LoggerFactory.getLogger(HelloController.class);


    // 从 application.properties 中读取配置，如取不到默认值为Hello
    @Value("${application.hello:Hello}")
    private String hello;




    @Resource
    private UserService userService;

    @RequestMapping("/hello")
    public String index() {

        String url = "http://localhost:8083/login/add";
        String content = HttpClientUtil.get(url);
        logger.info(content);
        return "success";
    }

    @RequestMapping("/add")
    public String add() {
        logger.info("add to user");
        long start = System.currentTimeMillis();
        for (int i= 0;i<100;i++) {
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
            } catch (Exception e) {
                logger.error("发生异常，保存失败");
            }
        }
        logger.info("set 100 data time :" + (System.currentTimeMillis()-start));
        return "user add success!";
    }

    /**
     *分页查询
     * @param pageNo 页码
     * @param pageSize 页码数量
     * @return
     */
    @RequestMapping("/list")
    public List<User> list(int pageNo, int pageSize){
        List<User> list = new ArrayList<>();
//        int pageNo = offset;
//        int pageSize = max;
        PageRequest pageRequest = new PageRequest(pageNo, pageSize);
        Iterable<User> iter = userService.getPageAll(pageRequest);
        iter.forEach(u -> { list.add(u); } );

        logger.info("user -== data count " + userService.getCount());
        return list;
    }

    @RequestMapping("/happy")
    public String happy(){
        return "happy";
    }



}
