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
    CrearCategoriaDao crearCategoriaDAO;

    @Inject
    ConsultarCategoriaDao consultarCategoriaDAO;

    @Inject
    ActualizarCategoriaDao actualizarCategoriaDao;

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
     * @ultimaModificacion: 01/05/2022
     */

    public boolean crearCategoria(String descripcionCategoria, String usuario){

        CategoriasModel categoriasModel = new CategoriasModel();

        categoriasModel.setDescripcionCategoria(descripcionCategoria);
        categoriasModel.setNombreUsuario(usuario);
        return crearCategoriaDAO.crearCategoria(categoriasModel);
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

        return consultarCategoriaDAO.consultarCategoria(idCategoria, descripcionCategoria);
    }


    /**
     * <b>${nombreClase}</b>
     * @descripcion: breve descripción del contenido
     * @autor: ${user}, Desarrollador
     * @param String Descripcion
     * @ultimaModificacion: ${date}
     */

    public boolean actualizarCategoria(Integer idCategoria,
                                       String descripcionCategoria,
                                       Integer idStatus,
                                       String usuarioNombre){

        return actualizarCategoriaDao.actualizarCategoria(idCategoria,
                descripcionCategoria,
                idStatus,
                usuarioNombre);
    }

}