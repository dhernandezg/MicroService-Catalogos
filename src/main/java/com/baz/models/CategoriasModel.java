package com.baz.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
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
@Entity
@NoArgsConstructor
public class CategoriasModel extends PanacheEntity {

    @Schema(example = "1", description = "Identificador de la categoria.")
    private String idCategoria;

    @Schema(example = "GEOGRAFIA", description = "Nombre de la categoria.")
    private String descripcionCategoria;

    //Constructor de la clase
    public CategoriasModel(String idCategoria, String descripcionCategoria){
        this.idCategoria = idCategoria;
        this.descripcionCategoria = descripcionCategoria;
    }

}
