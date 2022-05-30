package com.baz.elementostraduccion.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EliminarElementoTraduccionModel {

    @Schema(description = "Identificador de la categoría", required = true)
    private Integer idCategoria;

    @Schema(description = "Identificador del catálogo", required = true)
    private Integer IdCatalogo;

    @Schema(description = "Identificador del elemento traducción", required = true)
    private Integer idElementoTrad;

    @Schema(description = "Nombre del usuario", required = true)
    private String usuario;
}
