package com.baz.elementosbase.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EliminarElementoBaseModel {

    @Schema(description = "Identificador de la categoría a la que pertenece el catálogo.")
    private Integer idCategoria;

    @Schema(description = "Identificador del catálogo al que pertenece el elemento base.")
    private Integer idCatalogo;

    @Schema(description = "Identificador del elemento base.")
    private Integer idElementoBase;

    @Schema(description = "Nombre del usuario que realizar la eliminación del registro.")
    private String usuarioNombre;
}
