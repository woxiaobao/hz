package com.hz.lvbaolin.ws.webservice.impl;

import com.hz.lvbaolin.ws.domain.Person;
import com.hz.lvbaolin.ws.webservice.PersonService;

import javax.jws.WebService;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by master-lv on 2017/7/14.
 */
@WebService(targetNamespace="http://service.hz.lvbaolin.cn/",endpointInterface = "com.hz.lvbaolin.ws.webservice.PersonService")
public class PersonServiceImpl implements PersonService{

    private Map<Long, Person> userMap = new HashMap<Long, Person>();
    public PersonServiceImpl() {
        Person user = new Person();
        user.setUserId(10001L);
        user.setUsername("liyd1");
        user.setEmail("liyd1@qq.com");
        user.setGmtCreate(new Date());
        userMap.put(user.getUserId(), user);
        user = new Person();
        user.setUserId(10002L);
        user.setUsername("liyd2");
        user.setEmail("liyd2@qq.com");
        user.setGmtCreate(new Date());
        userMap.put(user.getUserId(), user);
        user = new Person();
        user.setUserId(10003L);
        user.setUsername("liyd3");
        user.setEmail("liyd3@qq.com");
        user.setGmtCreate(new Date());
        userMap.put(user.getUserId(), user);
    }
    @Override
    public String getName(Long userId) {
        return "liyd-" + userId;
    }

    @Override
    public Person getPerson(Long userId) {
        return userMap.get(userId);
    }
}
