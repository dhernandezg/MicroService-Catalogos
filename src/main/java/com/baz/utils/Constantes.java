package com.baz.utils;

public class Constantes {

    public final static String CREATE = "CREAR";
    public final static String READ = "CONSULTAR";
    public final static String UPDATE = "ACTUALIZAR";
    public final static String DELETE = "ELIMINAR";
    public final static String SEQUENCE = "SECUENCIA";
    public final static String EXISTENCE = "EXISTENCIA";

    //CODIGOS HTTP

    public final static String HTTP_200 = "200";
    public final static String HTTP_201 = "201";
    public final static String HTTP_400 = "400";
    public final static String HTTP_401 = "401";
    public final static String HTTP_404 = "404";
    public final static String HTTP_500 = "500";

    //MENSAJES HTTP

    public final static String MENSAJE_EXITO = "Operación exitosa.";
    public final static String MENSAJE_CODIGO400 = "Datos de entrada incorrectos, por favor valide su información.";
    public final static String MENSAJE_CODIGO401 = "No estas autorizado, favor de validar.";
    public final static String MENSAJE_CODIGO404 = "Recurso no encontrado";
    public final static String MENSAJE_CODIGO500 = "Ocurrió un incoveniente al procesar la solicitud.";
    public final static String MENSAJE_CODIGO500_LOG = "Problemas al procesar su solicitud favor de contactar a su administrador.";
}
