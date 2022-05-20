package com.baz.catalogo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * <b>DatosActualizacion</b>
 * @descripcion: Entidad que contiene los datos de actualizacion de catalogos
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosActualizacion {
    /**
     * Identificador de la categoria
     * */
    private Integer idCategoria;

    /**
     * Identificador del catalogo
     * */
    private Integer idCatalogo;

    /**
     * Nombre de usuario
     * */
    private String usuario;

    /**
     * Indentificador del tipo de catalogo
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
     * Identificador del estatus del catalogo
     * */
    private Short idEstatus;
}
