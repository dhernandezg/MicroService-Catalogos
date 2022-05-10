package com.baz.campos.services;

import com.baz.campos.daos.ActualizarCampoDao;
import com.baz.campos.daos.ConsultarCampoDao;
import com.baz.campos.daos.CrearCampoDao;
import com.baz.campos.daos.EliminarCampoDao;
import com.baz.categorias.dtos.GenericResponse;
import com.baz.utils.Constantes;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;


/**
 * <b>CamposService</b>
 * @descripcion: Servicio Campos, en el cual se encuentra la administración
 * de campos.
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 10/05/2022
 */

@Singleton
public class CamposService {

    @Inject
    CrearCampoDao crearCampoDao;

    @Inject
    ConsultarCampoDao consultarCampoDao;

    @Inject
    ActualizarCampoDao actualizarCampoDao;

    @Inject
    EliminarCampoDao eliminarCampoDao;

    /**
     * <b>listaOperacionesCampos</b>
     * @descripcion: Método para mostrar lista de operaciones
     * que el usuario puede ejecutar.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 10/05/2022
     */

    public ArrayList listaOperacionesCampos(){

        ArrayList<String> lista = new ArrayList<>();

        lista.add(Constantes.CREATE + Constantes.CAMPOS);
        lista.add(Constantes.READ + Constantes.CAMPOS);
        lista.add(Constantes.UPDATE + Constantes.CAMPOS);
        lista.add(Constantes.DELETE + Constantes.CAMPOS);

        return lista;
    }

    /**
     * <b>crearCampo</b>
     * @descripcion: Método para invocar crear campo.
     * @autor: Diego Vázquez Pérez
     * @param descripcionCampo Descripcion del campo
     * @param usuarioNombre Nombre del usuario
     * @ultimaModificacion: 10/05/2022
     */

    public boolean crearCampo(String descripcionCampo,
                              String usuarioNombre){

        return crearCampoDao.crearCampo(descripcionCampo,
                usuarioNombre);

    }
}
