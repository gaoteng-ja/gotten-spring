package com.gotten.springframework.context;

import com.gotten.springframework.beans.factory.HierarchicalBeanFactory;
import com.gotten.springframework.beans.factory.ListableBeanFactory;
import com.gotten.springframework.core.io.ResourceLoader;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/1 15:50
 * @description
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {

}
