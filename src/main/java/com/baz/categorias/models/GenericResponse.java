package com.baz.categorias.models;

import lombok.Data;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.io.Serializable;

@Data
public class GenericResponse implements Serializable {

    @Schema(example = "200", description = "Éxito")
    private String codigo;

    @Schema(example = "Transacción exitosa", description = "Resultado de la operación.")
    private String mensaje;

    @Schema(example = "Categorias class", description = "Éxito")
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
