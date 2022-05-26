package com.baz.dtos;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <b>CatalogoResponseDto<T></b>
 * @descripcion: RespuestaDto para micro-servicio de catálogos
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CatalogoResponseDto<T> extends MicroservicioResponseDto {
    /**
     * Contiene la respuesta genérica de la operación sobre el modulo catálogos
     */
    @Schema()
    private T respuesta;

    /**
     * Crea un nuevo objeto de respuesta para el micro-servicio de catalogo
     * @param codigo    Código Http de salida del proceso
     * @param mensaje   Mensaje de éxito o ejecución
     * @param resultado Resultado de la operación
     */
    public CatalogoResponseDto(String codigo, String mensaje, T resultado) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.respuesta = resultado;
    }
}
