package com.gotten.springframework.test.event;

import com.gotten.springframework.context.ApplicationListener;

import java.util.Date;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/10 13:50
 * @description
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {

    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到：" + event.getSource() + "消息；时间：" + new Date());
        System.out.println("消息：" + event.getId() + ":" + event.getMessage());
    }
}
