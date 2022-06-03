package com.baz.tipocatalogo.controller;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.baz.tipocatalogo.models.TipoCatalogo;
import com.baz.tipocatalogo.models.DatosActualizacion;
import com.baz.tipocatalogo.models.DatosAlta;
import com.baz.tipocatalogo.models.DatosConsulta;
import com.baz.tipocatalogo.services.TipoCatalogoFactory;
import com.baz.dtos.CatalogoResponseDto;
import com.baz.utils.Constantes;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.jboss.resteasy.reactive.ResponseStatus;

/**
 * <b>TipoCatalogoController</b>
 * @descripcion: Controlador del endpoint para los tipos de catálogos
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Path("/tiposcatalogos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TipoCatalogoController {
    /**
     * Objeto con acceso a la fabrica de tipos de catálogos
     */
    @Inject
    TipoCatalogoFactory catalogoFactory;

    /**
     * Consulta la lista de catálogos con los parámetros especificados
     * @param @QueryParam("idTipoCatalogo")     - Contiene el identificador del tipo catalogo a consultar
     * @param @QueryParam("nombreTipoCatalogo") - Contiene la descripción del tipo catalogo a consultar
     * @return CatalogoResponse<Iterable<TipoCatalogo>> Respuesta con la lista de los tipos de catálogos
     */
    @GET
    @Operation(summary = "Consulta la lista de tipos de catálogos con los parámetros especificados")
    @Parameter(in = ParameterIn.HEADER, description = "Folio único de operación - UID", name = "x-request-id", required = true, example = "UID202220050001")
    @Parameter(in = ParameterIn.HEADER, description = "Token de acceso al MicroServicio", name = "token", required = true, example = "SFD54TEWRTFKTKR6AVUN44456")
    public CatalogoResponseDto<Iterable<TipoCatalogo>> consultar(
            @Parameter(description = "Contiene el identificador del tipo de catalogo a consultar", example = "1") @QueryParam("id") Short idTipoCatalogo,
            @Parameter(description = "Contiene la descripción o nombre del tipo de catalogo a consultar", example = "BASE") @QueryParam("nombre") String nombreTipoCatalogo) {
        DatosConsulta datosConsulta = new DatosConsulta(idTipoCatalogo, nombreTipoCatalogo);
        Iterable<TipoCatalogo> tiposDeCatalogos = catalogoFactory.obtenerTiposCatalogos(datosConsulta);
        return new CatalogoResponseDto<>(Constantes.HTTP_200, Constantes.MENSAJE_EXITO, tiposDeCatalogos);
    }

    /**
     * Registra un nuevo tipo de catalogo
     * @param datosInsercion - Datos del tipo catalogo a insertar
     * @return CatalogoResponse<Boolean> Respuesta con valor true si se registro correctamente
     */
    @POST
    @ResponseStatus(201)
    @Operation(summary = "Registra un nuevo catalogo")
    @Parameter(in = ParameterIn.HEADER, description = "Folio único de operación - UID", name = "x-request-id", required = true, example = "UID202220050001", schema = @org.eclipse.microprofile.openapi.annotations.media.Schema)
    @Parameter(in = ParameterIn.HEADER, description = "Token de acceso al MicroServicio", name = "token", required = true, example = "SFD54TEWRTFKTKR6AVUN44456", schema = @org.eclipse.microprofile.openapi.annotations.media.Schema)
    public CatalogoResponseDto<Boolean> registrar(
            @Parameter(description = "Datos del tipo catalogo a insertar", required = true) DatosAlta datosInsercion) {
        boolean exitoAlta = catalogoFactory.agregarTipoCatalogo(datosInsercion);
        return new CatalogoResponseDto<>(Constantes.HTTP_201, Constantes.MENSAJE_EXITO, exitoAlta);
    }

    /**
     * Elimina un tipo de catalogo a partir de un identificador
     * @param @PathParam("idTipoCatalogo") - Identificador del tipo de catalogo
     * @param @PathParam("usuario")        - Usuario que realiza la eliminación
     * @return CatalogoResponse<Boolean> Respuesta eliminación con valor true si fue exitoso
     */
    @DELETE
    @Path("/{idTipoCatalogo}/usuario/{usuario}")
    @Operation(summary = "Elimina un tipo de catalogo a partir de un identificador")
    @Parameter(in = ParameterIn.HEADER, description = "Folio único de operación - UID", name = "x-request-id", required = true, example = "UID202220050001")
    @Parameter(in = ParameterIn.HEADER, description = "Token de acceso al MicroServicio", name = "token", required = true, example = "SFD54TEWRTFKTKR6AVUN44456")
    public CatalogoResponseDto<Boolean> eliminar(
            @Parameter(description = "Identificador del tipo de catalogo") @PathParam("idTipoCatalogo") Short idTipoCatalogo,
            @Parameter(description = "Usuario que opera") @PathParam("usuario") String usuario) {
        boolean exitoEliminar = catalogoFactory.eliminarTipoCatalogo(idTipoCatalogo, usuario);
        return new CatalogoResponseDto<>(Constantes.HTTP_200, Constantes.MENSAJE_EXITO, exitoEliminar);
    }

    /**
     * Actualiza los datos especificados de un tipo de catalogo
     * @param datosActualizacion - Datos de actualización
     * @return CatalogoResponse<Boolean> - Respuesta de actualización, true si fue exitosa
     */
    @PUT
    @Operation(summary = "Actualiza los datos especificados de un tipo catalogo")
    @Parameter(in = ParameterIn.HEADER, description = "Folio único de operación - UID", name = "x-request-id", required = true, example = "UID000000000001", schema = @org.eclipse.microprofile.openapi.annotations.media.Schema)
    @Parameter(in = ParameterIn.HEADER, description = "Token de acceso al MicroServicio", name = "token", required = true, example = "SFD54TEWRTFKTKR6AVUN44456", schema = @org.eclipse.microprofile.openapi.annotations.media.Schema)
    public CatalogoResponseDto<Boolean> actualizar(
            @Parameter(description = "Datos de actualización", required = true) DatosActualizacion datosActualizacion) {
        boolean exitoActualizar = catalogoFactory.actualizarTipoCatalogo(datosActualizacion);
        return new CatalogoResponseDto<>(Constantes.HTTP_200, Constantes.MENSAJE_EXITO, exitoActualizar);
    }
}
