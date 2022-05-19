package com.baz.categorias.services;

import com.baz.categorias.daos.*;
import com.baz.categorias.models.CategoriasModel;
import com.baz.utils.Constantes;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.*;

/**
 * <b>CategoriasService</b>
 * @descripcion: Clase principal del servicio de categorias, dentro
 * se encuentran los métodos de administración de categorías.
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 01/05/2022
 */

@Singleton
public class CategoriasService {

    @Inject
    CrearCategoria crearCategoria;

    @Inject
    ConsultarCategoria consultarCategoria;

    @Inject
    ActualizarCategoria actualizarCategoria;

    @Inject
    EliminarCategoriaDao eliminarCategoriaDao;

    public List<String> listaOperacionesCaterogias(){

        ArrayList<String> lista = new ArrayList<>();

        lista.add(Constantes.CREATE);
        lista.add(Constantes.READ);
        lista.add(Constantes.UPDATE);
        lista.add(Constantes.DELETE);
        lista.add(Constantes.SEQUENCE);
        lista.add(Constantes.EXISTENCE);

        return lista;
    }

    /**
     * <b>crearCategoria</b>
     * @descripcion: Método para crear una o varias categorías
     * en la entidad.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 18/05/2022
     */

    public boolean crearCategoria(
            String descripcionCategoria,
            String usuario){

        return crearCategoria.crearCategoria(
                descripcionCategoria,
                usuario);
    }

    /**
     * <b>consultarCategoria</b>
     * @descripcion: Método para consular una o varias categorías
     * de la entidad.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 05/05/2022
     */

    public List<CategoriasModel> consultarCategoria(Integer idCategoria,
                                                    String descripcionCategoria){

        return consultarCategoria.consultarCategoria(idCategoria, descripcionCategoria);
    }


    /**
     * <b>actualizarCategoria</b>
     * @descripcion: Método para actualizar categorías mediante idCategoria,
     * descripcionCategoria, idStatus, usuarioNombre.
     * @autor: Diego Vázquez Pérez
     * @param idCategoria Identificador de la categoría.
     * @param descripcionCategoria NOmbre de la categoría.
     * @param idStatus Identificador del estado de la categoría.
     * @param usuarioNombre NOmbre del usuario que actualiza la categoría.
     * @ultimaModificacion: 09/05/2022
     */

    public boolean actualizarCategoria(Integer idCategoria,
                                       String descripcionCategoria,
                                       Integer idStatus,
                                       String usuarioNombre){

        return actualizarCategoria.actualizarCategoria(idCategoria,
                descripcionCategoria,
                idStatus,
                usuarioNombre);
    }


    /**
     * <b>eliminarCategoria</b>
     * @descripcion: Método para invocar la eliminación de categoría.
     * @autor: Diego Vázquez Pérez
     * @param idCategoria Identificador de la categoria.
     * @param usuarioNombre Nombre del usuario.
     * @ultimaModificacion: 10/05/2022
     */

    public boolean eliminarCategoria(Integer idCategoria,
                                     String usuarioNombre){

        return eliminarCategoriaDao.eliminarCategoria(idCategoria,
                usuarioNombre);
    }

}