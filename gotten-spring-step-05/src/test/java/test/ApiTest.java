package test;

import cn.hutool.core.io.IoUtil;
import com.gotten.springframework.beans.PropertyValue;
import com.gotten.springframework.beans.PropertyValues;
import com.gotten.springframework.beans.factory.config.BeanDefinition;
import com.gotten.springframework.beans.factory.config.BeanReference;
import com.gotten.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.gotten.springframework.core.io.DefaultResourceLoader;
import com.gotten.springframework.core.io.Resource;
import org.junit.Before;
import org.junit.Test;
import test.bean.UserDao;
import test.bean.UserService;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/3/31 16:48
 * @description
 */
public class ApiTest {

    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void testClassPath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void testFile() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void testURL() {

    }
}
