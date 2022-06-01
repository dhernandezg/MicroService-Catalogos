package com.baz.tipocatalogo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * <b>DatosActualizacion</b>
 * @descripcion: Entidad que contiene los datos de actualización de los tipos de catálogos
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosActualizacion {
    /**
     * Identificador del tipo de catalogo
     * */
    private Integer idTipoCatalogo;

    /**
     * Descripción del tipo de catalogo
     * */
    private String tipoCatalogo;

    /**
     * Nombre de usuario
     * */
    private String usuario;

    /**
     * Identificador del estatus del catalogo
     * */
    private Short idEstatus;
}
