package com.baz.jerarquia.daos;

import javax.inject.Inject;

import com.baz.jerarquia.models.DatosAlta;
import com.baz.models.OperacionPsql;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

/**
 * <b>RegistrarJerarquiaDao</b>
 * @descripcion: Clase que contiene los métodos de inserción para las jerarquias
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
public class RegistrarJerarquiaDao {
     /**
     * Objeto de acceso a base de datos
     */
    @Inject
    BaseDeDatosService accesoDatos;

    /**
     * Registra la jerarquia especificada
     * @param datosAlta Jerarquia a registrar
     * @return boolean True si el registro fue exitoso
     */
    public boolean agregarJerarquia(DatosAlta datosAlta) {
        StoredProcedure fnInsertaJerarquia = new StoredProcedure("SC_CATREM.FNJERARQUIAINS", OperacionPsql.class);
        fnInsertaJerarquia.addParameters(new ProceduredParameter(1, "PA_FICATEGORIAID", datosAlta.getIdCategoria(), Integer.class));
        fnInsertaJerarquia.addParameters(new ProceduredParameter(2, "PA_FICATALOGOID", datosAlta.getIdCatalogo(), Integer.class));
        fnInsertaJerarquia.addParameters(new ProceduredParameter(3, "PA_FICATJERARQID", datosAlta.getIdCatalogoHijo(), Integer.class));
        fnInsertaJerarquia.addParameters(new ProceduredParameter(4, "PA_FIELEMBASEID", datosAlta.getIdCatalogoBase(), Integer.class));
        fnInsertaJerarquia.addParameters(new ProceduredParameter(5, "PA_USUARIO", datosAlta.getUsuario(), String.class));
        var data = accesoDatos.<OperacionPsql>obtenerElementos(fnInsertaJerarquia);
        return !data.isEmpty() && data.get(0).estatus == 1;
    }
}
