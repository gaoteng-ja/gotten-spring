package com.gotten.springframework.test.event;

import com.gotten.springframework.context.ApplicationListener;
import com.gotten.springframework.context.event.ContextRefreshEvent;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/10 14:01
 * @description
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshEvent event) {
        System.out.println("刷新事件：" + this.getClass().getName());
    }
}
