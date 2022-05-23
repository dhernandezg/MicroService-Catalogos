package com.baz.utils;

import javax.persistence.ParameterMode;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <b>ProceduredParameter</b>
 * @descripcion: Parámetro de un procedimiento de base de datos
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Data
@AllArgsConstructor
public class ProceduredParameter {
    /**
     * Nombre del parámetro
     * */
    private String name;

    /**
     * Valor del parámetro
     * */
    private Object value;

    /**
     * Dirección del parámetro
     * */
    private ParameterMode direction;

    /**
     * Tipo del parámetro
     * */
    private Class<?> type;

    /**
     * Indice del parámetro
     * */
    private Integer indexParam;

    /**
     * Crea un nuevo parámetro para un procedimiento de base de datos
     * @param index Indice de agregación del parámetro
     * @param name Nombre del parámetro
     * @param value Valor del parámetro
     * @param typeClass Tipo para el valor del parámetro
     * */
    public <T> ProceduredParameter(Integer index, String name, T value, Class<T> typeClass) {
        this(name, value, ParameterMode.IN, typeClass, index);
    }
}
