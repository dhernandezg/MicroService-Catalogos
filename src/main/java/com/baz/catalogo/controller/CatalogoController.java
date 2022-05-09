package com.baz.catalogo.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.baz.catalogo.models.Catalogo;
import com.baz.catalogo.services.CatalogoFactory;
import com.baz.dtos.CatalogoResponse;

@Path("/catalogos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CatalogoController {
    @Inject
    CatalogoFactory catalogoFactory;

    @GET
    public CatalogoResponse<Iterable<Catalogo>> Consultar(@QueryParam("idCategoria") Integer idCategoria,
            @QueryParam("idCatalogo") Integer idCatalogo,
            @QueryParam("idTipoCatalogo") Integer idTipoCatalogo,
            @QueryParam("descripcion") String descripcion) {
        Catalogo datosConsulta = new Catalogo(idCategoria, idCatalogo, idTipoCatalogo, descripcion);
        Iterable<Catalogo> catalogos = catalogoFactory.obtenerCatalogos(datosConsulta);
        return new CatalogoResponse<Iterable<Catalogo>>("200", "Operación exitosa.", catalogos);
    }

    @GET
    @Path("/{idCatalogo}")
    public CatalogoResponse<Iterable<Catalogo>> Consultar(@PathParam("idCatalogo") int idCatalogo) {
        Catalogo datosConsulta = new Catalogo(idCatalogo);
        Iterable<Catalogo> catalogos = catalogoFactory.obtenerCatalogos(datosConsulta);
        return new CatalogoResponse<Iterable<Catalogo>>("200", "Operación exitosa.", catalogos);
    }

    @POST
    public CatalogoResponse<Boolean> Alta(Catalogo datosInsercion) {
        boolean exitoAlta = catalogoFactory.agregarCatalogo(datosInsercion);
        return new CatalogoResponse<Boolean>("200", "Operación exitosa.", exitoAlta);
    }

    @DELETE
    @Path("/{idCatalogo}/categoria/{idCategoria}/usuario/{usuario}")
    public CatalogoResponse<Boolean> Eliminar(@PathParam("idCatalogo") Integer idCatalogo,
            @PathParam("idCategoria") Integer idCategoria,
            @PathParam("usuario") String usuario) {
        boolean exitoAlta = catalogoFactory.eliminarCatalogo(idCategoria, idCatalogo, usuario);
        return new CatalogoResponse<Boolean>("200", "Operación exitosa.", exitoAlta);
    }

    @PUT
    public CatalogoResponse<Boolean> Actualizar(Catalogo datosActualizacion) {
        return ActualizarCatalogo(datosActualizacion);
    }

    @PATCH
    public CatalogoResponse<Boolean> ActualizarCatalogo(Catalogo datosActualizacion) {
        boolean exitoAlta = catalogoFactory.actualizarCatalogo(datosActualizacion);
        return new CatalogoResponse<Boolean>("200", "Operación exitosa.", exitoAlta);
    }
}
