package com.baz.utils;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.hibernate.query.procedure.internal.ProcedureParameterImpl;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <b>BaseDeDatosService</b>
 * @descripcion: Servicio de acceso a ase de datos
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Data
@NoArgsConstructor
@ApplicationScoped
public class BaseDeDatosService {
    /**
     * Administrador de entidades hibernate para base de datos
     * */
    @Inject
    EntityManager em;

    /**
     * Obtiene una lista de elementos genéricos de una proyección de base de datos
     * @param procedure Procedimiento de base de datos
     * @return List<T> Retorna una lista de elementos genéricos<T>
     */
    @Transactional
    @SuppressWarnings("unchecked")
    public <T> List<T> obtenerElementos(StoredProcedure procedure) {
        StoredProcedureQuery query = em.createStoredProcedureQuery(procedure.getName(), procedure.getOutClass());
        setParameters(query, procedure.getParameters());
        return query.getResultList();
    }

    /**
     * Asigna los parámetros a un procedimiento de base de datos
     * @param query Procedimiento
     * @param params Parámetros
     */
    private void setParameters(StoredProcedureQuery query, Iterable<ProceduredParameter> params) {
        for (ProceduredParameter parameter : params) {
            query.registerStoredProcedureParameter(parameter.getName(), parameter.getType(),
                    parameter.getDirection());
            if (parameter.getValue() == null) {
                ((ProcedureParameterImpl<?>) query.getParameter(parameter.getName())).enablePassingNulls(true);
            } else {
                query.setParameter(parameter.getName(), parameter.getValue());
            }
        }
    }
}
