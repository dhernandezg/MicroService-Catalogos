package com.baz.elementostraduccion.services;

import com.baz.elementostraduccion.daos.ActualizarElementoTraduccionDAO;
import com.baz.elementostraduccion.daos.ConsultarElementoTraduccionDAO;
import com.baz.elementostraduccion.daos.CrearElementoTraduccionDAO;
import com.baz.elementostraduccion.daos.EliminarElementoTraduccionDAO;
import com.baz.elementostraduccion.models.ActualizarElementoTraduccionModel;
import com.baz.elementostraduccion.models.CrearElementoTraduccionModel;
import com.baz.elementostraduccion.models.ElementosTraduccionModel;
import com.baz.elementostraduccion.models.EliminarElementoTraduccionModel;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class ElementosTraduccionService {

    /**
     * Inyección de dependencias para acceso a métodos DAO
     */
    @Inject
    CrearElementoTraduccionDAO crearElemento;

    @Inject
    ConsultarElementoTraduccionDAO consultarElemento;

    @Inject
    ActualizarElementoTraduccionDAO actualziarElemento;

    @Inject
    EliminarElementoTraduccionDAO eliminarElementos;

    /**
         * <b>crearElementoTrad</b>
         * @descripcion: Método para crear elementos traduccion
         * @autor: Diego Vázquez Pérez
         * @param crearTraduccion Modelo de datos requeridos para crear un elemento traducción
         * @ultimaModificacion: 30/05/2022
         */

    public boolean crearElementoTrad(
            CrearElementoTraduccionModel crearTraduccion){

        return crearElemento.crearElementoTraduccion(crearTraduccion);
    }

    /**
         * <b>consultarElementosTrad</b>
         * @descripcion: Método para consultar elementos traduccion
         * @autor: Diego Vázquez Pérez
         * @param idCategoria Identificador de la categoria a consultar
         * @param idCatalogo Identificador del catalogo a consultar
         * @param idElementoTrad Identificador del elemento traduccion a consultar
         * @ultimaModificacion: 30/05/2022
         */

    public List<ElementosTraduccionModel> consultarElementosTrad(
            Integer idCategoria,
            Integer idCatalogo,
            Integer idElementoTrad){

        return consultarElemento.consultarElementosTraduccion(
                idCategoria,
                idCatalogo,
                idElementoTrad);
    }

    /**
         * <b>actualizarElementoTrad</b>
         * @descripcion: Método para actualizar elementos traduccion
         * @autor: Diego Vázquez Pérez
         * @param actualizarTraduccion Modelo de datos requeridos para actualizar un elemento traduccion
         * @ultimaModificacion: 30/05/2022
         */

    public boolean actualizarElementoTrad(
            ActualizarElementoTraduccionModel actualizarTraduccion
    ){

        return actualziarElemento.actualizarElementoTrad(actualizarTraduccion);
    }

    /**
         * <b>eliminarElementoTrad</b>
         * @descripcion: Método para eliminar elementos traduccion
         * @autor: Diego Vázquez Pérez
         * @param eliminarTraduccion Modelo de datos requeridos para eliminar un elemento traducción
         * @ultimaModificacion: 30/05/2022
         */

    public boolean eliminarElementoTrad(
            EliminarElementoTraduccionModel eliminarTraduccion){

        return eliminarElementos.eliminarElementoTrad(eliminarTraduccion);
    }
}
