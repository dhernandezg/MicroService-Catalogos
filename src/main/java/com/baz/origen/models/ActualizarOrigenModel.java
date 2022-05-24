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

    @Schema(description = "Identificador del origen a actualizar.", required = true)
    @QueryParam("idOrigen") Short idOrigen;

    @Schema(description = "Descripción del origen.")
    @QueryParam("descripcionOrigen") String descripcionOrigen;

    @Schema(description = "Clave del campo.")
    @QueryParam("claveOrigen") String claveOrigen;

    @Schema(description = "Status del origen.")
    @QueryParam("idStatus") Short idEstatus;

    @Schema(description = "Nombre del usuario que actualiza.", required = true)
    @QueryParam("usuarioNombre") String usuarioNombre;

}
