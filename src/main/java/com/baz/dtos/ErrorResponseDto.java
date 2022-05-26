package com.baz.dtos;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;

/**
 * <b>ErrorResponseDto<T></b>
 * @descripcion: Contiene la respuesta con error para el Microservicio
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ErrorResponseDto extends MicroservicioResponseDto {
    private String info;

    @Setter(AccessLevel.PROTECTED)
    private List<String> detalles;

    @Getter(AccessLevel.PRIVATE)
    private final String FOLIO_DEFAULT = "UID000000000000";

    public ErrorResponseDto() {
        detalles = new ArrayList<String>();
        folio = FOLIO_DEFAULT;
    }

    public String getInfo() {
        return String.format("%s%s", info, codigo);
    }

    public void agregarDetalles(String... detalles) {
        for (String detalle : detalles) {
            this.detalles.add(detalle);
        }
    }
}
