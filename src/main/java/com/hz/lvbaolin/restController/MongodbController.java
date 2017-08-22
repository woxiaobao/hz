package com.hz.lvbaolin.restController;

import com.hz.lvbaolin.domain.Person;
import com.hz.lvbaolin.domain.User;
import com.hz.lvbaolin.service.PersonMongoRepository;
import com.hz.lvbaolin.utils.SerializeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by master-lv on 2017/8/18.
 */

@RestController
@RequestMapping("/mongodb")
public class MongodbController {


    protected static Logger logger = LoggerFactory.getLogger(MongodbController.class);


    @Autowired
    private MongoTemplate mongoTemplate;
//    @Autowired
//    private PersonMongoRepository personMongoRepository;

    @RequestMapping("/set")
    public String add() {
        long start = System.currentTimeMillis();
        for (long i=0;i<100;i++) {
            Person user = new Person();
//            String id = UUID.randomUUID().toString();
            user.setId(i);
            user.setUsername("person"+i);
            user.setBirthday(new Date());
            user.setPassword("111111");
            user.setPhone("18801424045");
            user.setAddress("北京朝阳");
            user.setSex("1");
            user.setToken("1234567890");
//            personMongoRepository.save(user);
            mongoTemplate.save(user);
        }
        logger.info("set 100 data time :" + (System.currentTimeMillis()-start));

        return "mongodb set ok";
    }

    @RequestMapping("get")
    public List<Person> getKey(){
        long start = System.currentTimeMillis();
        List<Person> personList = new ArrayList<>();

//        Query query=new Query(Criteria.where("username").is(username));
//        Person person =  mongoTemplate.findOne(query , Person.class);
        personList = mongoTemplate.findAll(Person.class);
        logger.info((System.currentTimeMillis()-start )+ "");
        return personList;
    }




}
