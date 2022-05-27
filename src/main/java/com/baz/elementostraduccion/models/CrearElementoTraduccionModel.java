package com.baz.elementostraduccion.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrearElementoTraduccionModel {

    @Schema(description = "Identificador de la categoria a la que pertenece el catálogo.", required = true)
    private Integer idCategoria;

    @Schema(description = "Identificador del catálogo al que pertenece el elemento traducción.", required = true)
    private Integer idCatalogo;

    @Schema(description = "Valor del elemento traducción que se registra", required = true)
    private String valor;

    @Schema(description = "Identificador del tipo de campo que se registra.", required = true)
    private Short idCampo;

    @Schema(description = "Orden del elemento traducción que se registra dentro del catálogo traducción.", required = true)
    private Short orden;

    @Schema(description = "Valor del elemento base al que hace referencia.", required = true)
    private String valorBase;

    @Schema(description = "Nombre del usuario que realiza el registro.", required = true)
    private String usuarioNombre;
}
