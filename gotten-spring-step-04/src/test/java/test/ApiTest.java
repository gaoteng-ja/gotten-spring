package test;

import com.gotten.springframework.beans.PropertyValue;
import com.gotten.springframework.beans.PropertyValues;
import com.gotten.springframework.beans.factory.config.BeanDefinition;
import com.gotten.springframework.beans.factory.config.BeanReference;
import com.gotten.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;
import test.bean.UserDao;
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

        //2.注册UserDao
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        //3.UserService设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("userId", 1));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        //4.UserService注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        //5.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();


    }
}
