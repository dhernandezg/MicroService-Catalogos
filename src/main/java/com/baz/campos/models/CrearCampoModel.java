package com.baz.campos.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.ws.rs.QueryParam;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrearCampoModel {

    @Schema(description = "Nombre del campo.", required = true)
    private String nombreCampo;

    @Schema(description = "Descripción del campo.", required = true)
    private String descripcionCampo;

    @Schema(description = "Nombre del usuario que realiza el registro.", required = true)
    private String usuarioNombre;
}
