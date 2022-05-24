package com.baz.elementosbase.services;

import com.baz.elementosbase.daos.ActualizarElementosBaseDao;
import com.baz.elementosbase.daos.ConsultarElementosBaseDao;
import com.baz.elementosbase.daos.CrearElementoBaseDao;
import com.baz.elementosbase.daos.EliminarElementoBaseDao;
import com.baz.elementosbase.models.ActualizarElementoBaseModel;
import com.baz.elementosbase.models.CrearElementoBaseModel;
import com.baz.elementosbase.models.EliminarElementoBaseModel;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * <b>ElementosBaseService</b>
 * @descripcion: Clase principal del servicio de Elementos Base, donde
 * se encuentran sus métodos de administración.
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 24/05/2022
 */

@Singleton
public class ElementosBaseService {

    /**
     * Inyección de dependencias de acceso a DB
     */
    @Inject
    CrearElementoBaseDao crearElementoBaseDao;

    @Inject
    ConsultarElementosBaseDao consultarElementosBaseDao;

    @Inject
    ActualizarElementosBaseDao actualizarElementosBaseDao;

    @Inject
    EliminarElementoBaseDao eliminarElementoBaseDao;

    /**
     * <b>${nombreClase}</b>
     * @descripcion: Método para crear un elemento base
     * @autor: Diego Vázquez Pérez
     * @param elemento Datos requeridos para crear un elemento base
     * @ultimaModificacion: 24/05/2022
     */

    public boolean crearElementoBase(
            CrearElementoBaseModel elemento
    ){

        return crearElementoBaseDao.crearElementoBase(elemento);
    }
}
