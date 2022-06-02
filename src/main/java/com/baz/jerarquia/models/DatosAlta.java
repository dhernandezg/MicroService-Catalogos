package com.baz.jerarquia.models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <b>DatosAlta</b>
 * @descripcion: Entidad que contiene los datos para el registro o alta de un catalogo
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Data
@AllArgsConstructor
public class DatosAlta {
    /**
     * Identificador de categoría
     * */
    private Integer idCategoria;

    //Identificador del catalogo
    private Integer idCatalogo;

    //Identificador del catalogo hijo
    private Integer idCatalogoHijo;

    /**
     * Nombre del catalogo
     * */
    private String nombreCatalogo;

    /**
     * Identificador del catalogo base
     * */
    private Integer idCatalogoBase;

    /**
     * Nombre del usuario
     * */
    private String usuario;
}
