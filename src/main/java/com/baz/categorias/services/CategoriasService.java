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

    @Inject
    CrearCategoriaDAO crearCategoriaDAO;
    public GenericResponse crearCategoria(String descripcionCategoria, String usuario){

        GenericResponse genericResponse = new GenericResponse("", "", null);

        Object object = crearCategoriaDAO.consumoCrearFuncion(
                descripcionCategoria,
                usuario);

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
     *//*


*/
    @Inject
    CategoriasDAO categoriasDAO;
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
/*
    *//**
     * <b>actualizarCategoria</b>
     * @descripcion: Método para actualizar una o varias catergorías
     * de la entidad.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 01/05/2022
     *//*

    public String actualizarCategoria(CategoriasModel categoriasModel){

        categoriasModel.setIdCategoria(BigDecimal.valueOf(5));
        categoriasModel.setDescripcionCategoria("GEOGRAFIA");

        return categoriasModel.getDescripcionCategoria();
    }

    *//**
     * <b>eliminarCategoria</b>
     * @descripcion: Método para borrado lógico de una o varias
     * categorías de la entidad.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 01/05/2022
     *//*

    public String eliminarCategoria(CategoriasModel categoriasModel){

        categoriasModel.setIdCategoria(BigDecimal.valueOf(6));
        categoriasModel.setDescripcionCategoria("PAISES");

        return categoriasModel.getDescripcionCategoria();
    }
*/
    /**
     * <b>listaOperaciones</b>
     * @descripcion: Método para consultar los tipo de operaciones
     * para el CategoriasService (Se utiliza el nombre como PathParam).
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 05/05/2022
     */

    @Inject
    ExistenciaCategoriasDAO existenciaCategoriasDAO;
    public GenericResponse consultarExistenciaCategoria(Integer idCategoria, String descripcionCategoria) {

        GenericResponse genericResponse = new GenericResponse("", "", null);
        String response;

        if (existenciaCategoriasDAO.consumeExistenciaFuncion(
                BigDecimal.valueOf(idCategoria),
                descripcionCategoria) == 1){
            response = "La categoria " + descripcionCategoria + " existe";
        }
        else{
            response = "La categoria " + descripcionCategoria + " NO existe";
        }

        genericResponse.setCodigo(Constantes.HTTP_200);
        genericResponse.setMensaje(Constantes.MENSAJE_EXITO);
        genericResponse.setRespuesta(response);

        return genericResponse;
    }


    /**
     * <b>consultarSecuenciaCategoria</b>
     * @descripcion: Método para consultar la secuencia de la categoría
     * para obtener el siguiente identificador.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 02/05/2022
     */

    @Inject
    SecuenciaCategoriasDAO secuenciaCategoriasDAO;
    public int consultarSecuenciaCategoria(){

        return secuenciaCategoriasDAO.consumeSecuenciaFuncion();
    }

}