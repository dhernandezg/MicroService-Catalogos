package com.baz.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * <b>StoredProcedure</b>
 * @descripcion: Representa un procedimiento o función de base de datos
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Data
public class StoredProcedure {

    /**
     * Nombre de la función o procedimiento
     * */
    private String name;

    /**
     * Contiene la lista de parámetros para el procedimiento
     * */
    @Setter(AccessLevel.PRIVATE)
    private List<ProceduredParameter> parameters;

    /**
     * Contiene el tipo de objeto esperado de la ejecución del procedimiento
     * */
    @Setter(AccessLevel.PRIVATE)
    private Class<?> outClass;

    /**
     * Crea un nuevo procedimiento
     * @param name Nombre del procedimiento o función
     * @param outClass Tipo esperado de ejecución
     * @parameters Lista de parámetros para el procedimiento
     */
    public <T> StoredProcedure(String name, Class<T> outClass, ProceduredParameter... parameters) {
        this(outClass);
        this.name = name;
        this.addParameters(parameters);
    }

    /**
     * Crea un nuevo procedimiento o función
     * @outClass Tipo esperado de la ejecución del procedimiento
     */
    public <T> StoredProcedure(Class<T> outClass) {
        this.outClass = outClass;
        this.parameters = new ArrayList<ProceduredParameter>();
    }

    /**
     * Agrega una lista de parámetros al procedimiento o función
     * @param parameters Parámetros
     */
    public void addParameters(ProceduredParameter... parameters) {
        for (ProceduredParameter proceduredParameter : parameters) {
            this.parameters.add(proceduredParameter);
            this.parameters.sort(Comparator.comparing(ProceduredParameter::getIndexParam));
        }
    }
}
