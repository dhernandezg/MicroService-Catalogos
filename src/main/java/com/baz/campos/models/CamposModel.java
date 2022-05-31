package com.baz.campos.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <b>CamposModel</b>
 * @descripcion: Entidad que contiene las propiedades del cursor "TACAMPO".
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 19/05/2022
 */

@Data
@Entity
@Table
@NoArgsConstructor
public class CamposModel implements Serializable {

    @Schema(example = "1", description = "Identificador de campo.")
    @Column(name = "CAMPOID")
    @Id
    private Integer idCampo;

    @Schema(example = "ID", description = "Nombre del campo.")
    @Column(name = "CAMPO")
    private String nombreCampo;

    @Schema(example = "IDENTIFICADOR", description = "Descripción del campo.")
    @Column(name = "desccampo")
    private String descripcionCampo;

    @Schema(example = "1", description = "Identificador del estatus del campo.")
    @Column(name = "ESTATUSID")
    private Integer idStatus;

    @Schema(example = "2022-05-18 19:00:00-000", description = "Fecha de creación del campo.")
    @Column(name = "FECHACREA")
    private LocalDateTime fechaCrea;

    @Schema(example = "2022-05-19 19:00:00-000", description = "Fecha de última modificaciñon del campo.")
    @Column(name = "FECHAMOD")
    private LocalDateTime fechaMod;

    @Schema(example = "Daniel Hernandez", description = "Nombre del usuario que generó el registro.")
    @Column(name = "USUARIOCREA")
    private String usuarioCreacion;

    @Schema(example = "Diego Vaz Pez", description = "Nombre del usuario que modificó el registro.")
    @Column(name = "USUARIOMOD")
    private String usuarioModificaciñon;
}
