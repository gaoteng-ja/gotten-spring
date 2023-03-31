package test;

import com.gotten.springframework.beans.factory.config.BeanDefinition;
import com.gotten.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;
import test.bean.UserService;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/3/31 16:48
 * @description
 */
public class ApiTest {

    @Test
    public void testBeanFactory() {

        //1.初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //2.注册bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        //3.第一次获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

        //4.第二次获取bean from singleton
        UserService userServiceSingleton = (UserService) beanFactory.getBean("userService");
        userServiceSingleton.queryUserInfo();


    }
}
