package com.baz.catalogo.models;

import java.time.LocalDateTime;

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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Model
public class Catalogo {
    @Column(name = "categoriaid")
    private Integer idCategoria;

    @Id
    @Column(name = "catalogoid")
    private Integer idCatalogo;

    @Column(name = "tipocatid")
    private Integer idTipoCatalogo;

    @Column(name = "desccatalogo")
    private String descripcionCatalogo;

    @Column(name = "catalobaseid")
    private Integer idCatalogoBase;

    @Transient
    @JsonInclude(Include.NON_NULL)
    private Integer idEstatus;

    @Column(name = "modificacion")
    private LocalDateTime ultimaModificacion;

    @Column(name = "usuario")
    private String usuarioPropietario;

    public Catalogo(Integer idCategoria, Integer idCatalogo, Integer idTipoCatalogo, String descripcion) {
        this(idCatalogo);
        this.idCategoria = idCategoria;
        this.idTipoCatalogo = idTipoCatalogo;
        this.descripcionCatalogo = descripcion;
    }

    public Catalogo(Integer idCatalogo) {
        this.idCatalogo = idCatalogo;
    }
}
