package com.baz.dtos;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Data;

/**
 * <b>ResponseDto<T></b>
 * @descripcion: RespuestaDto
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Data
public class ResponseDto {
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
