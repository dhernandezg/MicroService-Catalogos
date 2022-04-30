package com.baz.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * <b>${CategoriasModel}</b>
 * @descripcion: Entidad que contiene las propiedades del cursor "TACategorìas"
 * del "CategoriasService".
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 28/04/2022
 */

@Data
@NoArgsConstructor
public class CategoriasModel implements Serializable {

    @Id
    @Schema(example = "1", description = "Identificador de la categoria.")
    private String idCategoria;

    @Schema(example = "GEOGRAFIA", description = "Nombre de la categoria.")
    private String descripcionCategoria;

    public CategoriasModel(String idCategoria, String descripcionCategoria){
        this.idCategoria = idCategoria;
        this.descripcionCategoria = descripcionCategoria;
    }

}
