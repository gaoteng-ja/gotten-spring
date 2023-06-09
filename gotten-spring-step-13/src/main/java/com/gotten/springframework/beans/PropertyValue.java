package com.gotten.springframework.beans;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/1 9:52
 * @description
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
