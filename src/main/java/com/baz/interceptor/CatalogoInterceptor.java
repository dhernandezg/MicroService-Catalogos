package com.baz.interceptor;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.baz.dtos.ErrorResponseDto;
import com.baz.dtos.ResponseDto;
import com.baz.utils.Constantes;

import io.quarkus.hibernate.validator.runtime.jaxrs.ViolationReport;
import io.quarkus.hibernate.validator.runtime.jaxrs.ViolationReport.Violation;

/**
 * <b>CatalogoInterceptor</b>
 * @descripcion: Interceptor para MicroServicio de catálogos
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Provider
public class CatalogoInterceptor implements ContainerResponseFilter {
    /**
     * Contantes interceptor
     */
    static final String MENSAJE_PETICION_INVALIDA = "La información proporcionada no es valida";
    static final String FORMATO_DATO_INVALIDO = "El dato %s %s";

    /**
     * Interceptor para respuestas HTTP
     * @param requestContext  Petición HTTP
     * @param responseContext Respuesta HTTP
     */
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        validarPeticion(responseContext);
        String folio = requestContext.getHeaderString(Constantes.UID_HEADER);
        asignarFolio(responseContext.getEntity(), folio);
    }

    /**
     * Asigna la respuesta de validación para la solicitud HTTP
     * @param responseContext Respuesta HTTP
     */
    private void validarPeticion(ContainerResponseContext responseContext) {
        var respuesta = responseContext.getEntity();
        if (respuesta instanceof ViolationReport) {
            ViolationReport validacionResponse = (ViolationReport) respuesta;
            ErrorResponseDto errorValidacion = new ErrorResponseDto();
            errorValidacion.setCodigo(Constantes.HTTP_400);
            errorValidacion.setMensaje(MENSAJE_PETICION_INVALIDA);
            errorValidacion.setInfo(Constantes.URL_AYUDA);
            for (Violation violacion : validacionResponse.getViolations()) {
                String detalleValidacion = String.format(FORMATO_DATO_INVALIDO, violacion.getField(),
                        violacion.getMessage());
                errorValidacion.agregarDetalles(detalleValidacion);
            }
            asignarError(responseContext, Response.Status.BAD_REQUEST, errorValidacion);
        }
    }

    /**
     * Asigna el error Http especificado a una petición HTTP
     * @param requestContext Petición
     * @param codigoHttp     Código de error HTTP
     * @param contenidoError Detalle del error
     */
    public <T> void asignarError(ContainerResponseContext responseContext, Response.Status codigoHttp,
            T contenidoError) {
        Response response = Response.status(codigoHttp)
                .entity(contenidoError)
                .build();
        responseContext.setEntity(response.getEntity());
    }

    /**
     * Asigna el folio de operación a la respuesta HTTP
     * @param response Objeto contenedor de respuesta
     * @param folio    Folio de operación
     */
    private <T> void asignarFolio(T response, String folio) {
        if (response != null && response instanceof ResponseDto) {
            ResponseDto respEnt = (ResponseDto) response;
            respEnt.setFolio(folio == null ? respEnt.getFolio() : folio);
        }
    }
}
