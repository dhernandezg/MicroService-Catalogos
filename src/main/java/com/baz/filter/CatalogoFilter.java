package com.baz.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import com.baz.dtos.ErrorResponseDto;
import com.baz.dtos.MicroservicioResponseDto;
import com.baz.utils.Constantes;

@Provider
public class CatalogoFilter implements ContainerRequestFilter, ContainerResponseFilter {
    static final String UID_HEADER = "x-request-id";
    static final String MENSAJE_SIN_FOLIO = "El folio para esta operación es requerido";
    static final String MENSAJE_SIN_UID = "x-request-id es requerido para completar con la operación";

    static final String MENSAJE_SIN_ACCESO = "Se denegó el acceso al servicio";
    static final String MENSAJE_SIN_TOKEN = "Es necesario proporcionar un token para esta operación";
    static final String MENSAJE_SIN_AUTORIZACION = "No se cuenta con la autorización al sistema";

    static final String URL_AYUDA = "https://baz-developer.bancoazteca.com.mx/info#";

    @Override
    public void filter(ContainerRequestContext requestContext){
        //this.validarToken(requestContext);
        this.validarUid(requestContext);
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext){
       asignarFolio(requestContext, responseContext);
    }

    private void asignarFolio(ContainerRequestContext requestContext, ContainerResponseContext responseContext){
        var response = responseContext.getEntity();
        if (response instanceof MicroservicioResponseDto) {
            MicroservicioResponseDto respEnt = (MicroservicioResponseDto) response;
            String folio = requestContext.getHeaderString(UID_HEADER);
            respEnt.setFolio( folio == null ?respEnt.getFolio(): folio);
        }
    }

    private void validarToken(ContainerRequestContext requestContext) {
        if (existeToken(requestContext) && this.TokenValido("")) {
            ErrorResponseDto errorAccesoDenegado = new ErrorResponseDto();
            errorAccesoDenegado.setCodigo(Constantes.HTTP_400);
            errorAccesoDenegado.setMensaje(MENSAJE_SIN_FOLIO);
            errorAccesoDenegado.setInfo(URL_AYUDA);
            errorAccesoDenegado.agregarDetalles(MENSAJE_SIN_UID);
            AsignarError(requestContext, Status.FORBIDDEN, errorAccesoDenegado);
        }
    }

    private boolean existeToken(ContainerRequestContext requestContext) {
        boolean existeToken = this.ExisteEncabezado(requestContext, UID_HEADER);
        if (!existeToken) {
            ErrorResponseDto errorSinAutenticar = new ErrorResponseDto();
            errorSinAutenticar.setCodigo(Constantes.HTTP_401);
            errorSinAutenticar.setMensaje(MENSAJE_SIN_FOLIO);
            errorSinAutenticar.setInfo(URL_AYUDA);
            errorSinAutenticar.agregarDetalles(MENSAJE_SIN_UID);
            AsignarError(requestContext, Status.UNAUTHORIZED, errorSinAutenticar);
        }
        return existeToken;
    }

    public boolean TokenValido(String token) {
        return true;
    }

    public void validarUid(ContainerRequestContext requestContext) {
        boolean existeUid = this.ExisteEncabezado(requestContext, UID_HEADER);
        if (!existeUid) {
            ErrorResponseDto errorUid = new ErrorResponseDto();
            errorUid.setCodigo(Constantes.HTTP_400);
            errorUid.setMensaje(MENSAJE_SIN_FOLIO);
            errorUid.setInfo(URL_AYUDA);
            errorUid.agregarDetalles(MENSAJE_SIN_UID);
            AsignarError(requestContext, Status.BAD_REQUEST, errorUid);
        }
    }

    public <T> void AsignarError(ContainerRequestContext requestContext, Response.Status codigoHttp, T contenidoError) {
        Response response = Response.status(codigoHttp)
                .entity(contenidoError)
                .build();
        requestContext.abortWith(response);
    }

    public boolean ExisteEncabezado(ContainerRequestContext requestContext, String header) {
        String headerValue = requestContext.getHeaderString(header);
        return headerValue != null && headerValue.length() != 0;
    }
}
