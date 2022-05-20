package com.baz.catalogo.models;

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
    @Id
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
    private Short idTipoCatalogo;

    /**
     * Contiene la descripcion del catalogo
     * */
    @Column(name = "desccatalogo")
    private String nombreCatalogo;

    /**
     * Contiene el identificador para el catalogo base
     * */
    @Column(name = "catalobaseid")
    private Integer idCatalogoBase;

    /**
     * Contiene el identificador para el estatus del catalogo
     * */
    @Column(name="statusid")
    private Short idEstatus;

    /**
     * Contiene la fecha y hora de la creación para el catalogo
     * */
    @Column(name = "fechacrea")
    private LocalDateTime fechaCreacion;

    /**
     * Contiene la fecha y hora de la ultima modificación para el catalogo
     * */
    @Column(name = "fechamod")
    private LocalDateTime fechaModificacion;

    /**
     * Contiene el usuario propietario del catalogo
     * */
    @Column(name = "usuariocrea")
    private String usuarioCreacion;

        /**
     * Contiene el usuario propietario del catalogo
     * */
    @Column(name = "usuariomod")
    private String usuarioModificacion;

    /**
     * Método que crea un objeto de tipo catalogo
     * @param idCategoria    Especifica el identificador para la categoría
     * @param idCatalogo     Especifica el identificador para el catalogo
     * @param descripcion    Especifica la descripción para el catalogo
     */
    public Catalogo(Integer idCategoria, Integer idCatalogo, String descripcion) {
        this(idCatalogo);
        this.idCategoria = idCategoria;
        this.nombreCatalogo = descripcion;
    }

    /**
     * Método que crea un objeto de tipo catalogo
     * @param idCatalogo Especifica el identificador para el catalogo
     */
    public Catalogo(Integer idCatalogo) {
        this.idCatalogo = idCatalogo;
    }
}
