package com.baz.categorias.services;

import com.baz.categorias.daos.*;
import com.baz.categorias.models.CategoriasModel;
import com.baz.categorias.models.GenericResponse;
import com.baz.utils.Constantes;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.math.BigDecimal;
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
    CategoriasDAO categoriasDAO;

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

    public GenericResponse crearCategoria(String descripcionCategoria, String usuario){

        GenericResponse genericResponse = new GenericResponse("", "", null);
        CategoriasModel categoriasModel = new CategoriasModel();
        categoriasModel.setDescripcionCategoria(descripcionCategoria);
        categoriasModel.setNombreUsuario(usuario);

        Object object = categoriasDAO.crearCategoria(categoriasModel);

        genericResponse.setCodigo(Constantes.HTTP_200);
        genericResponse.setMensaje(Constantes.MENSAJE_EXITO);
        genericResponse.setRespuesta(object);

        return genericResponse;
    }

    /**
     * <b>consultarCategoria</b>
     * @descripcion: Método para consular una o varias categorías
     * de la entidad.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 05/05/2022
     */

    public GenericResponse consultarCategoria(Integer idCategoria,
                                              String descripcionCategoria){

        GenericResponse genericResponse = new GenericResponse("", "", null);
        List<CategoriasModel> categoriasModel = new ArrayList<>();
        CategoriasModel categoriasModel1 = new CategoriasModel();
        categoriasModel1.setIdCategoria(idCategoria);
        categoriasModel1.setDescripcionCategoria(descripcionCategoria);
        categoriasModel.addAll(categoriasDAO.consultarCategoria(
                categoriasModel1));

        genericResponse.setCodigo(Constantes.HTTP_200);
        genericResponse.setMensaje(Constantes.MENSAJE_EXITO);
        genericResponse.setRespuesta(categoriasModel);

        return genericResponse;
    }

}