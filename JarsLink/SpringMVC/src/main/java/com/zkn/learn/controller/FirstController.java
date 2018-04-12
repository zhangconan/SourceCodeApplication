package com.zkn.learn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zkn
 * @date 2018/4/12
 */
@RestController
@RequestMapping("first")
public class FirstController {

    @RequestMapping("firstRequest")
    public String firstRequest() {
        return "firstRequest";
    }
}
