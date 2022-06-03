package com.baz.catalogo.models;

import javax.validation.constraints.NotNull;

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
     */
    @NotNull
    private Integer idCategoria;

    /**
     * Identificador de tipo de catalogo
     */
    private Short idTipoCatalogo;

    /**
     * Nombre del catalogo
     */
    @NotNull
    private String nombreCatalogo;

    /**
     * Identificador del catalogo base
     */
    private Integer idCatalogoBase;

    /**
     * Nombre del usuario
     */
    @NotNull
    private String usuario;
}
