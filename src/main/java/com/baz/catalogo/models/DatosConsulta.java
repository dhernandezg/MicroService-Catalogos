package com.baz.catalogo.models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <b>DatosConsulta</b>
 * @descripcion: Entidad que contiene los datos de consulta
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Data
@AllArgsConstructor
public class DatosConsulta {
    /**
     * Contiene el id de categoría
     * */
    private Integer idCategoria;

    /**
     * Contiene el id de catalogo
     * */
    private Integer idCatalogo;

    /**
     * Contiene el nombre del catalogo
     * */
    private String nombreCatalogo;

    /**
     * Crea un dato de consulta con el identificador catalogo
     * */
    public DatosConsulta(int idCatalogo) {
        this.idCatalogo = idCatalogo;
    }
}
