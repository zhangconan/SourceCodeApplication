package com.zkn.springboot.bean;

import com.alipay.jarslink.api.ModuleConfig;
import com.alipay.jarslink.api.ModuleLoader;
import com.alipay.jarslink.api.ModuleManager;
import com.alipay.jarslink.api.impl.AbstractModuleRefreshScheduler;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
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

        return ImmutableList.of(buildSpringBootModule(), buildSpringMVCModule());
    }

    /**
     * 构建SpringBoot模块
     *
     * @return
     */
    private ModuleConfig buildSpringBootModule() {
        return buildModuleConfig("D:\\CUST\\workspace\\SourceCodeApplication\\JarsLink\\SpringBoot\\target\\SpringBoot-0.0.1-SNAPSHOT.jar", "SpringBoot", "0.0.1-SNAPSHOT");
    }

    /**
     * 构建SpringMVC模块
     *
     * @return
     */
    private ModuleConfig buildSpringMVCModule() {
        return buildModuleConfig("D:\\CUST\\workspace\\SourceCodeApplication\\JarsLink\\SpringMVC\\target\\SpringMVC.war", "SpringMVC", "0.0.1-SNAPSHOT");
    }

    private ModuleConfig buildModuleConfig(String path, String name, String version) {
        ModuleConfig moduleConfig = new ModuleConfig();
        try {
            URL demoModule = new URL("file", "", -1, path);
            moduleConfig.setName(name);
            moduleConfig.setEnabled(true);
            moduleConfig.setVersion(version);
            moduleConfig.setModuleUrl(ImmutableList.of(demoModule));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
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
