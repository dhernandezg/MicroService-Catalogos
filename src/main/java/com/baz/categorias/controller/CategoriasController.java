package com.baz.categorias.controller;

import com.baz.categorias.dtos.GenericResponse;
import com.baz.categorias.models.CategoriasModel;
import com.baz.categorias.services.CategoriasService;
import com.baz.utils.Constantes;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * <b>CategoriasController</b>
 * @descripcion: Clase princiàl que define los métodos HTTP para
 * consumo de servicios.
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 05/05/2022
 */
@Path("/CategoriasService")
public class CategoriasController {

    @Inject
    CategoriasService categoriasService;


    /**
     * <b>listaOperaciones</b>
     * @descripcion: Método para consultar los tipo de operaciones
     * para el CategoriasService (Se utiliza el nombre como PathParam).
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 01/05/2022
     */

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Consulta las operaciones disponibles en el servicio de categorías.")
    public List<String> listaOperaciones(){

        return categoriasService.listaOperacionesCaterogias();
    }


    /**
     * <b>consultarCategoria</b>
     * @descripcion: Método GET para consulta por categoría.
     * @autor: DIego Vázquez Pérez
     * @param idCategoria Descripción de la categoria.
     * @param descripcionCategoria Nombre de la categoria.
     * @ultimaModificacion: 09/05/2022
     */

    @GET
    @Path("/ConsultarCategoria")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Consulta una categoría particular o todas las categorías.")
    public GenericResponse<Iterable<CategoriasModel>> consultarCategoria(
            @Schema(example = "1", description = "Identificador de la categoria")
            @QueryParam("idCategoria") Integer idCategoria,
            @Schema(example = "GEOGRAFIA", description = "Nombre de la categoria")
            @QueryParam("descripcionCategoria") String descripcionCategoria
    ){

        Iterable<CategoriasModel> categoriasModel = categoriasService.consultarCategoria(idCategoria, descripcionCategoria);

        return new GenericResponse<Iterable<CategoriasModel>>(Constantes.HTTP_200, Constantes.MENSAJE_EXITO, categoriasModel) ;
    }

    /**
     * <b>crearCategoria</b>
     * @descripcion: Método PUT para crear categoría.
     * @autor: Diego Vázquez Pérez
     * @param descripcionCategoria Descripcion/nombre de la categoría.
     * @param usuario Nombre del usuario quien da de alta la categoría.
     * @ultimaModificacion: 09/05/2022
     */

    @POST
    @Path("/CrearCategoria")
    @Operation(summary = "Registra una nueva categoría..")
    @Produces(MediaType.APPLICATION_JSON)
    public GenericResponse<Boolean> crearCategoria(
            @Schema(example = "PAISES", description = "Nombre de la categoria")
            @QueryParam("descripcionCategoria") String descripcionCategoria,
            @Schema(example = "Diego Vazquez Perez", description = "Nombre del usuario")
            @QueryParam("usuario") String usuario
    ){

        boolean response = categoriasService.crearCategoria(descripcionCategoria, usuario);

        return new GenericResponse<>(Constantes.HTTP_200, Constantes.MENSAJE_EXITO, response);
    }


    /**
     * <b>actualizarCategoria</b>
     * @descripcion: Método para invocar actualización de catergoría.
     * @autor: Diego Vázquez Pérez
     * @param idCategoria Identificador de la categoria
     * @param descripcionCategoria Nombre de la categoría.
     * @param idStatus Identificador del estatus
     * @param usuarioNombre Nombre del usuario
     * @ultimaModificacion: 10/05/2022
     */

    @PUT
    @Path("/ActualizarCategoria")
    @Operation(summary = "Actualiza los datos especificados de una categoría.")
    @Produces(MediaType.APPLICATION_JSON)
    public GenericResponse<Boolean> actualizarCategoria(
            @Schema(example = "1", description = "Identificador de la categoria")
            @QueryParam("idCategoria") Integer idCategoria,

            @Schema(example = "DIVISAS", description = "Nombre de la categoría.")
            @QueryParam("descripcionCategoria") String descripcionCategoria,

            @Schema(example = "1", description = "Identificador del estatus.")
            @QueryParam("idStatus") Integer idStatus,

            @Schema(example = "Diego Vazquez Perez", description = "Nombre del usuario")
            @QueryParam("usuarioNombre") String usuarioNombre
    ){

        boolean response = categoriasService.actualizarCategoria(idCategoria,
                descripcionCategoria,
                idStatus,
                usuarioNombre);
        return new GenericResponse<>(Constantes.HTTP_200, Constantes.MENSAJE_EXITO, response);
    }


    /**
     * <b>eliminarCategoria</b>
     * @descripcion: Servicio para invocación de eliminar categoría.
     * @autor: Diego Vázquez Pérez
     * @param idCategoria Identificador de la categoria
     * @param  usuarioNombre Nombre del usuario
     * @ultimaModificacion: 10/05/2022
     */


    @DELETE
    @Path("/EliminarCategoria")
    @Operation(summary = "Elimina una categoría mediante su identificador.")
    @Produces(MediaType.APPLICATION_JSON)
    public GenericResponse<Boolean> eliminarCategoria(
            @Schema(example = "1", description = "Identificador de la categoria")
            @QueryParam("idCategoria") Integer idCategoria,

            @Schema(example = "Diego Vazquez Perez", description = "Nombre del usuario")
            @QueryParam("usuarioNombre") String usuarioNombre
    ){

        boolean response = categoriasService.eliminarCategoria(
                idCategoria,
                usuarioNombre);

        return new GenericResponse<>(Constantes.HTTP_200, Constantes.MENSAJE_EXITO, response);
    }

}
