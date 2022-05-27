package com.baz.elementostraduccion.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElementosTraduccionModel {

    @Schema(description = "Identificador de la categoría.")
    private Integer idCategoria;

    @Schema(description = "Identificador de la categoría.")
    private Integer idCatalogo;

    @Schema(description = "Identificador de la categoría.")
    private Integer idElementoTraduccionn;

    @Schema(description = "Identificador de la categoría.")
    private String valor;

    @Schema(description = "Identificador de la categoría.")
    private Short idCampo;

    @Schema(description = "Identificador de la categoría.")
    private Short orden;

    @Schema(description = "Identificador de la categoría.")
    private String valorBase;

    @Schema(description = "Identificador de la categoría.")
    private Integer idEstatus;

    @Schema(description = "Identificador de la categoría.")
    private String fechaCreacion;

    private String fechaModificacion;

    @Schema(description = "Identificador de la categoría.")
    private String usuarioCreacion;

    @Schema(description = "Identificador de la categoría.")
    private String usuarioModificacion;
}
