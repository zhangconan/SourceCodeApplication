package com.zkn.learn.action;

import com.alipay.jarslink.api.Action;
import org.springframework.stereotype.Component;

/**
 * @author zkn
 * @date 2018/4/12
 */
@Component
public class FirstAction implements Action<String, String> {

    /**
     * 处理请求
     *
     * @param actionRequest 请求对象
     * @return 响应对象
     */
    @Override
    public String execute(String actionRequest) {
        return actionRequest;
    }

    /**
     * 获取Action名称
     *
     * @return Action名称, 忽略大小写
     */
    @Override
    public String getActionName() {
        return "firstAction";
    }
}
