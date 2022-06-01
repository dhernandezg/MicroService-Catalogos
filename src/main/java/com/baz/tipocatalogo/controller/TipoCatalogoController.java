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
     * @param @QueryParam("idCategoria") - Contiene el identificador de categoría a consultar
     * @param @QueryParam("idCatalogo")  - Contiene el identificador del catalogo a consultar
     * @param @QueryParam("descripcion") - Contiene la descripción del catalogo a consultar
     * @return CatalogoResponse<Iterable<Catalogo>> Respuesta con la lista de catálogos
     */
    @GET
    @Operation(summary = "Consulta la lista de tipos de catálogos con los parámetros especificados")
    @Parameter(in = ParameterIn.HEADER, description = "Folio único de operación - UID", name = "x-request-id", required = true, example = "UID202220050001")
    public CatalogoResponseDto<Iterable<TipoCatalogo>> consultar(
            @Parameter(description = "Contiene el identificador del tipo de catalogo a consultar", example = "1") @QueryParam("idTipoCatalogo") Short idTipoCatalogo,
            @Parameter(description = "Contiene la descripción del tipo de catalogo a consultar") @QueryParam("nombreTipoCatalogo") String nombreTipoCatalogo) {
        DatosConsulta datosConsulta = new DatosConsulta(idTipoCatalogo, nombreTipoCatalogo);
        Iterable<TipoCatalogo> tiposDeCatalogos = catalogoFactory.obtenerTiposCatalogos(datosConsulta);
        return new CatalogoResponseDto<>(Constantes.HTTP_200, Constantes.MENSAJE_EXITO, tiposDeCatalogos);
    }

    /**
     * Registra un nuevo catalogo
     * @param datosInsercion - Datos del catalogo a insertar
     * @return CatalogoResponse<Boolean> Respuesta con valor true si se registro correctamente
     */
    @POST
    @ResponseStatus(201)
    @Operation(summary = "Registra un nuevo catalogo")
    @Parameter(in = ParameterIn.HEADER, description = "Folio único de operación - UID", name = "x-request-id", required = true, example = "UID000000000001", schema =  @org.eclipse.microprofile.openapi.annotations.media.Schema)
    public CatalogoResponseDto<Boolean> registrar(@Parameter(description = "Datos del catalogo a insertar", required = true) DatosAlta datosInsercion) {
        boolean exitoAlta = catalogoFactory.agregarTipoCatalogo(datosInsercion);
        return new CatalogoResponseDto<>(Constantes.HTTP_201, Constantes.MENSAJE_EXITO, exitoAlta);
    }

    /**
     * Elimina un catalogo a partir de un identificador
     * @param @PathParam("idCatalogo")  - Identificador de catalogo
     * @param @PathParam("idCategoria") - Identificador de categoría
     * @param @PathParam("usuario")     - Usuario que realiza la eliminación
     * @return CatalogoResponse<Boolean> Respuesta eliminación con valor true si fue exitoso
     */
    @DELETE
    @Path("/{idCatalogo}/categoria/{idCategoria}/usuario/{usuario}")
    @Operation(summary = "Elimina un catalogo a partir de un identificador")
    @Parameter(in = ParameterIn.HEADER, description = "Folio único de operación - UID", name = "x-request-id", required = true)
    public CatalogoResponseDto<Boolean> eliminar(
            @Parameter(description = "Identificador de catalogo") @PathParam("idCatalogo") Integer idCatalogo,
            @Parameter(description = "Identificador de categoría") @PathParam("idCategoria") Integer idCategoria,
            @Parameter(description = "Usuario que opera") @PathParam("usuario") String usuario) {
        boolean exitoEliminar = catalogoFactory.eliminarTipoCatalogo(idCategoria, usuario);
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
        boolean exitoActualizar = catalogoFactory.actualizarTipoCatalogo(datosActualizacion);
        return new CatalogoResponseDto<>(Constantes.HTTP_200, Constantes.MENSAJE_EXITO, exitoActualizar);
    }
}
