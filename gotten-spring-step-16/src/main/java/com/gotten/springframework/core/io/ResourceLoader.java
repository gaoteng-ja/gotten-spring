package com.gotten.springframework.core.io;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/1 11:07
 * @description
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
