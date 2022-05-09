package com.baz.categorias.daos;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

@ApplicationScoped
public class SecuenciaCategoriasDAO {
    @Inject
    EntityManager entityManager;

    /**
     * <b>${consumeSecuenciaFuncion}</b>
     * @descripcion: Método DAO para consumo de función Secuencia de Categorias en DB.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 02/05/2022
     */

    @Transactional
    public int consumeSecuenciaFuncion(){

        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("fnconsultasecuencia");
        storedProcedureQuery.execute();

        return (int) storedProcedureQuery.getSingleResult();
    }
}
