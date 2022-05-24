package com.baz.elementosbase.services;

import com.baz.elementosbase.daos.ActualizarElementosBaseDao;
import com.baz.elementosbase.daos.ConsultarElementosBaseDao;
import com.baz.elementosbase.daos.CrearElementoBaseDao;
import com.baz.elementosbase.daos.EliminarElementoBaseDao;
import com.baz.elementosbase.models.ActualizarElementoBaseModel;
import com.baz.elementosbase.models.CrearElementoBaseModel;
import com.baz.elementosbase.models.ElementosBaseModel;
import com.baz.elementosbase.models.EliminarElementoBaseModel;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

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
     * @param elemento Modelo de datos requeridos para crear un elemento base
     * @ultimaModificacion: 24/05/2022
     */

    public boolean crearElementoBase(
            CrearElementoBaseModel elemento
    ){

        return crearElementoBaseDao.crearElementoBase(elemento);
    }

    /**
     * <b>consultarElementosBase</b>
     * @descripcion: Método para consultar un elemento mediante parámetros específicos
     * o todos los elementos mediante parámetros vacíos.
     * @autor: Diego Vázquez Pérez
     * @param idCategoria Identificador de la categoría a la que pertenece el cátalogo
     * @param idCatalogo Identificador del catálogo al que pertenece el elemento base
     * @param idElementoBase Identificador del elemento base a consultar
     * @ultimaModificacion: 24/05/2022
     */

    public List<ElementosBaseModel> consultarElementosBase(
            Integer idCategoria,
            Integer idCatalogo,
            Integer idElementoBase){

        return consultarElementosBaseDao.consultarElementosBase(
                idCategoria,
                idCatalogo,
                idElementoBase);
    }
}
