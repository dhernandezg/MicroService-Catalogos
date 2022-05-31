package com.baz.categorias.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <b>${CategoriasModel}</b>
 * @descripcion: Entidad que contiene las propiedades del cursor "TACategorìas"
 * del "CategoriasService".
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 09/05/2022
 */


@Data
@AllArgsConstructor
@Entity(name = "TACATEGORIA")
@NoArgsConstructor
public class CategoriasModel implements Serializable {

    @Schema(example = "1", description = "Identificador de la categoria.")
    @Column(name = "CATEGORIAID")
    @Id
    private Integer idCategoria;

    @Schema(example = "GEOGRAFIA", description = "Nombre de la categoria.")
    @Column(name = "DESCCATEG")
    private String descripcionCategoria;

    @Schema(example = "1", description = "ACTIVO")
    @Column(name = "ESTATUSID")
    private Integer idEstatus;

    @Schema(example = "2022-05-02 16:03:52.245", description = "Fecha de creación")
    @Column(name = "FECHACREA")
    private LocalDateTime fechaCreacion;

    @Schema(example = "2022-05-03 16:03:52.245", description = "Fecha de última modificación")
    @Column(name = "FECHAMOD")
    private LocalDateTime fechaModificacion;

    @Schema(example = "DIEGO VAZQUEZ P.", description = "Nombre del usuario que creó el registro.")
    @Column(name = "USUARIOCREA")
    private String usuarioCreacion;

    @Schema(example = "DANIEL H.", description = "Nombre del usuario que modificó el registro.")
    @Column(name = "USUARIOMOD")
    private String usuarioModificacion;

}
