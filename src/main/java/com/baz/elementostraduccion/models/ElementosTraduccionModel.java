package com.baz.elementostraduccion.models;

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
@Entity(name = "TAELEMENTOTRAD")
public class ElementosTraduccionModel {

    @Id
    @Schema(description = "Identificador de la categoría.")
    @Column(name = "categoriaid")
    private Integer idCategoria;

    @Schema(description = "Identificador del catálogo.")
    @Column(name = "catalogoid")
    private Integer idCatalogo;

    @Schema(description = "Identificador del elemento traducción.")
    @Column(name = "elemtradid")
    private Integer idElementoTraduccionn;

    @Schema(description = "Valor del elemento traducción.")
    @Column(name = "valor")
    private String valor;

    @Schema(description = "Identificador del campo en el registro.")
    @Column(name = "campoid")
    private Short idCampo;

    @Schema(description = "Orden del elemento traducción en el catálogo.")
    @Column(name = "orden")
    private Short orden;

    @Schema(description = "Valor de referencia del elemento base.")
    @Column(name = "valorbase")
    private String valorBase;

    @Schema(description = "Identificador del estatus del registro.")
    @Column(name = "estatusid")
    private Integer estatus;

    @Schema(description = "Fecha de creación del registro.")
    @Column(name = "fechacrea")
    private String fechaCreacion;

    @Schema(description = "Fecha de modificación del registroa.")
    @Column(name = "fechamod")
    private String fechaModificacion;

    @Schema(description = "Nombre del usuario que realizó el registro.")
    @Column(name = "usuariocrea")
    private String usuarioCreacion;

    @Schema(description = "Nombre del usuario que modificó el registro.")
    @Column(name = "usuariomod")
    private String usuarioModificacion;
}
