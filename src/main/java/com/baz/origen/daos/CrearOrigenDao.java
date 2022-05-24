package com.baz.origen.daos;

import com.baz.models.OperacionPsql;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * <b>CrearOrigenDao</b>
 * @descripcion: Clase crear Origen para acceso a DB
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 10/05/2022
 */

@ApplicationScoped
public class CrearOrigenDao {

    @Inject
    BaseDeDatosService baseDeDatosService;

    /**
     * <b>crearOrigen</b>
     * @descripcion: Método para crear origen
     * @autor: Diego Vázquez Pérez
     * @param descripcionOrigen Descripcion del origen
     * @param claveOrigen Clave del origen
     * @param usuarioNombre Nombre del usuario
     * @ultimaModificacion: 10/05/2022
     */

    public boolean crearOrigen(String descripcionOrigen,
                               String claveOrigen,
                               String usuarioNombre){

        StoredProcedure storedProcedure = new StoredProcedure("SC_CATREM.FNORIGENINS", OperacionPsql.class);
        storedProcedure.addParameters(new ProceduredParameter(1, "PA_FCDESCORIGEN", descripcionOrigen, String.class));
        storedProcedure.addParameters(new ProceduredParameter(2, "PA_FCCLAVEORIGEN", claveOrigen, String.class));
        storedProcedure.addParameters(new ProceduredParameter(3, "PA_USUARIO", usuarioNombre, String.class));

        var data = baseDeDatosService.<OperacionPsql>obtenerElementos(storedProcedure);

        return !data.isEmpty() && data.get(0).estatus == 1;

    }
}
