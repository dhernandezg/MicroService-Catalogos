package com.baz.dtos;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Data;

/**
 * Contiene la salida genérica para los Micro-Servicios
 * */
@Data
public class MicroservicioResponseDto {
     /**
     * Contiene el código de respuesta para la operación
     * */
    @Schema(example = "200.Catalogo-Consulta.C00000")
    protected String codigo;

    /**
     * Contiene el mensaje con la descripción o resultado de la operación
     * */
    @Schema(example = "La operación fue un éxito")
    protected String mensaje;

    /**
     * Contiene el folio de identificación para la operación
     * */
    @Schema(example = "UID202218050001")
    protected String folio;

}
