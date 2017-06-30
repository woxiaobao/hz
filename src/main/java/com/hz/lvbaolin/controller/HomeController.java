package com.hz.lvbaolin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by master-lv on 2017/6/29.
 */


@Controller
@RequestMapping(value = {"","/home"})
public class HomeController {

    @RequestMapping(value = "index")
    public String index(HttpServletRequest request){
        request.getSession().setAttribute("name","lvbaolin");
        return "home/index";
    }
}
