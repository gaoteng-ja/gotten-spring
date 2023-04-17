package com.gotten.springframework.core.convert.converter;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/12 9:17
 * @description
 */
public interface ConverterFactory<S, R> {

    <T extends R> Converter<S, T> getConverter(Class<T> classType);
}
