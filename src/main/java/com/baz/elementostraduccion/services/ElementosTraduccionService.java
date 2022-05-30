package com.baz.elementostraduccion.services;

import com.baz.elementostraduccion.daos.ActualizarElementoTraduccionDAO;
import com.baz.elementostraduccion.daos.ConsultarElementoTraduccionDAO;
import com.baz.elementostraduccion.daos.CrearElementoTraduccionDAO;
import com.baz.elementostraduccion.daos.EliminarElementoTraduccionDAO;
import com.baz.elementostraduccion.models.ActualizarElementoTraduccionModel;
import com.baz.elementostraduccion.models.CrearElementoTraduccionModel;

import javax.ejb.Singleton;
import javax.inject.Inject;

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
}
