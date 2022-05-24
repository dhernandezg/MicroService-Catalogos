package com.baz.elementosbase.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TAELEMENTOSBASE")
public class ElementosBaseModel {

    @Id
    @Schema(description = "Identificador de la categoría")
    private Integer idCategoria;

    @Schema(description = "Identificador del catálogo")
    private Integer idCatalogo;

    @Schema(description = "Identificador del elemento base")
    private Integer idElementoBase;

    @Schema(description = "Descripción del elemento base")
    private String valor;

    @Schema(description = "Identificador del campo")
    private Integer idCampo;

    @Schema(description = "Orden de los elementos en la entidad")
    private Integer orden;

    @Schema(description = "Identificador del estatus")
    private Integer idEstatus;

    @Schema(description = "Fecha de creación del elemento base")
    private String fechaCreacion;

    @Schema(description = "Fecha de última modificación del elemento base")
    private String fechaModificacion;

    @Schema(description = "Nombre del usuario que registró el elemento base")
    private String usuarioCreacion;

    @Schema(description = "Nombre del usuario que modificació el registro del elemento base")
    private String usuarioModificacion;

}
