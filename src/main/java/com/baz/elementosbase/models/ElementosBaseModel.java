package com.baz.elementosbase.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TAELEMENTOSBASE")
public class ElementosBaseModel {

    @Id
    @Column(name = "categoriaid")
    @Schema(description = "Identificador de la categoría")
    private Integer idCategoria;

    @Column(name = "catalogoid")
    @Schema(description = "Identificador del catálogo")
    private Integer idCatalogo;

    @Column(name = "elembaseid")
    @Schema(description = "Identificador del elemento base")
    private Integer idElementoBase;

    @Column(name = "valor")
    @Schema(description = "Descripción del elemento base")
    private String valor;

    @Column(name = "campoid")
    @Schema(description = "Identificador del campo")
    private Integer idCampo;

    @Column(name = "orden")
    @Schema(description = "Orden de los elementos en la entidad")
    private Integer orden;

    @Column(name = "estatusid")
    @Schema(description = "Identificador del estatus")
    private Integer estatus;

    @Column(name = "fechacrea")
    @Schema(description = "Fecha de creación del elemento base")
    private String fechaCreacion;

    @Column(name = "fechamod")
    @Schema(description = "Fecha de última modificación del elemento base")
    private String fechaModificacion;

    @Column(name = "usuariocrea")
    @Schema(description = "Nombre del usuario que registró el elemento base")
    private String usuarioCreacion;

    @Column(name = "usuariomod")
    @Schema(description = "Nombre del usuario que modificació el registro del elemento base")
    private String usuarioModificacion;

}
