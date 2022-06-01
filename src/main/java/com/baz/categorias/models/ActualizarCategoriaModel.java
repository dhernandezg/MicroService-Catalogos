package com.baz.categorias.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActualizarCategoriaModel {

    @Schema(description = "Identificador de la categoria.", required = true)
    private Integer id;

    @Schema(description = "Nombre de la categoría.")
    private String descripcion;

    @Schema(description = "Identificador del estatus.")
    private Integer estatus;

    @Schema(description = "Nombre del usuario.", required = true)
    private String usuario;

}
