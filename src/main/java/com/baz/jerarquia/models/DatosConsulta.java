package com.baz.jerarquia.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatosConsulta {
    private Integer idCategoria;
    private Integer idCatalogo;
    private Integer idJerarquia;
}
