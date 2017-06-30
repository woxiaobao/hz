package com.hz.lvbaolin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by master-lv on 2017/6/28.
 */


@Controller
@RequestMapping(value = {"","/apidoc"})
public class ApidocController {

    @RequestMapping(value = "list")
    public String list(HttpServletRequest request){
        request.getSession().setAttribute("name","lvbaolin");
        return "apidoc/list";
    }
}
