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
 * @descripcion: Entidad que contiene los métodos de acceso a la fabrica de Tipos Catálogos
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Model
public class TipoCatalogoFactory {
        /**
         * Objeto con acceso a datos para actualizar los tipos de catálogos
         */
        @Inject
        ActualizarTipoCatalogoDao actualizaTipoCatalogo;

        /**
        * Objeto con acceso a datos para registrar los tipos de catálogos
        */
        @Inject
        RegistrarTipoCatalogoDao altaTipoCatalogo;

        /**
         * Objeto con acceso a datos para consultar los tipos de catálogos
         */
        @Inject
        ConsultarTipoCatalogoDao consultaTipoCatalogo;

        /**
         * Objeto con acceso a datos para eliminar los tipos de catálogos
         */
        @Inject
        EliminarTipoCatalogoDao eliminaTiposCatalogo;

        /**
         * Realiza la actualización de un tipo de catalogo
         * @param datosTipoCatalogo Datos del tipo de catalogo a actualizar
         * @return boolean True su la actualización fue correcta
         */
        public boolean actualizarTipoCatalogo(DatosActualizacion datosTipoCatalogo) {
                return actualizaTipoCatalogo.actualizarTipoCatalogo(datosTipoCatalogo);
        }

        /**
         * Realiza el registro o alta de un tipo de catalogo
         * @param datosTipoCatalogo Datos del catalogo a registrar
         * @return boolean True si el registro fue exitoso
         */
        public boolean agregarTipoCatalogo(DatosAlta datosTipoCatalogo) {
                return altaTipoCatalogo.agregarTipoCatalogo(datosTipoCatalogo);
        }

        /**
         * Realiza la eliminación de un catalogo
         * @param idCategoria Identificador de la categoría
         * @param usuario     Usuario que elimina
         * @return boolean True si la eliminación fue exitosa
         */
        public boolean eliminarTipoCatalogo(Short idCategoria, String usuario) {
                return eliminaTiposCatalogo.eliminarTipoCatalogo(idCategoria, usuario);
        }

        /**
         * Realiza la consulta de catálogos dado los parámetros especificados
         * @param datosCatalogo Datos de consulta los datos nulos son parámetros opcionales de consulta
         * @return List<Catalogo> Lista de catálogos
         */
        public List<TipoCatalogo> obtenerTiposCatalogos(DatosConsulta datosCatalogo) {
                return consultaTipoCatalogo.obtenerTiposCatalogos(datosCatalogo);
        }
}
