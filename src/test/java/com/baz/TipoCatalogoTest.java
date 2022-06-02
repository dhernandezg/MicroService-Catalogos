package com.baz;

import com.baz.dtos.CatalogoResponseDto;
import com.baz.tipocatalogo.controller.TipoCatalogoController;
import com.baz.tipocatalogo.models.*;
import com.baz.utils.Constantes;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.common.collect.Iterables;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.util.List;

import static io.restassured.RestAssured.*;

@QuarkusTest
public class TipoCatalogoTest {
    @Inject TipoCatalogoController tipoCatalogo;
    final static String SERVICIO = "/tiposcatalogos";
    final static String TOKEN_CODIGO ="codigo";
    final static String TOKEN_CONTENT_TYPE="Content-Type";
    final static String CONTENT_TYPE="application/json";
    final static  ObjectMapper mapper = new ObjectMapper();

    private String TOKEN;
    private String UID;
    private DatosAlta datosAlta = null;
    private DatosActualizacion datosActualizacion = null;
    private List<TipoCatalogo> tiposCatalogos;

    public TipoCatalogoTest() throws NoSuchAlgorithmException{
        datosAlta = new DatosAlta("Mi tipo personalizado", generarAleatorio("USR%1$5s", '0'));
        datosActualizacion = new DatosActualizacion((short)-1,"Mi tipo actualizado",generarAleatorio("USR%1$5s", '0'),(short)2);

        TOKEN = generarAleatorio("T%1$8s", '0');
        UID = generarAleatorio("UID%1$12s", '0');
    }

    private String generarAleatorio(String format,char filler) throws NoSuchAlgorithmException{
        Random random = SecureRandom.getInstanceStrong();
        return  String.format(format, random.nextInt(Integer.MAX_VALUE - 1))
        .replace(' ',filler);
    }

    @Test
    public void TestConsulta() throws JsonMappingException, JsonProcessingException{
        //Consultar todos los tipos de catálogos
        var response = given()
        .header(Constantes.TOKEN_HEADER,TOKEN)
        .header(Constantes.UID_HEADER,UID)
        .when().get(SERVICIO);

        //Validamos estatus de la petición
        response
        .then().statusCode(200)
        .body(TOKEN_CODIGO, is(Constantes.HTTP_200));

        //Validamos contenido de la respuesta
        String data = response.getBody().asString();
        mapper.registerModule(new JavaTimeModule());
        CatalogoResponseDto<Iterable<TipoCatalogo>> contenidoRespuesta = mapper.readValue(data,new TypeReference<CatalogoResponseDto<Iterable<TipoCatalogo>>>(){});
        this.tiposCatalogos = StreamSupport.stream(contenidoRespuesta.getRespuesta().spliterator(),false).collect(Collectors.toList());
    }

    @Test
    public void TestHeaders(){
        //Consulta sin headers
        given()
        .when().get(SERVICIO)
        .then().statusCode(401);
        //Consulta solo con token
        given()
        .header(Constantes.TOKEN_HEADER,TOKEN)
        .when().get(SERVICIO)
        .then().statusCode(400);
        //Consulta con todos los cabeceros
        given()
        .header(Constantes.TOKEN_HEADER,TOKEN)
        .header(Constantes.UID_HEADER,UID)
        .when().get(SERVICIO)
        .then().statusCode(200);
    }

    @Test
    public void TestAlta() throws JsonProcessingException{
        //Consultamos todos los tipos catalogos y registramos cuantos existen
        TestConsulta();
        Integer contadorAntesDeRegistro  = Iterables.size(tiposCatalogos);

        //Registramos un nuevo tipo catalogo
        given()
        .body(mapper.writeValueAsString(this.datosAlta))
        .header(Constantes.TOKEN_HEADER,TOKEN)
        .header(Constantes.UID_HEADER,UID)
        .header(TOKEN_CONTENT_TYPE, CONTENT_TYPE)
        .when().post(SERVICIO)
        .then().statusCode(201)
        .body(TOKEN_CODIGO, is(Constantes.HTTP_201));

        //Volvemos a consultar los tipos catálogos y validamos que exista uno mas
        TestConsulta();
        Integer contadorDespuesDeRegistro  = Iterables.size(tiposCatalogos);
        assertSame(contadorDespuesDeRegistro , contadorAntesDeRegistro +1);

        //Buscamos en la lista de tipos catálogos el nuevo registro que se dio de alta
        var items = tiposCatalogos.stream()
        .filter(tCat-> tCat.getNombre().compareTo(datosAlta.getTipoCatalogo()) == 0 &&
                        tCat.getUsuarioCreacion().compareTo(datosAlta.getUsuario()) ==0)
        .count();
        assert(items==1);
    }

    @Test
    public void TestActualizacion() throws JsonMappingException, JsonProcessingException{
         //Consultamos todos los tipos catálogos y obtenemos el ultimo
         TestConsulta();
         int tamañoLista = tiposCatalogos.size();
         assert(tamañoLista>0);
         TipoCatalogo ultimoRegistro = tiposCatalogos.get(tamañoLista-1);
         this.datosActualizacion.setIdTipoCatalogo(ultimoRegistro.getIdTipoCatalogo());

        //Registramos un nuevo tipo catalogo
        given()
        .body(mapper.writeValueAsString(this.datosActualizacion))
        .header(Constantes.TOKEN_HEADER,TOKEN)
        .header(Constantes.UID_HEADER,UID)
        .header(TOKEN_CONTENT_TYPE, CONTENT_TYPE)
        .when().put(SERVICIO)
        .then().statusCode(200)
        .body(TOKEN_CODIGO, is(Constantes.HTTP_200));

          //Volvemos a consultar los tipos catálogos y validamos el ultimo
        TestConsulta();
        TipoCatalogo registroActualizado = tiposCatalogos.get(tamañoLista-1);

        assert(ultimoRegistro.getIdTipoCatalogo().compareTo(registroActualizado.getIdTipoCatalogo())==0 &&
            ultimoRegistro.getNombre().compareTo(datosActualizacion.getTipoCatalogo()) == 0 &&
            ultimoRegistro.getFechaModificacion().compareTo(registroActualizado.getFechaModificacion()) != 0
        );
    }

    public void TestEliminacion(){

    }
}
