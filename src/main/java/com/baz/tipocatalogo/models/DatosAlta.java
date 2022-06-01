package com.baz.tipocatalogo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <b>DatosAlta</b>
 * @descripcion: Entidad que contiene los datos para el registro o alta de un tipo de catalogo
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosAlta {

    /**
     * Nombre del tipo de catalogo
     * */
    private String tipoCatalogo;

    /**
     * Nombre del usuario que da de alta
     * */
    private String usuario;
}
