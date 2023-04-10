package com.gotten.springframework.test.event;

import com.gotten.springframework.context.ApplicationListener;
import com.gotten.springframework.context.event.ContextCloseEvent;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/10 14:02
 * @description
 */
public class ContextCloseEventListener implements ApplicationListener<ContextCloseEvent> {

    @Override
    public void onApplicationEvent(ContextCloseEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName());
    }
}
