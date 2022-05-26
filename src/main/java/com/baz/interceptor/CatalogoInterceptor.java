package com.baz.interceptor;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import com.baz.dtos.ResponseDto;
import com.baz.utils.Constantes;

/**
 * <b>CatalogoInterceptor<T></b>
 * @descripcion: Interceptor para MicroServicio de catálogos
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Provider
public class CatalogoInterceptor implements ContainerResponseFilter {
    /**
     * Filtro para respuestas HTTP
     * @param requestContext Petición HTTP
     * @param responseContext Respuesta HTTP
     */
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        asignarFolio(requestContext, responseContext);
    }

    /**
     * Asigna el folio de operación a la respuesta HTTP
     * @param requestContext Petición HTTP
     * @param responseContext Respuesta HTTP
     */
    private void asignarFolio(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        var response = responseContext.getEntity();
        if (response instanceof ResponseDto) {
            ResponseDto respEnt = (ResponseDto) response;
            String folio = requestContext.getHeaderString(Constantes.UID_HEADER);
            respEnt.setFolio(folio == null ? respEnt.getFolio() : folio);
        }
    }
}
