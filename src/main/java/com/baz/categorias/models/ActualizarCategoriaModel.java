package com.baz.categorias.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActualizarCategoriaModel {

    @Schema(description = "Identificador de la categoria a actualizar", required = true)
    private Integer idCategoria;

    @Schema(description = "Nombre de la categoría.")
    private String descripcionCategoria;

    @Schema(description = "Identificador del estatus.")
    private Integer idEstatus;

    @Schema(description = "Nombre del usuario")
    private String usuarioNombre;

}
