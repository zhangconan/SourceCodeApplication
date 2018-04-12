package com.zkn.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zkn on 2018/3/11.
 */
public class FirstController {

    @GetMapping("index")
    public String helloWorld() {

        return "HelloWorld!";
    }
}
