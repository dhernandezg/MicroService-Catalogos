package com.baz.daos.categorias;

import com.baz.models.CategoriasModel;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import java.math.BigDecimal;

@ApplicationScoped
public class ConsultarCategoriasDAO {

    @Inject
    EntityManager entityManager;

    /**
     * <b>${consultarCategoriasFuncion}</b>
     * @descripcion: Método DAO para consumo de función Consultar Categorias en DB.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 05/05/2022
     */

    @Transactional
    public CategoriasModel consultarCategoriasFuncion(int idCategoria, String descripcionCategoria){

        CategoriasModel categoriasModel = new CategoriasModel();

        try{
            StoredProcedureQuery storedProcedureQuery = entityManager
                    .createStoredProcedureQuery("FNCATEGORIASEL")
                    .registerStoredProcedureParameter("v_CATEGORIAID", BigDecimal.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("v_DESCCATEG", String.class, ParameterMode.IN)
                    .setParameter("v_CATEGORIAID", idCategoria)
                    .setParameter("v_DESCCATEG", descripcionCategoria);

            storedProcedureQuery.execute();

            categoriasModel = (CategoriasModel) storedProcedureQuery.getResultList();

        }catch (Exception e){
            e.printStackTrace();
        }

        return categoriasModel;
    }
}
