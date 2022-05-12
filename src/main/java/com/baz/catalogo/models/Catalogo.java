package com.baz.catalogo.models;

import java.time.LocalDateTime;
import java.io.Serializable;

import javax.enterprise.inject.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <b>Catalogo</b>
 * @descripcion: Entidad que representa la estructura de un catalogo
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Model
public class Catalogo implements Serializable {
    /**
     * Contiene el identificador de categoría
     * */
    @Column(name = "categoriaid")
    private Integer idCategoria;

    /**
     * Contiene el identificador para el catálogos
     * */
    @Id
    @Column(name = "catalogoid")
    private Integer idCatalogo;

    /**
     * Contiene el identificador para el tipo catalogo
     * */
    @Column(name = "tipocatid")
    private Integer idTipoCatalogo;

    /**
     * Contiene la descripcion del catalogo
     * */
    @Column(name = "desccatalogo")
    private String descripcionCatalogo;

    /**
     * Contiene el identificador para el catalogo base
     * */
    @Column(name = "catalobaseid")
    private Integer idCatalogoBase;

    /**
     * Contiene el identificador para el estatus del catalogo
     * */
    @Transient
    @JsonInclude(Include.NON_NULL)
    private Integer idEstatus;

    /**
     * Contiene la fecha y hora de la ultima modificación para el catalogo
     * */
    @Column(name = "modificacion")
    private LocalDateTime ultimaModificacion;

    /**
     * Contiene el usuario propietario del catalogo
     * */
    @Column(name = "usuario")
    private String usuarioPropietario;

    /**
     * Método que crea un objeto de tipo catalogo
     * @param idCategoria    Especifica el identificador para la categoría
     * @param idCatalogo     Especifica el identificador para el catalogo
     * @param idTipoCatalogo Especifica el identificador para el tipo de catalogo
     * @param descripcion    Especifica la descripción para el catalogo
     */
    public Catalogo(Integer idCategoria, Integer idCatalogo, Integer idTipoCatalogo, String descripcion) {
        this(idCatalogo);
        this.idCategoria = idCategoria;
        this.idTipoCatalogo = idTipoCatalogo;
        this.descripcionCatalogo = descripcion;
    }

    /**
     * Método que crea un objeto de tipo catalogo
     * @param idCatalogo Especifica el identificador para el catalogo
     */
    public Catalogo(Integer idCatalogo) {
        this.idCatalogo = idCatalogo;
    }
}
