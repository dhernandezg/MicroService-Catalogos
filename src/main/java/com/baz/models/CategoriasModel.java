package com.baz.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.Entity;

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
    private int idCategoria;

    @Schema(example = "GEOGRAFIA", description = "Nombre de la categoria.")
    private String descripcionCategoria;

    @Schema(example = "1", description = "ACTIVO")
    private int idStatus;

    @Schema(example = "2022-05-02 16:03:52.245", description = "Fecha de última modificación")
    private String fechaModificacion;

    @Schema(example = "DIEGO VAZQUEZ P.", description = "Nombre del usuario.")
    private String nombreUsuario;

    //Constructor de la clase
    public CategoriasModel(
            int idCategoria,
            String descripcionCategoria,
            int idStatus,
            String fechaModificacion,
            String nombreUsuario
    ){
        this.idCategoria = idCategoria;
        this.descripcionCategoria = descripcionCategoria;
        this.idStatus = idStatus;
        this.fechaModificacion = fechaModificacion;
        this.nombreUsuario = nombreUsuario;
    }

}
