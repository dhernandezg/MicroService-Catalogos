package com.baz.controller;

import com.baz.models.CategoriasModel;
import com.baz.models.GenericResponse;
import com.baz.services.CategoriasService;
import com.baz.utils.Constantes;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.ArrayList;
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
    public List<String> listaOperaciones(){

        return categoriasService.listaOperacionesCaterogias();
    }

    /**
     * <b>orquestadorOperacionesCategoria</b>
     * @descripcion: Método para redireccionamiento de funciones
     * según el tipo de operación.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 05/05/2022
     */

    @GET
    @Path("/ConsultarExistencia")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarExistenciaCategoria(
            @Schema(example = "1", description = "Identificador de la categoria", required = false)
            @QueryParam("idCategoria") Integer idCategoria,
            @Schema(example = "GEOGRAFIA", description = "Nombre de la categoria", required = false)
            @QueryParam("descripcionCategoria") String descripcionCategoria
    ){

        return Response.ok().entity(
                categoriasService.consultarExistenciaCategoria(idCategoria, descripcionCategoria))
                .build();
    }

    /**
     * <b>${nombreClase}</b>
     * @descripcion: breve descripción del contenido
     * @autor: ${user}, Desarrollador
     * @param String Descripcion
     * @ultimaModificacion: ${date}
     */

    @GET
    @Path("/ConsultarCategoria")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarCategoria(
            @Schema(example = "1", description = "Identificador de la categoria", required = false)
            @QueryParam("idCategoria") Integer idCategoria,
            @Schema(example = "GEOGRAFIA", description = "Nombre de la categoria", required = false)
            @QueryParam("descripcionCategoria") String descripcionCategoria
    ){

        return Response.ok().entity(
                        categoriasService.consultarCategoria(idCategoria, descripcionCategoria))
                .build();
    }
}
