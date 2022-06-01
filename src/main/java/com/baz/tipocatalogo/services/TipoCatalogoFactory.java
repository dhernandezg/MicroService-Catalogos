package com.baz.tipocatalogo.services;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.baz.tipocatalogo.daos.*;
import com.baz.tipocatalogo.models.TipoCatalogo;
import com.baz.tipocatalogo.models.DatosActualizacion;
import com.baz.tipocatalogo.models.DatosAlta;
import com.baz.tipocatalogo.models.DatosConsulta;

/**
 * <b>CatalogoFactory</b>
 * @descripcion: Entidad que representa la estructura de una respuesta genérica de base de datos
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Model
public class TipoCatalogoFactory {
        //Objeto con acceso a datos para actualizar catálogos
        @Inject
        ActualizarTipoCatalogoDao actualizaCatalogo;

        //Objeto con acceso a datos para registrar catálogos
        @Inject
        RegistrarTipoCatalogoDao altaCatalogo;
        @Inject

        //Objeto con acceso a datos para consultar catálogos
        ConsultarTipoCatalogoDao consultaCatalogo;
        @Inject

        //Objeto con acceso a datos para eliminar catálogos
        EliminarTipoCatalogoDao eliminaCatalogo;

        /**
         * Realiza la actualización de un catalogo dato un objeto tipo catalogo
         * @param datosCatalogo Datos del catalogo a actualizar
         * @return boolean True su la actualización fue correcta
         */
        public boolean actualizarTipoCatalogo(DatosActualizacion datosCatalogo) {
                return actualizaCatalogo.actualizarTipoCatalogo(datosCatalogo);
        }

        /**
         * Realiza el registro o alta de un catalogo
         * @param datosCatalogo Datos del catalogo a registrar
         * @return boolean True si el registro fue exitoso
         */
        public boolean agregarTipoCatalogo(DatosAlta datosCatalogo) {
                return altaCatalogo.agregarTipoCatalogo(datosCatalogo);
        }

        /**
         * Realiza la eliminación de un catalogo
         * @param idCategoria Identificador de la categoría
         * @param idCatalogo Identificador del catalogo
         * @param usuario Usuario que elimina
         * @return boolean True si la eliminación fue exitosa
         */
        public boolean eliminarTipoCatalogo(Integer idCategoria, String usuario) {
                return eliminaCatalogo.eliminarTipoCatalogo(idCategoria, usuario);
        }

        /**
         * Realiza la consulta de catálogos dado los parámetros especificados
         * @param datosCatalogo Datos de consulta los datos nulos son parámetros opcionales de consulta
         * @return List<Catalogo> Lista de catálogos
         */
        public List<TipoCatalogo> obtenerTiposCatalogos(DatosConsulta datosCatalogo) {
                return consultaCatalogo.obtenerTiposCatalogos(datosCatalogo);
        }
}
