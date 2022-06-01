package com.baz.tipocatalogo.models;

import java.time.LocalDateTime;
import java.io.Serializable;

import javax.enterprise.inject.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <b>TipoCatalogo</b>
 * @descripcion: Entidad que representa la estructura de un tipo de catalogo
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Model
public class TipoCatalogo implements Serializable {
    /**
     * Contiene el identificador para el tipo de catalogo
     */
    @Id
    @Column(name = "tipocatid")
    private Short idTipoCatalogo;

    /**
     * Contiene el nombre para el tipo de catalogo
     */
    @Column(name = "desctipocat")
    private String nombre;

    /**
     * Contiene el identificador para el estatus del tipo de catalogo
     */
    @Column(name="statusid")
    private Short idEstatus;

    /**
     * Contiene la fecha y hora de la creación para el tipo de catalogo
     */
    @Column(name = "fechacrea")
    private LocalDateTime fechaCreacion;

    /**
     * Contiene la fecha y hora de la ultima modificación para el tipo de catalogo
     */
    @Column(name = "fechamod")
    private LocalDateTime fechaModificacion;

    /**
     * Contiene el usuario propietario del tipo de catalogo
     */
    @Column(name = "usuariocrea")
    private String usuarioCreacion;

    /**
     * Contiene el ultimo usuario que modifico el tipo de catalogo
     */
    @Column(name = "usuariomod")
    private String usuarioModificacion;
}
