package com.yy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*********************************************************
 ** HelloController 用于接口测试的controller
 ** <br><br>
 ** @ClassName: HelloController
 ** @author: yangfeng
 ** @date: 2025/7/16 14:08
 ** @version: 1.0.0
 *********************************************************/
@RestController
public class HelloController {
    @GetMapping("/hello")
    private String hello(){
        return "Hello, World!";
    }
}
