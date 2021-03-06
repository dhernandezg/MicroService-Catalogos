package com.baz.catalogo.controller;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.baz.catalogo.models.Catalogo;
import com.baz.catalogo.models.DatosActualizacion;
import com.baz.catalogo.models.DatosAlta;
import com.baz.catalogo.models.DatosConsulta;
import com.baz.catalogo.services.CatalogoFactory;
import com.baz.dtos.CatalogoResponseDto;
import com.baz.utils.Constantes;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.models.examples.Example;

/**
 * <b>CatalogoController</b>
 * @descripcion: Controlador del endpoint para catálogos
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Path("/catalogos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CatalogoController {
    /**
     * Objeto con acceso a la fabrica de catálogos
     */
    @Inject
    CatalogoFactory catalogoFactory;

    /**
     * Consulta la lista de catálogos con los parámetros especificados
     * @param @QueryParam("idCategoria") - Contiene el identificador de categoría a consultar
     * @param @QueryParam("idCatalogo")  - Contiene el identificador del catalogo a consultar
     * @param @QueryParam("descripcion") - Contiene la descripción del catalogo a consultar
     * @return CatalogoResponse<Iterable<Catalogo>> Respuesta con la lista de catálogos
     */
    @GET
    @Operation(summary = "Consulta la lista de catálogos con los parámetros especificados")
    @Parameter(in = ParameterIn.HEADER, description = "Folio único de operación - UID", name = "x-request-id", required = true, example = "UID202220050001")
    public CatalogoResponseDto<Iterable<Catalogo>> consultar(
            @Parameter(description = "Contiene el identificador de categoría a consultar", example = "1") @QueryParam("idCategoria") Integer idCategoria,
            @Parameter(description = "Contiene el identificador del catalogo a consultar", example = "1") @QueryParam("idCatalogo") Integer idCatalogo,
            @Parameter(description = "Contiene la descripción del catalogo a consultar") @QueryParam("descripcion") String descripcion) {
        DatosConsulta datosConsulta = new DatosConsulta(idCategoria, idCatalogo, descripcion);
        Iterable<Catalogo> catalogos = catalogoFactory.obtenerCatalogos(datosConsulta);
        return new CatalogoResponseDto<>(Constantes.HTTP_200, Constantes.MENSAJE_EXITO, catalogos);
    }

    /**
     * Consulta la lista de catálogos por identificador de catalogo especificado
     * @param idCatalogo Identificador catalogo
     * @return CatalogoResponse<Iterable<Catalogo>> Respuesta con lista de catálogos
     */
    @GET
    @Path("/{idCatalogo}")
    @Operation(summary = "Consulta la lista de catálogos por identificador de catalogo especificado")
    @Parameter(in = ParameterIn.HEADER, description = "Folio único de operación - UID", name = "x-request-id", required = true)
    public CatalogoResponseDto<Iterable<Catalogo>> consultar(
            @Parameter(description = "Identificador catalogo") @PathParam("idCatalogo") int idCatalogo) {
        DatosConsulta datosConsulta = new DatosConsulta(idCatalogo);
        Iterable<Catalogo> catalogos = catalogoFactory.obtenerCatalogos(datosConsulta);
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
        boolean exitoAlta = catalogoFactory.agregarCatalogo(datosInsercion);
        return new CatalogoResponseDto<>(Constantes.HTTP_200, "Operación exitosa.", exitoAlta);
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
        boolean exitoEliminar = catalogoFactory.eliminarCatalogo(idCategoria, idCatalogo, usuario);
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
        boolean exitoActualizar = catalogoFactory.actualizarCatalogo(datosActualizacion);
        return new CatalogoResponseDto<>(Constantes.HTTP_200, Constantes.MENSAJE_EXITO, exitoActualizar);
    }
}
