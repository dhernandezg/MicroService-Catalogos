package com.baz.dtos;

import java.io.Serializable;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import lombok.Data;

@Data
public class CatalogoResponse<CATALOGO> implements Serializable {

    @Schema(example = "200", description = "Éxito")
    private String codigo;

    @Schema(example = "Transacción exitosa", description = "Resultado de la operación.")
    private String mensaje;

    @Schema(example = "Catalogo class", description = "Tipo de catalogo")
    private CATALOGO respuesta;

    public CatalogoResponse(String codigo, String mensaje, CATALOGO resultado) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.respuesta = resultado;
    }
}
