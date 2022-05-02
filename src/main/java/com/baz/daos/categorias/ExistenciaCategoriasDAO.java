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

    @Transactional
    public int consumeExistenciaFuncion(String nombreCategoria){
        int response;

            StoredProcedureQuery storedProcedureQuery = entityManager
                    .createStoredProcedureQuery("FNCATEGOEXIST")
                    .registerStoredProcedureParameter("PA_FCDESCCATEG", String.class, ParameterMode.IN)
                    .setParameter("PA_FCDESCCATEG", nombreCategoria);
            storedProcedureQuery.execute();

            response = (int) storedProcedureQuery.getSingleResult();

        return response;
    }
}
