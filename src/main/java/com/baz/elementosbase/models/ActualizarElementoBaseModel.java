package com.baz.elementosbase.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActualizarElementoBaseModel {

    @Schema(description = "Identificador de la categoría.")
    private Integer idCategoria;

    @Schema(description = "Identificador del catálogo.")
    private Integer idCatalogo;

    @Schema(description = "Identificador del elemento base.")
    private Integer idElementoBase;

    @Schema(description = "Nombre del usuario que modifica el registro.")
    private String nombreUsuario;

    @Schema(description = "Valor del elemento que se registra.")
    private String valor;

    @Schema(description = "Identificador de campo del elemento que se registra.")
    private Short idCampo;

    @Schema(description = "Orden del elemento dentro del catalogo.")
    private Short orden;

    @Schema(description = "Identificador del estatus del elemento.")
    private Short idEstatus;
}
