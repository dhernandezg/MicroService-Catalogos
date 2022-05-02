package com.baz.daos.categorias;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

@ApplicationScoped
public class ExistenciaCategoriasDAO {

    @Inject
    EntityManager entityManager;

    /**
     * <b>${consumeExistenciaFuncion}</b>
     * @descripcion: Método DAO para consumo de función Existencia de Categorias en DB.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 02/05/2022
     */

    @Transactional
    public int consumeExistenciaFuncion(String nombreCategoria){

        StoredProcedureQuery storedProcedureQuery = entityManager
                    .createStoredProcedureQuery("FNCATEGOEXIST")
                    .registerStoredProcedureParameter("PA_FCDESCCATEG", String.class, ParameterMode.IN)
                    .setParameter("PA_FCDESCCATEG", nombreCategoria);
            storedProcedureQuery.execute();

        return (int) storedProcedureQuery.getSingleResult();
    }
}
