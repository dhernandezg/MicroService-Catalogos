package com.baz.models;


import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.resource.cci.ResultSet;

public class ExistenciaCategoriasResponse {

    @Schema(example = "1", description = "Categoría existe.")
    private int existe;

    @Schema(example = "1", description = "Código de la ejecución")
    private int codigo;

    @Schema(example = "Proceso exitoso", description = "Descripción del resultado de la ejecución.")
    private String mensaje;
}
