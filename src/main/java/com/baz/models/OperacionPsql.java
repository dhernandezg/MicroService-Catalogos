package com.baz.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <b>OperacionPsql</b>
 * @descripcion: Entidad que representa la estructura de una respuesta genérica de base de datos
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OperacionPsql {
    /**
     * Contiene el código de retorno
     * */
    @Id
    @Column(name = "codigo")
    public Integer estatus;

    /**
     * Contiene el mensaje de ejecución
     * */
    @Column(name = "mensaje")
    public String mensaje;
}
