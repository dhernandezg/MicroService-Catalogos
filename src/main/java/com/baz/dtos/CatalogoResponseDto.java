package com.baz.dtos;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import lombok.Data;

/**
 * <b>CatalogoResponseDto<T></b>
 * @descripcion: RespuestaDto para micro-servicio de catálogos
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Data
public class CatalogoResponseDto<T>{

    /**
     * Contiene el código de respuesta para la operación
     * */
    @Schema(example = "200.Catalogo-Consulta.C00000")
    private String codigo;

    /**
     * Contiene el mensaje con la descripción o resultado de la operación
     * */
    @Schema(example = "La operación fue un éxito")
    private String mensaje;

    /**
     * Contiene la respuesta genérica de la operación sobre el modulo catálogos
     * */
    @Schema()
    private T respuesta;

    /**
     * Crea un nuevo objeto de respuesta para el micro-servicio de catalogo
     * @param codigo Código Http de salida del proceso
     * @param mensaje Mensaje de éxito o ejecución
     * @param resultado Resultado de la operación
     * */
    public CatalogoResponseDto(String codigo, String mensaje, T resultado) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.respuesta = resultado;
    }
}
