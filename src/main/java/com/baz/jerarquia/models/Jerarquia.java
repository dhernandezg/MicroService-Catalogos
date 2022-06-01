package com.baz.jerarquia.models;
import java.io.Serializable;
import java.time.LocalDateTime;

import javax.enterprise.inject.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <b>Jerarquia</b>
 * @descripcion: Entidad que representa la estructura de una jerarquia entre catalogos
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Model
public class Jerarquia implements Serializable {
    @Id
    @Column(name = "categoriaid")
    private Integer idCategoria;

    @Id
    @Column(name = "catalogoid")
    private Integer idCatalogo;

    @Id
    @Column(name = "catjerarqid")
    private Integer idJerarquia;

    @Column(name = "elembaseid")
    private Integer idElementoBase;

    @Column(name = "statusid")
    private short Estatus;

    @Column(name = "fechacrea")
    private LocalDateTime fechaCreacion;

    @Column(name = "fechamod")
    private LocalDateTime fechaModificacion;

    @Column(name = "usuariocrea")
    private String usuarioCreacion;

    @Column(name = "usuariomod")
    private String usuarioModificacion;

}
