package com.baz.campos.daos;

import com.baz.categorias.models.OperacionPsql;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * <b>CrearCampo</b>
 * @descripcion: Clase crearCampoDao para acceso a DB
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 19/05/2022
 */

@ApplicationScoped
public class CrearCampo {

    @Inject
    BaseDeDatosService baseDeDatosService;

    /**
     * <b>crearCampo</b>
     * @descripcion: Método para crear campo.
     * @autor: Diego Vázquez Pérez
     * @param nombreCampo Nombre del campo a registrar
     * @param descripcionCampo Descripcion del campo a registrar
     * @param usuarioNombre Nombre del usuario que registra
     * @ultimaModificacion: 19/05/2022
     */

    public boolean crearCampo(String nombreCampo,
                              String descripcionCampo,
                              String usuarioNombre){

        StoredProcedure storedProcedure = new StoredProcedure("SC_CATREM.FNCAMPOINS", OperacionPsql.class);
        storedProcedure.addParameters(new ProceduredParameter(1, "PA_FCCAMPO", nombreCampo, String.class));
        storedProcedure.addParameters(new ProceduredParameter(2, "PA_FCDESCCAMPO", descripcionCampo, String.class));
        storedProcedure.addParameters(new ProceduredParameter(3, "PA_USUARIO", usuarioNombre, String.class));

        var data = baseDeDatosService.<OperacionPsql>obtenerElementos(storedProcedure);

        return data.size() > 0 && data.get(0).estatus == 1;

    }
}
