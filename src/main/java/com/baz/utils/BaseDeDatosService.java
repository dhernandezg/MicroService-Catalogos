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

@Data
@NoArgsConstructor
@ApplicationScoped
public class BaseDeDatosService {
    @Inject
    EntityManager em;

    @Transactional
    public <T> List<T> obtenerElementos(StoredProcedure procedure) {
        StoredProcedureQuery query = em.createStoredProcedureQuery(procedure.getName(), procedure.getOutClass());
        SetParameters(query, procedure.getParameters());
        return query.getResultList();
    }

    private void SetParameters(StoredProcedureQuery query, Iterable<ProceduredParameter> params) {
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
