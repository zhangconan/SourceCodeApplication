package com.zkn.springboot.controller;

import com.alipay.jarslink.api.Action;
import com.alipay.jarslink.api.Module;
import com.alipay.jarslink.api.ModuleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zkn on 2018/3/11.
 */
@RestController
public class FirstController {

    @Autowired
    private ModuleManager moduleManager;

    @GetMapping("index")
    public String helloWorld() {

        return "我是MainWeb!";
    }

    @GetMapping("jarlink/{module}/{action}/{param}")
    public Object processRequest(@PathVariable String module, @PathVariable String action, @PathVariable String param) {
        //根据模块名查找模块信息
        Module module1 = moduleManager.find(module);
        Action ac = module1.getAction(action);
        return ac.execute(param);
    }
}
