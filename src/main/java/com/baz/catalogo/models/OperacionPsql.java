package com.baz.catalogo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OperacionPsql {
    @Column(name = "codigo")
    @Id
    public Integer estatus;

    @Column(name = "mensaje")
    public String mensaje;
}
