package com.baz.categorias.dtos;

import lombok.Data;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.io.Serializable;

/**
 * <b>GenericResponse</b>
 * @descripcion: Entidad Response hacia API que contiene los parámetros de respuesta.
 * @autor: Diego Vázquez Perez
 * @ultimaModificacion: 09/05/2022
 */

@Data
public class GenericResponse<Object> implements Serializable {

    @Schema(example = "200", description = "Éxito")
    private String codigo;

    @Schema(example = "Transacción exitosa", description = "Resultado de la operación.")
    private String mensaje;

    @Schema(example = "Object", description = "Objecto de respuesta según la operación realizada")
    private Object respuesta;


    public GenericResponse(
            String codigo,
            String mensaje,
            Object clase){
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.respuesta = clase;
    }

}
