package com.baz.campos.services;

import com.baz.campos.daos.ActualizarCampo;
import com.baz.campos.daos.ConsultarCampo;
import com.baz.campos.daos.CrearCampo;
import com.baz.campos.daos.EliminarCampo;
import com.baz.campos.models.CamposModel;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;


/**
 * <b>CamposService</b>
 * @descripcion: Servicio Campos, en el cual se encuentra la administración
 * de campos.
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 23/05/2022
 */

@Singleton
public class CamposService {

    @Inject
    CrearCampo crearCampo;

    @Inject
    ConsultarCampo consultarCampo;

    @Inject
    ActualizarCampo actualizarCampo;

    @Inject
    EliminarCampo eliminarCampo;

    /**
     * <b>crearCampo</b>
     * @descripcion: Método para invocar crear campo.
     * @autor: Diego Vázquez Pérez
     * @param descripcionCampo Descripcion del campo
     * @param usuarioNombre Nombre del usuario
     * @ultimaModificacion: 10/05/2022
     */

    public boolean crearCampo(String nombreCampo,
                              String descripcionCampo,
                              String usuarioNombre){

        return crearCampo.crearCampo(nombreCampo,
                descripcionCampo,
                usuarioNombre);

    }

    /**
     * <b>consultarCampo</b>
     * @descripcion: Método para invocar consultar campo.
     * @autor: Diego Vázquez Pérez
     * @param idCampo Identificador del campo
     * @param descripcionCampo Descripción del campo
     * @ultimaModificacion: ${date}
     */

    public List<CamposModel> consultarCampo(Integer idCampo,
                                            String descripcionCampo){

        return consultarCampo.consultarCampos(idCampo,
                descripcionCampo);

    }

    /**
     * <b>actualizarCampo</b>
     * @descripcion: Método para invocar actualizar campo
     * @autor: Diego Vázquez Pérez
     * @param idCampo Identificador del campo
     * @param descripcionCampo Descripción del campo
     * @param idEstatus Identificador del estatus
     * @param usuarioNombre Nombre del usuario
     * @ultimaModificacion: 23/05/2022
     */

    public boolean actualizarCampo(Short idCampo,
                                   String usuarioNombre,
                                   String nombreCampo,
                                   String descripcionCampo,
                                   Short idEstatus){

        return actualizarCampo.actualizarCampo(idCampo,
                usuarioNombre,
                nombreCampo,
                descripcionCampo,
                idEstatus);
    }

    /**
     * <b>eliminarCampo</b>
     * @descripcion: Método para invocar eliminar campo.
     * @autor: Diego Vázquez Pérez
     * @param idCampo Identificador del campo
     * @param usuarioNombre Nombre del usuario
     * @ultimaModificacion: 10/05/2022
     */

    public boolean eliminarCampo(Short idCampo,
                                 String usuarioNombre){

        return eliminarCampo.eliminarCampo(idCampo,
                usuarioNombre);

    }
}
