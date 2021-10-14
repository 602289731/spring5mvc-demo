package com.zhaoxi.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Retention;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangxia
 * @create 2021-10-08 21:04
 * @className: com.zhaoxi.controller.TestController
 * @description: TODO
 */

// @RestController
@Controller
@RequestMapping("test")
public class TestController {
    // 使用自定义的日期binder
    @InitBinder
    public  void initBinder(WebDataBinder binder, HttpServletRequest request){
        System.out.println(request.getParameter("date"));
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("MM-dd-yyyy"),false));
    }

    @GetMapping("show")
    public String test(){
        return "this is springmvc application";
    }

    @GetMapping({"hello","index"})
    public String hello(){
        return "Hello";
    }


}
