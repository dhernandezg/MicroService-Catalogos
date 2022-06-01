package com.baz.origen.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.ws.rs.QueryParam;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActualizarOrigenModel {

    @Schema(description = "Identificador del origen.", required = true)
    @QueryParam("id") Short id;

    @Schema(description = "Descripción del origen.")
    @QueryParam("descripcion") String descripcion;

    @Schema(description = "Clave del origen.")
    @QueryParam("clave") String clave;

    @Schema(description = "Estatus del origen.")
    @QueryParam("estatus") Short estatus;

    @Schema(description = "Nombre del usuario.", required = true)
    @QueryParam("usuario") String usuario;

}
