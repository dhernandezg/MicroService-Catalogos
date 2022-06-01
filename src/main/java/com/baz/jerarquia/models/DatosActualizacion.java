package com.baz.jerarquia.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <b>DatosActualizacion</b>
 * @descripcion: Entidad que contiene los datos de actualización de jerarquias
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosActualizacion {
    /**
     * Identificador de la categoría
    */
    private Integer idCategoria;

    /**
     * Identificador del catalogo
    */
    private Integer idCatalogo;

    /**
     * Identificador de la jerarquia
    */
    private Integer idJerarquia;

    /**
     * Nombre de usuario
    */
    private String usuario;
    /**
     * Identificador del elemento base
     * */
    private Integer idElementoBase;

    /**
     * Identificador del estatus del catalogo
    */
    private Short idEstatus;
}
