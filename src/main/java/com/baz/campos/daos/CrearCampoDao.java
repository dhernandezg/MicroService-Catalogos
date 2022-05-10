package com.baz.campos.daos;

import com.baz.categorias.models.OperacionPsql;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * <b>${nombreClase}</b>
 * @descripcion: breve descripción del contenido
 * @autor: ${user}, Desarrollador
 * @param String Descripcion
 * @ultimaModificacion: ${date}
 */

@ApplicationScoped
public class CrearCampoDao {

    @Inject
    BaseDeDatosService baseDeDatosService;

    /**
     * <b>crearCampo</b>
     * @descripcion: Método para crea campo.
     * @autor: Diego Vázquez Pérez
     * @param descripcionCampo Descripcion del campo
     * @param usuarioNombre Nombre del usuario
     * @ultimaModificacion: 10/05/2022
     */

    public boolean crearCampo(String descripcionCampo,
                              String usuarioNombre){

        StoredProcedure storedProcedure = new StoredProcedure("FNCAMPOINS", OperacionPsql.class);
        storedProcedure.addParameters(new ProceduredParameter(1, "v_DESCCAMPO", descripcionCampo, String.class));
        storedProcedure.addParameters(new ProceduredParameter(2, "v_USUARIO", usuarioNombre, String.class));

        var data = baseDeDatosService.<OperacionPsql>obtenerElementos(storedProcedure);

        return data.size() > 0 && data.get(0).estatus == 1;

    }
}
