package com.baz.campos.daos;

import com.baz.categorias.models.OperacionPsql;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;
import org.testcontainers.shaded.org.bouncycastle.util.Store;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * <b>EliminarCampoDao</b>
 * @descripcion: Clase ELiminarCampo para acceso a DB.
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 10/05/2022
 */

@ApplicationScoped
public class EliminarCampoDao {

    @Inject
    BaseDeDatosService baseDeDatosService;


    /**
     * <b>eliminarCampo</b>
     * @descripcion: Método para eliminar campo.
     * @autor: Diego Vázquez Pérez
     * @param idCampo Identificador del campo.
     * @param usuarioNombre Nombre del usuario.
     * @ultimaModificacion: 10/05/2022
     */

    public boolean eliminarCampo(Integer idCampo,
                                 String usuarioNombre){

        StoredProcedure storedProcedure = new StoredProcedure("FNCAMPODEL", OperacionPsql.class);
        storedProcedure.addParameters(new ProceduredParameter(1, "v_CAMPOID", idCampo, Integer.class));
        storedProcedure.addParameters(new ProceduredParameter(2, "v_USUARIO", usuarioNombre, String.class));

        var data = baseDeDatosService.<OperacionPsql>obtenerElementos(storedProcedure);

        return data.size() > 0 && data.get(0).estatus == 1;
    }
}
