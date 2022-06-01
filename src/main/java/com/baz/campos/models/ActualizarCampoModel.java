package com.baz.campos.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.ws.rs.QueryParam;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActualizarCampoModel {

    @Schema(description = "Identificador del campo", required = true)
    private Short id;

    @Schema(description = "Nombre del campo.")
    private String campo;

    @Schema(description = "Descripción del campo.")
    private String descripcion;

    @Schema(description = "Estatus del campo.")
    private Short estatus;

    @Schema(description = "Nombre del usuario.", required = true)
    private String usuario;
}
