package com.baz.dtos;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Data;

/**
 * <b>MicroservicioResponseDto<T></b>
 * @descripcion: Contiene la salida genérica para los Micro-Servicios
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Data
public class MicroservicioResponseDto extends ResponseDto {
     /**
     * Contiene el código de respuesta para la operación
     * */
    @Schema(example = "200.Catalogo-Consulta.C00000")
    protected String codigo;
}
