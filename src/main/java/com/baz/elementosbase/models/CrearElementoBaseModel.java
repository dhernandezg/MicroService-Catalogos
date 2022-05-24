package com.baz.elementosbase.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrearElementoBaseModel {

    @Schema(description = "Identificador de la categoría a la que pertenece el catálogo.")
    private Integer idCategoria;

    @Schema(description = "Identificador del catálogo al que pertenece el elemento.")
    private Integer idCatalogo;

    @Schema(description = "Valor del elemento dentro del catálogo.")
    private String valor;

    @Schema(description = "Identificado del campo.")
    private Short idCampo;

    @Schema(description = "Orden del elemento dentro del catálogo.")
    private Short orden;

    @Schema(description = "Nombre del usuario que realiza el registro.")
    private String nombreUsuario;
}
