package com.gotten.springframework.test.bean;

import com.gotten.springframework.beans.BeanException;
import com.gotten.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/7 13:46
 * @description
 */
public class ProxyBeanFactory implements FactoryBean<IUserDao> {

    @Override
    public IUserDao getObject() throws BeanException {
        InvocationHandler handler = ((proxy, method, args) -> {
            Map<String, String> map = new HashMap<>();

            map.put("1", "小赵");
            map.put("2", "小钱");
            map.put("3", "小孙");

            return "你被代理了 " + method.getName() + ": " + map.get(args[0].toString());
        });
        return (IUserDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IUserDao.class}, handler);
    }

    @Override
    public Class<IUserDao> getObjectType() {
        return IUserDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
