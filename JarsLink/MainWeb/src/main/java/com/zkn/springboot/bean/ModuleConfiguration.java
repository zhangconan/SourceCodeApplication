package com.zkn.springboot.bean;

import com.alipay.jarslink.api.ModuleLoader;
import com.alipay.jarslink.api.ModuleManager;
import com.alipay.jarslink.api.ModuleService;
import com.alipay.jarslink.api.impl.ModuleLoaderImpl;
import com.alipay.jarslink.api.impl.ModuleManagerImpl;
import com.alipay.jarslink.api.impl.ModuleServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zkn
 * @date 2018/4/12
 */
@Configuration
public class ModuleConfiguration {

    @Bean
    public ModuleLoader moduleLoader() {
        return new ModuleLoaderImpl();
    }

    @Bean
    public ModuleManager moduleManager() {
        return new ModuleManagerImpl();
    }

    @Bean
    public ModuleService moduleService() {
        ModuleServiceImpl moduleService = new ModuleServiceImpl();
        moduleService.setModuleLoader(moduleLoader());
        moduleService.setModuleManager(moduleManager());
        return moduleService;
    }
}
