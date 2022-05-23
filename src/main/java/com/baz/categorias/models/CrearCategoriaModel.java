package com.baz.categorias.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrearCategoriaModel {

    /**
     * Nombre de la categoria
     * */
    @Schema(required = true, description = "Nombre de la categoria a registrar.")
    private String descripcionCategoria;

    /**
     * Nombre del usuario que registra la categoria
     * */
    @Schema(required = true, description = "Nombre del usuario que registra.")
    private String nombreUsuario;
}
