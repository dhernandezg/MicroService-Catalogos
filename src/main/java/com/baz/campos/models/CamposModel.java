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
 * @ultimaModificacion: 10/09/2022
 */

@Data
@Entity
@Table
@NoArgsConstructor
public class CamposModel implements Serializable {

    @Schema(example = "1", description = "Identificador de campo.")
    @Column(name = "campoid")
    @Id
    private Integer idCampo;

    @Schema(example = "SIMBOLO", description = "Descripción del campo.")
    @Column(name = "desccampo")
    private String descripcionCampo;

    @Schema(example = "1", description = "Identificador del status del campo.")
    @Column(name = "statusid")
    private Integer idStatus;

    @Schema(example = "1", description = "Fecha de última modificaciñon del campo.")
    @Column(name = "modificacion")
    private LocalDateTime fechaModificacion;

    @Schema(example = "Daniel Hernandez", description = "NOmbre del usuario.")
    @Column(name = "usuario")
    private Integer usuarioNombre;
}
