package com.baz.catalogo.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DatosAlta {
    private Integer idCategoria;
    private Short idTipoCatalogo;
    private String nombreCatalogo;
    private Integer idCatalogoBase;
    private String usuario;
}
