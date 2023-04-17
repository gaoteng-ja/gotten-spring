package com.gotten.springframework.core.convert.converter;

/**
 * @author gaoteng
 * @version v1.0
 * @date 2023/4/12 9:36
 * @description
 */
public interface ConverterRegistry {

    void addConverter(Converter<?, ?> converter);

    void addConverter(GenericConverter converter);

    void addConverterFactory(ConverterFactory<?, ?> converterFactory);
}
