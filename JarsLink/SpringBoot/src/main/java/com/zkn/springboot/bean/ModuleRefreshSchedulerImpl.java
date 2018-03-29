package com.zkn.springboot.bean;

import com.alipay.jarslink.api.ModuleConfig;
import com.alipay.jarslink.api.ModuleLoader;
import com.alipay.jarslink.api.ModuleManager;
import com.alipay.jarslink.api.impl.AbstractModuleRefreshScheduler;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;

/**
 * @author zkn
 * @date 2018/3/29
 */
@Component
public class ModuleRefreshSchedulerImpl extends AbstractModuleRefreshScheduler {
    /**
     * 获取模块配置信息
     *
     * @return
     */
    @Override
    public List<ModuleConfig> queryModuleConfigs() {

        return ImmutableList.of(buildModuleConfig());
    }

    private ModuleConfig buildModuleConfig() {
        URL demoModule = Thread.currentThread().getContextClassLoader().getResource("SpringBoot-0.0.1-SNAPSHOT.jar");
        ModuleConfig moduleConfig = new ModuleConfig();
        moduleConfig.setName("SpringBoot");
        moduleConfig.setEnabled(true);
        moduleConfig.setVersion("1.0.0.2018.3.29");
        moduleConfig.setModuleUrl(ImmutableList.of(demoModule));
        return moduleConfig;
    }

    @Autowired
    @Override
    public void setModuleManager(ModuleManager moduleManager) {
        super.setModuleManager(moduleManager);
    }

    @Autowired
    @Override
    public void setModuleLoader(ModuleLoader moduleLoader) {
        super.setModuleLoader(moduleLoader);
    }
}
