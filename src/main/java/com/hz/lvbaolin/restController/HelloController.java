package com.hz.lvbaolin.restController;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by master-lv on 2017/6/27.
 */

@RestController
public class HelloController {

    protected static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello")
    public String index() {
        logger.info("baolin hello everyone!!!---");
        return "Greetings from Spring Boot!";
    }
}
