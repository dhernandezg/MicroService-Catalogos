package com.baz.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <b>${CategoriasModel}</b>
 * @descripcion: Entidad que contiene las propiedades del cursor "TACategorìas"
 * del "CategoriasService".
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 05/05/2022
 */


@Data
@Entity(name = "TACATEGORIA")
@Table(name = "TACATEGORIA")
@NoArgsConstructor
public class CategoriasModel implements Serializable {

    @Schema(example = "1", description = "Identificador de la categoria.")
    @Column(name = "FICATEGORIAID")
    @Id
    private BigDecimal idCategoria;

    @Schema(example = "GEOGRAFIA", description = "Nombre de la categoria.")
    @Column(name = "FCDESCCATEG")
    private String descripcionCategoria;

    @Schema(example = "1", description = "ACTIVO")
    @Column(name = "FISTATUSID")
    private BigDecimal idStatus;
/*
    @Schema(example = "2022-05-02 16:03:52.245", description = "Fecha de última modificación")
    @Column(name = "FDMODIFICACION")
    private LocalDateTime fechaModificacion;*/

    @Schema(example = "DIEGO VAZQUEZ P.", description = "Nombre del usuario.")
    @Column(name = "FCUSUARIO")
    private String nombreUsuario;

    //Constructor de la clase
    public CategoriasModel(
            BigDecimal idCategoria,
            String descripcionCategoria,
            BigDecimal idStatus,
            //LocalDateTime fechaModificacion,
            String nombreUsuario
    ){
        this.idCategoria = idCategoria;
        this.descripcionCategoria = descripcionCategoria;
        this.idStatus = idStatus;
        //this.fechaModificacion = fechaModificacion;
        this.nombreUsuario = nombreUsuario;
    }

}
