package com.baz.estatus.services;

import com.baz.estatus.daos.ConsultarEstatusDao;
import com.baz.estatus.models.EstatusModel;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

/**
 * <b>EstatusService</b>
 * @descripcion: Clase principal del servicio de estatus, donde
 * se administran sus métodos.
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 24/05/2022
 */

@Singleton
public class EstatusService {

    /**
     * Inyección de dependencia para consumo de función consultarEstatus
     * de acceso a DB
     */
    @Inject
    ConsultarEstatusDao consultarEstatusDao;

    /**
     * <b>consultarEstatus</b>
     * @descripcion: Método para consular un estatus específico mediante su identificador o descripción o ambos,
     * también consulta todos lo registros disponibles.
     * @autor: Diego Vázquez Pérez
     * @param idEstatus Identificador del estatus a consultar.
     * @param descripcionEstatus Descripción del estatus a consultar.
     * @ultimaModificacion: 24/05/022
     */

    public List<EstatusModel> consultarEstatus(Short idEstatus,
                                               String descripcionEstatus){

        return consultarEstatusDao.consultarEstatus(
                idEstatus,
                descripcionEstatus);
    }
}
