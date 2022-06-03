package com.baz.tipocatalogo.models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <b>DatosConsulta</b>
 * @descripcion: Entidad que contiene los datos de consulta para el tipo de catalogo
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Data
@AllArgsConstructor
public class DatosConsulta {
    /**
     * Contiene el id del tipo de catalogo
     */
    private Short idTipoCatalogo;

    /**
     * Contiene la descripción del tipo de catalogo
     */
    private String tipoCatalogo;
}
