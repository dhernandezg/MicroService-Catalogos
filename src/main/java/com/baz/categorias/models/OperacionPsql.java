package com.baz.categorias.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * <b>OperacionPsql</b>
 * @descripcion: Entidad de respuesta desde la DB hacia el MS
 * @autor: Daniel Hernández
 * @ultimaModificacion: 09/05/2022
 */

@Data
@AllArgsConstructor@NoArgsConstructor
@Entity
public class OperacionPsql {

    @Schema(example = "200", description = "Código de respuesta desde la DB hacia el MS.")
    @Column(name = "codigo")
    @Id
    public Integer estatus;

    @Schema(example = "true", description = "Respuesta boolean desde la DB hacia el MS.")
    @Column(name = "mensaje")
    public String mensaje;
}
