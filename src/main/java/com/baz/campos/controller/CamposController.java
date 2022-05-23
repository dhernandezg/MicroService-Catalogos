package com.baz.campos.controller;

import com.baz.campos.models.CamposModel;
import com.baz.campos.services.CamposService;
import com.baz.categorias.dtos.GenericResponse;
import com.baz.utils.Constantes;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/CamposService")
public class CamposController {

    @Inject
    CamposService camposService;

    /**
     * <b>listaOperaciones</b>
     * @descripcion: Método para mostrar lista de operaciones que
     * el usuario puede ejecutar en Campos.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 19/05/2022
     */

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Consulta las operaciones disponibles en el servicio de campos.")
    public GenericResponse<ArrayList> listaOperaciones(){

        return new GenericResponse<>(
                Constantes.HTTP_200,
                Constantes.MENSAJE_EXITO,
                camposService.listaOperacionesCampos());
    }

    /**
     * <b>consultarCampo</b>
     * @descripcion: Servicio GET para consultar campo
     * @autor: Diego Vázquez Pérez
     * @param idCampo Identificador del campo
     * @param descripcionCampo Descripción del campo
     * @ultimaModificacion: ${date}
     */

    @GET
    @Path("/ConsultaCampo")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Consulta los campos disponibles en el servicio de campos.")
    public GenericResponse<Iterable<CamposModel>> consultarCampo(
            @Schema(example = "1", description = "Identificador del campo.")
            @QueryParam("idCampo") Integer idCampo,
            @Schema(example = "CLAVE", description = "Descripción del campo.")
            @QueryParam("descripcionCategoria") String descripcionCampo){

        Iterable<CamposModel> camposModels = camposService.consultarCampo(idCampo,
                descripcionCampo);

        return new GenericResponse<>(
                Constantes.HTTP_200,
                Constantes.MENSAJE_EXITO,
                camposModels);
    }

    /**
     * <b>crearCampo</b>
     * @descripcion: Método POST para crear campo
     * @autor: Diego Vázquez Pérez
     * @param descripcionCampo Descripcion del campo.
     * @param usuarioNombre Nombre del usuario
     * @ultimaModificacion: 19/05/2022
     */

    @POST
    @Path("/CrearCampo")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Registra un nuevo campo.")
    public GenericResponse<Boolean> crearCampo(
            @Schema(example = "ID", description = "Nombre del campo.")
            @QueryParam("nombreCampo") String nombreCampo,

            @Schema(example = "NOMBRE_CORTO", description = "Descripción del campo.")
            @QueryParam("descripcionCampo") String descripcionCampo,

            @Schema(example = "Daniel Hernandez", description = "Nombre del usuario.")
            @QueryParam("usuarioNombre") String usuarioNombre){

        boolean response = camposService.crearCampo(
                nombreCampo,
                descripcionCampo,
                usuarioNombre);

        return new GenericResponse<>(Constantes.HTTP_200,
                Constantes.MENSAJE_EXITO,
                response);

    }

    /**
     * <b>actualizarCampo</b>
     * @descripcion: Método PUT para actualizar campo
     * @autor: Diego Vázquez Pérez
     * @param idCampo Identificador del campo
     * @param descripcionCampo Descripción del campo
     * @param idStatus Identificador del status
     * @param usuarioNombre Nombre del usuario
     * @ultimaModificacion: 23/05/2022
     */

    @PUT
    @Path("/ActualizarCampo")
    @Operation(summary = "Actualiza el registro de un campo existente.")
    @Produces(MediaType.APPLICATION_JSON)
    public GenericResponse<Boolean> actualizarCampo(
            @Schema(example = "1", description = "Identificador del campo.")
            @QueryParam("idCampo") Short idCampo,
            @Schema(example = "ID", description = "Nombre del campo.")
            @QueryParam("nombreCampo") String nombreCampo,
            @Schema(example = "Identificador", description = "Descripción del campo.")
            @QueryParam("descripcionCampo") String descripcionCampo,
            @Schema(example = "1", description = "Status del campo.")
            @QueryParam("idStatus") Short idStatus,
            @Schema(example = "Daniel Hernandez", description = "Nombre del usuario.")
            @QueryParam("usuarioNombre") String usuarioNombre){

        boolean response = camposService.actualizarCampo(idCampo,
                usuarioNombre,
                nombreCampo,
                descripcionCampo,
                idStatus);

        return new GenericResponse<>(
                Constantes.HTTP_200,
                Constantes.MENSAJE_EXITO,
                response);

    }

    /**
     * <b>eliminarCampo</b>
     * @descripcion: Método DELETE para eliminar campos.
     * @autor: Diego Vázquez Pérez
     * @param idCampo Identificador del campo
     * @param usuarioNombre Nombre del usuario
     * @ultimaModificacion: 10/05/2022
     */

    @DELETE
    @Path("/EliminarCampo")
    @Operation(summary = "Elimina un campo mediante su identificador.")
    @Produces(MediaType.APPLICATION_JSON)
    public GenericResponse<Boolean> eliminarCampo(
            @Schema(example = "1", description = "Identificador del campo.")
            @QueryParam("idCampo") Short idCampo,
            @Schema(example = "Daniel Hernandez", description = "Nombre del usuario.")
            @QueryParam("usuarioNombre") String usuarioNombre){

        boolean response = camposService.eliminarCampo(
                idCampo,
                usuarioNombre);

        return new GenericResponse<>(
                Constantes.HTTP_200,
                Constantes.MENSAJE_EXITO,
                response);
    }
}
