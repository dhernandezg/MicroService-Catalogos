package com.baz.jerarquia.controller;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.baz.dtos.CatalogoResponseDto;
import com.baz.jerarquia.models.DatosActualizacion;
import com.baz.jerarquia.models.DatosAlta;
import com.baz.jerarquia.models.DatosConsulta;
import com.baz.jerarquia.models.Jerarquia;
import com.baz.jerarquia.services.JerarquiaFactory;
import com.baz.utils.Constantes;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
 
/**
 * <b>JerarquiaController</b>
 * @descripcion: Controlador del endpoint para las jerarquias
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Path("/jerarquias")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class JerarquiaController {
    /**
     * Objeto con acceso a la fabrica de jerarquias
     */
    @Inject
    JerarquiaFactory jerarquiaFactory;

    /**
     * Consulta la lista de catálogos con los parámetros especificados
     * @param @QueryParam("idCategoria") - Contiene el identificador de categoría a consultar
     * @param @QueryParam("idCatalogo")  - Contiene el identificador del catalogo a consultar
     * @param @QueryParam("idJerarquia") - Contiene identificador del catalogo hijo
     * @return CatalogoResponse<Iterable<Jerarquia>> Respuesta con la lista de catálogos
     */
    @GET
    @Operation(summary = "Consulta la lista de jerarquias con los parámetros especificados")
    @Parameter(in = ParameterIn.HEADER, description = "Folio único de operación - UID", name = "x-request-id", required = true, example = "UID202220050001")
    public CatalogoResponseDto<Iterable<Jerarquia>> consultar(
            @Parameter(description = "Contiene el identificador de categoría a consultar", example = "1") @QueryParam("idCategoria") Integer idCategoria,
            @Parameter(description = "Contiene el identificador del catalogo a consultar", example = "1") @QueryParam("idCatalogo") Integer idCatalogo,
            @Parameter(description = "Contiene el identificador del catalogo hijo", example = "1") @QueryParam("idJerarquia") Integer idJerarquia) {
        DatosConsulta datosConsulta = new DatosConsulta(idCategoria, idCatalogo, idJerarquia);
        Iterable<Jerarquia> catalogos = jerarquiaFactory.obtenerJerarquia(datosConsulta);
        return new CatalogoResponseDto<>(Constantes.HTTP_200, Constantes.MENSAJE_EXITO, catalogos);
    }

    /**
     * Registra un nuevo catalogo
     * @param datosInsercion - Datos del catalogo a insertar
     * @return CatalogoResponse<Boolean> Respuesta con valor true si se registro correctamente
     */
    @POST
    @Operation(summary = "Registra un nuevo catalogo")
    @Parameter(in = ParameterIn.HEADER, description = "Folio único de operación - UID", name = "x-request-id", required = true, example = "UID000000000001", schema =  @org.eclipse.microprofile.openapi.annotations.media.Schema)
    public CatalogoResponseDto<Boolean> registrar(@Parameter(description = "Datos del catalogo a insertar", required = true) DatosAlta datosInsercion) {
        boolean exitoAlta = jerarquiaFactory.agregarJerarquia(datosInsercion);
        return new CatalogoResponseDto<>(Constantes.HTTP_200, "Operación exitosa.", exitoAlta);
    }

    /**
     * Elimina un catalogo a partir de un identificador
     * @param @PathParam("idCatalogo")  - Identificador de catalogo
     * @param @PathParam("idCategoria") - Identificador de categoría
     * @param @PathParam("idCatalogoHijo") - Identificador de catalogo hijo
     * @param @PathParam("usuario")     - Usuario que realiza la eliminación
     * @return CatalogoResponse<Boolean> Respuesta eliminación con valor true si fue exitoso
     */
    @DELETE
    @Path("/{idCatalogo}/categoria/{idCategoria}/catalogohijo/{idCatalogoHijo}/usuario/{usuario}")
    @Operation(summary = "Elimina una jerarquia a partir de un identificador")
    @Parameter(in = ParameterIn.HEADER, description = "Folio único de operación - UID", name = "x-request-id", required = true)
    public CatalogoResponseDto<Boolean> eliminar(
            @Parameter(description = "Identificador de catalogo") @PathParam("idCatalogo") Integer idCatalogo,
            @Parameter(description = "Identificador de categoría") @PathParam("idCategoria") Integer idCategoria,
            @Parameter(description = "Identificador de del catalogo hijo") @PathParam("idCatalogoHijo") Integer idCatalogoHijo,
            @Parameter(description = "Usuario que opera") @PathParam("usuario") String usuario) {
        boolean exitoEliminar = jerarquiaFactory.eliminarJerarquia(idCategoria, idCatalogo, idCatalogoHijo, usuario);
        return new CatalogoResponseDto<>(Constantes.HTTP_200, Constantes.MENSAJE_EXITO, exitoEliminar);
    }

    /**
     * Actualiza los datos especificados de un catalogo
     * @param datosActualizacion - Datos de actualización
     * @return CatalogoResponse<Boolean> - Respuesta de actualización, true si fue exitosa
     */
    @PUT
    @Operation(summary = "Actualiza los datos especificados de un catalogo")
    @Parameter(in = ParameterIn.HEADER, description = "Folio único de operación - UID", name = "x-request-id", required = true, example = "UID000000000001", schema =  @org.eclipse.microprofile.openapi.annotations.media.Schema)
    public CatalogoResponseDto<Boolean> actualizar(
            @Parameter(description = "Datos de actualización", required = true) DatosActualizacion datosActualizacion) {
        boolean exitoActualizar = jerarquiaFactory.actualizarJerarquia(datosActualizacion);
        return new CatalogoResponseDto<>(Constantes.HTTP_200, Constantes.MENSAJE_EXITO, exitoActualizar);
    }
}
