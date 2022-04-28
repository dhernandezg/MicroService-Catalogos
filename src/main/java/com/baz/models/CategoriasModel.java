package com.baz.models;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * <b>${CategoriasModel}</b>
 * @descripcion: Entidad que contiene las propiedades del cursor "TACategorìas"
 * del "CategoriasService".
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 27/04/2022
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriasModel {

    @Schema(example = "1", description = "Identificador de la categoria.")
    private String idCategoria;

    @Schema(example = "GEOGRAFIA", description = "Nombre de la categoria.")
    private String descripcionCategoria;

}
