package com.baz.catalogo.models;

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
     * Identificador de categoria
     * */
    private Integer idCategoria;
    
    /**
     * Identificador de tipo de catalogo
     * */
    private Short idTipoCatalogo;

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
