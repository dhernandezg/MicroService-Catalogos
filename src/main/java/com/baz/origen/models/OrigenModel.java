package com.baz.origen.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class OrigenModel implements Serializable {

    @Schema(example = "1", description = "Identificador del origen.")
    @Column(name = "origenid")
    @Id
    private Integer idOrigen;

    @Schema(example = "Inteligencia de Datos e Innovación", description = "Descripción del origen.")
    @Column(name = "descorigen")
    private String descripcionOrigen;

    @Schema(example = "IDI", description = "Clave del origen.")
    @Column(name = "claveorigen")
    private String claveOrigen;

    @Schema(example = "1", description = "Identificador del status del origen.")
    @Column(name = "statusid")
    private Integer idStatus;

    @Schema(example = "2022-12-12 12:12:12.123", description = "Fecha de última modificaciñon del campo.")
    @Column(name = "modificacion")
    private LocalDateTime fechaModificacion;

    @Schema(example = "Diego Vázquez", description = "NOmbre del usuario.")
    @Column(name = "usuario")
    private String usuarioNombre;
}
