package com.baz.jerarquia.daos;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.baz.jerarquia.models.*;
import com.baz.models.OperacionPsql;
import com.baz.utils.*;

/**
 * <b>ActualizarJerarquiaDao</b>
 * @descripcion: Clase que contiene los métodos de actualización de jerarquias
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Model
public class ActualizarJerarquiaDao {
    /**
     * Objeto de acceso a base de datos
     * */
    @Inject
    BaseDeDatosService accesoDatos;

    /**
     * Actualiza los datos de una jerarquia
     * @param datosJerarquia - Datos a actualizar de la jerarquia
     * @return boolean True si la actualización fue exitosa
     */
    public boolean actualizarJerarquia(DatosActualizacion datosJerarquia) {
        StoredProcedure fnActualizaJerarquia = new StoredProcedure("SC_CATREM.FNJERARQUIAUPD", OperacionPsql.class);
        fnActualizaJerarquia.addParameters(new ProceduredParameter(1, "PA_FICATEGORIAID", datosJerarquia.getIdCategoria(), Integer.class));
        fnActualizaJerarquia.addParameters(new ProceduredParameter(2, "PA_FICATALOGOID", datosJerarquia.getIdCatalogo(), Integer.class));
        fnActualizaJerarquia.addParameters(new ProceduredParameter(3, "PA_FICATJERARQID", datosJerarquia.getIdJerarquia(), Integer.class));
        fnActualizaJerarquia.addParameters(new ProceduredParameter(4, "PA_USUARIO", datosJerarquia.getUsuario(), String.class));
        fnActualizaJerarquia.addParameters(new ProceduredParameter(5, "PA_FIELEMBASEID", datosJerarquia.getIdElementoBase(), Integer.class));
        fnActualizaJerarquia.addParameters(new ProceduredParameter(6, "PA_FISTATUSID", datosJerarquia.getIdEstatus(), Short.class));
        
        List<OperacionPsql> resultado = accesoDatos.<OperacionPsql>obtenerElementos(fnActualizaJerarquia);
        return !resultado.isEmpty() && resultado.get(0).estatus == 1;
    }
}
