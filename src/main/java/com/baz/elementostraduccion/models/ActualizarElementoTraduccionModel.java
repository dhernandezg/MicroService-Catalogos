package com.baz.elementostraduccion.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActualizarElementoTraduccionModel {

    @Schema(description = "Identificador de la categoría", required = true)
    private Integer idCategoria;

    @Schema(description = "Identificador del catálogo", required = true)
    private Integer idCatalogo;

    @Schema(description = "Identificador del elemento traducción", required = true)
    private Integer idElementoTrad;

    @Schema(description = "Nombre del usuario que modifica el registro", required = true)
    private String usuario;

    @Schema(description = "Valor a actualizar en el registro.")
    private String valor;

    @Schema(description = "Identificador del campo")
    private Short idCampo;

    @Schema(description = "Orden del registro dentro del catálogo")
    private Short orden;

    @Schema(description = "Valor base de referencia")
    private String valorBase;

    @Schema(description = "Indentificador del estatus.")
    private Short estatus;
}
