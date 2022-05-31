package com.baz.estatus.models;

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
@Entity(name = "TAESTATUS")
public class EstatusModel {

    @Schema(description = "Identificador del estatus.")
    @Column(name = "estatusid")
    @Id
    private Integer idEstatus;

    @Schema(description = "Descripción del estatus.")
    @Column(name = "descestatus")
    private String descripcionEstatus;

    @Schema(description = "Fecha de creación del estatus.")
    @Column(name = "fechacrea")
    private String fechaCreacion;

    @Schema(description = "Fecha de modificación del estatus.")
    @Column(name = "fechamod")
    private String fechaModificacion;

    @Schema(description = "Nombre del usuario que registró el estatus.")
    @Column(name = "usuariocrea")
    private String usuarioCreacion;

    @Schema(description = "Nombre del usuario que modificó el estatus.")
    @Column(name = "usuariomod")
    private String usuarioModificacion;
}
