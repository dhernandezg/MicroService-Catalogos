package com.baz.daos.categorias;

import com.baz.models.CategoriasModel;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ExistenciaCategoriasDAO {

    @Inject
    EntityManager entityManager;

    /**
     * <b>${consumeExistenciaFuncion}</b>
     * @descripcion: Método DAO para consumo de función Existencia de Categorias en DB.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 05/05/2022
     */

    @Transactional
    public Integer consumeExistenciaFuncion(Integer idCategoria, String descripcionCategoria){

        Integer existenciaBinaria = 0;

        try{
            StoredProcedureQuery storedProcedureQuery = entityManager
                    .createStoredProcedureQuery("FNCATEGOEXIST")
                    .registerStoredProcedureParameter("PA_FICATEGORIAID", Integer.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("FCDESCCATEG", String.class, ParameterMode.IN)
                    .setParameter("PA_FICATEGORIAID", idCategoria)
                    .setParameter("FCDESCCATEG", descripcionCategoria);

            storedProcedureQuery.execute();

            existenciaBinaria = (Integer) storedProcedureQuery.getSingleResult();

        }catch (Exception e){
            e.printStackTrace();
        }

        return existenciaBinaria;
    }
}
