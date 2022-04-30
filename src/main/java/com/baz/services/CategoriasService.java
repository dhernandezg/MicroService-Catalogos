package com.baz.services;

import com.baz.models.CategoriasModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * <b>CategoriasService</b>
 * @descripcion: Clase principal del servicio de categorias, dentro
 * se encuentran los métodos de administración de categorías.
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 29/04/2022
 */

@Path("/CategoriasService")
public class CategoriasService {

    /**
     * <b>consultarExistenciaCategoria</b>
     * @descripcion: Método para consultar la existencia de una o
     * varias categorías en el módulo.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 29/04/2022
     */

    @POST
    @Path("/ConsultarExistenciaCategoria/{tipoOperacion}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<CategoriasModel> consultarExistenciaCategoria(@PathParam("tipoOperacion") String tipoOperacion) {

        ArrayList<CategoriasModel> listaCategorias = new ArrayList<CategoriasModel>();
        switch (tipoOperacion){
            case "Todo":
                listaCategorias.add(new CategoriasModel("1","Crear"));
                listaCategorias.add(new CategoriasModel("2","Consultar"));
                listaCategorias.add(new CategoriasModel("3","Actualizar"));
                listaCategorias.add(new CategoriasModel("4","Borrar"));
                listaCategorias.add(new CategoriasModel("5","ConsultarExistencia"));
                listaCategorias.add(new CategoriasModel("6","ConsultarSecuencia"));
                return listaCategorias;

            case "Crear":

                listaCategorias.add(consultarSecuenciaCategoria());
                break;
        }

        return listaCategorias;
    }


    /**
     * <b>consultarSecuenciaCategoria</b>
     * @descripcion: Método para consultar la secuencia de la categoría
     * para obtener el siguiente identificador.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 29/04/2022
     */


    @Path("/ConsultarSecuenciaCategoria")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CategoriasModel consultarSecuenciaCategoria(){
        CategoriasModel categoriasModel = new CategoriasModel();

        categoriasModel.setIdCategoria("2");
        categoriasModel.setDescripcionCategoria("DIVISAS");

        return categoriasModel;
    }

    /**
     * <b>crearCategoria</b>
     * @descripcion: Método para crear una o varias categorías
     * en la entidad.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 29/04/2022
     */

    @Path("/CrearCategoria")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CategoriasModel crearCategoria(CategoriasModel categoriasModel){
        categoriasModel.setIdCategoria("3");
        categoriasModel.setDescripcionCategoria("PAISES");

        return categoriasModel;
    }

    /**
     * <b>consultarCategoria</b>
     * @descripcion: Método para consular una o varias categorías
     * de la entidad.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 29/04/2022
     */

    @Path("/ConsultarCategoria")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CategoriasModel consultarCategoria(CategoriasModel categoriasModel){
        categoriasModel.setIdCategoria("4");
        categoriasModel.setDescripcionCategoria("ESTADOS");

        return categoriasModel;
    }

    /**
     * <b>actualizarCategoria</b>
     * @descripcion: Método para actualizar una o varias catergorías
     * de la entidad.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 29/04/2022
     */

    @Path("/ActualizarCategoria")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CategoriasModel actualizarCategoria(CategoriasModel categoriasModel){

        categoriasModel.setIdCategoria("5");
        categoriasModel.setDescripcionCategoria("GEOGRAFIA");

        return categoriasModel;
    }

    /**
     * <b>eliminarCategoria</b>
     * @descripcion: Método para borrado lógico de una o varias
     * categorías de la entidad.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 29/04/2022
     */

    @Path("/EliminarCategoria")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CategoriasModel eliminarCategoria(CategoriasModel categoriasModel){

        categoriasModel.setIdCategoria("6");
        categoriasModel.setDescripcionCategoria("PAISES");

        return categoriasModel;
    }
}