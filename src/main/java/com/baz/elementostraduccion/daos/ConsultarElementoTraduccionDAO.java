package com.baz.elementostraduccion.daos;

import javax.enterprise.context.ApplicationScoped;

import com.baz.elementostraduccion.models.ElementosTraduccionModel;
import com.baz.utils.*;

import java.util.List;

/**
 * <b>ConsultarElementoTraduccionDAO</b>
 * @descripcion: Clase principal para consultar elemento traducción para acceso a DB
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 27/05/2022
 */

@ApplicationScoped
public class ConsultarElementoTraduccionDAO {

    /**
     * Inyección de dependencia para acceso a DB
     */
    BaseDeDatosService baseDeDatosService;

    /**
     * <b>${nombreClase}</b>
     * @descripcion: breve descripción del contenido
     * @autor: ${user}, Desarrollador
     * @param String Descripcion
     * @ultimaModificacion: ${date}
     */

    public List<ElementosTraduccionModel> consultarElementosTraduccion(){

    }
}
