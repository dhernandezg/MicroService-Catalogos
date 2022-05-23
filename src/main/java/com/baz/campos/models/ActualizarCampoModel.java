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

    @Schema(description = "Identificador del campo a actualizar.", required = true)
    private Short idCampo;

    @Schema(description = "Nombre del campo.")
    private String nombreCampo;

    @Schema(description = "Descripción del campo.")
    private String descripcionCampo;

    @Schema(description = "Estatus del campo.")
    private Short idEstatus;

    @Schema(description = "Nombre del usuario que actualiza.", required = true)
    private String usuarioNombre;
}
