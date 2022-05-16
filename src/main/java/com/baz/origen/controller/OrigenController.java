package com.baz.origen.controller;

import com.baz.categorias.dtos.GenericResponse;
import com.baz.origen.models.OrigenModel;
import com.baz.origen.services.OrigenService;
import com.baz.utils.Constantes;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/OrigenService")
public class OrigenController {

    @Inject
    OrigenService origenService;

    /**
     * <b>listaOperaciones</b>
     * @descripcion: Método GET para consultar operaciones
     * que se pueden ejecutar en OrigenService.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 12/05/2022
     */

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public GenericResponse<ArrayList> listaOperaciones(){

        return new GenericResponse<>(
                Constantes.HTTP_200,
                Constantes.MENSAJE_EXITO,
                origenService.listaOperacionesOrigen());
    }

    /**
     * <b>crearOrigen</b>
     * @descripcion: Método POST para crear origen
     * @autor: Diego Vázquez Pérez
     * @param descripcionOrigen Descripción del origen
     * @param claveOrigen CLva del origen
     * @param usuarioNombre Nombre del usuario que registra
     * @ultimaModificacion: 12/05/2022
     */

    @POST
    @Path("/CrearOrigen")
    @Produces(MediaType.APPLICATION_JSON)
    public GenericResponse<Boolean> crearOrigen(
            @Schema(example = "Inteligencia de Datos e Innovación", description = "Nombre del área de origen")
            @QueryParam("descripcionOrigen") String descripcionOrigen,

            @Schema(example = "IDI", description = "Clave del área de origen")
            @QueryParam("claveOrigen") String claveOrigen,

            @Schema(example = "Nombre Apellido1 Apellido2", description = "Nombre del usuario que registra")
            @QueryParam("usuarioNombre") String usuarioNombre){

        boolean response = origenService.crearOrigen(descripcionOrigen,
                claveOrigen,
                usuarioNombre);

        return new GenericResponse<>(
                Constantes.HTTP_200,
                Constantes.MENSAJE_EXITO,
                response);
    }

    /**
     * <b>consultarOrigen</b>
     * @descripcion: Método GET para consulta de origen
     * @autor: Diego Vázquez Pérez
     * @param idOrigen Identificador del origen
     * @param descripcionOrigen Descripción del origen
     * @param claveOrigen Clave del origen
     * @ultimaModificacion: 16/05/2022
     */

    @GET
    @Path("/ConsultarOrigen")
    @Produces(MediaType.APPLICATION_JSON)
    public GenericResponse<Iterable<OrigenModel>> consultarOrigen(
            @Schema(example = "1", description = "Identificador del origen.")
            @QueryParam("idOrigen") Integer idOrigen,

            @Schema(example = "Inteligencia de Datos e Innovación", description = "Descripción del origen.")
            @QueryParam("descripcionOrigen") String descripcionOrigen,

            @Schema(example = "IDI", description = "Clave del campo.")
            @QueryParam("claveOrigen") String claveOrigen){

        Iterable<OrigenModel> origenModels = origenService.consultarOrigen(
                idOrigen,
                descripcionOrigen,
                claveOrigen);

        return new GenericResponse<>(
                Constantes.HTTP_200,
                Constantes.MENSAJE_EXITO,
                origenModels);
    }

    /**
     * <b>actualizarOrigen</b>
     * @descripcion: Método PUT para actualizar origen
     * @autor: Diego Vázquez Pérez
     * @param idOrigen Identificador del origen a actualizar
     * @param descripcionOrigen Nueva descripción del origen
     * @param claveOrigen Nueva clave del origen
     * @param idStatus Nuevo status del origen
     * @param usuarioNombre Nombre del usuario que actualiza
     * @ultimaModificacion: 16/05/2022
     */

    @PUT
    @Path("/ActualizarOrigen")
    @Produces(MediaType.APPLICATION_JSON)
    public GenericResponse<Boolean> actualizarOrigen(
            @Schema(example = "1", description = "Identificador del origen.")
            @QueryParam("idOrigen") Integer idOrigen,

            @Schema(example = "Inteligencia de Datos e Innovación", description = "Descripción del origen.")
            @QueryParam("descripcionOrigen") String descripcionOrigen,

            @Schema(example = "IDI", description = "Clave del campo.")
            @QueryParam("claveOrigen") String claveOrigen,

            @Schema(example = "1", description = "Status del origen.")
            @QueryParam("idStatus") Integer idStatus,

            @Schema(example = "Daniel Hernandez", description = "Nombre del usuario que actualiza.")
            @QueryParam("usuarioNombre") String usuarioNombre
    ){

        boolean response = origenService.actualizarOrigen(
                idOrigen,
                descripcionOrigen,
                claveOrigen,
                idStatus,
                usuarioNombre);

        return new GenericResponse<>(
                Constantes.HTTP_200,
                Constantes.MENSAJE_EXITO,
                response);

    }
}
