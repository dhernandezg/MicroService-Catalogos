package com.baz.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class StoredProcedure {

    private String name;

    @Setter(AccessLevel.PRIVATE)
    private List<ProceduredParameter> parameters;

    @Setter(AccessLevel.PRIVATE)
    private Class<?> outClass;

    public <T> StoredProcedure(String name, Class<T> outClass, ProceduredParameter... parameters) {
        this(outClass);
        this.name = name;
        this.addParameters(parameters);
    }

    public <T> StoredProcedure(Class<T> outClass) {
        this.outClass = outClass;
        this.parameters = new ArrayList<ProceduredParameter>();
    }

    public void addParameters(ProceduredParameter... parameters) {
        for (ProceduredParameter proceduredParameter : parameters) {
            this.parameters.add(proceduredParameter);
            this.parameters.sort(Comparator.comparing(ProceduredParameter::getIndexParam));
        }
    }
}
