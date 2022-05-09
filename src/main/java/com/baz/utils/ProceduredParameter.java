package com.baz.utils;

import javax.persistence.ParameterMode;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProceduredParameter {
    private String name;
    private Object value;
    private ParameterMode direction;
    private Class<?> type;
    private Integer indexParam;

    public <T> ProceduredParameter(Integer index, String name, T value, Class<T> typeClass) {
        this(name, value, ParameterMode.IN, typeClass, index);
    }
}
