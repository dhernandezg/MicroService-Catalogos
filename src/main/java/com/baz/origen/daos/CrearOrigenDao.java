package com.baz.origen.daos;

import com.baz.categorias.models.OperacionPsql;
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

        StoredProcedure storedProcedure = new StoredProcedure("FNORIGENINS", OperacionPsql.class);
        storedProcedure.addParameters(new ProceduredParameter(1, "v_DESCORIGEN", descripcionOrigen, String.class));
        storedProcedure.addParameters(new ProceduredParameter(2, "v_CLAVEORIGEN", claveOrigen, String.class));
        storedProcedure.addParameters(new ProceduredParameter(3, "v_USUARIO", usuarioNombre, String.class));

        var data = baseDeDatosService.<OperacionPsql>obtenerElementos(storedProcedure);

        return data.size() > 0 && data.get(0).estatus == 1;

    }
}
