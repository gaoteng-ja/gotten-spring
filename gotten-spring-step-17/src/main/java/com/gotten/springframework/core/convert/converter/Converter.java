package com.gotten.springframework.core.convert.converter;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/12 9:15
 * @description
 */
public interface Converter<S, T> {

    T convert(S source);
}
