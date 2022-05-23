package com.baz.campos.daos;

import com.baz.models.OperacionPsql;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * <b>EliminarCampo</b>
 * @descripcion: Clase ELiminarCampo para acceso a DB.
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 23/05/2022
 */

@ApplicationScoped
public class EliminarCampo {

    @Inject
    BaseDeDatosService baseDeDatosService;


    /**
     * <b>eliminarCampo</b>
     * @descripcion: Método para eliminar campo.
     * @autor: Diego Vázquez Pérez
     * @param idCampo Identificador del campo.
     * @param usuarioNombre Nombre del usuario.
     * @ultimaModificacion: 23/05/2022
     */

    public boolean eliminarCampo(Short idCampo,
                                 String usuarioNombre){

        StoredProcedure storedProcedure = new StoredProcedure("SC_CATREM.FNCAMPODEL", OperacionPsql.class);
        storedProcedure.addParameters(new ProceduredParameter(1, "PA_FICAMPOID", idCampo, Short.class));
        storedProcedure.addParameters(new ProceduredParameter(2, "PA_USUARIO", usuarioNombre, String.class));

        var data = baseDeDatosService.<OperacionPsql>obtenerElementos(storedProcedure);

        return data.size() > 0 && data.get(0).estatus == 1;
    }
}
