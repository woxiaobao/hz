package com.hz.lvbaolin.service;

import com.hz.lvbaolin.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by master-lv on 2017/8/21.
 */
public interface PersonMongoRepository extends MongoRepository<Person, String> {

//    Person findByName(String name);
}
