package com.hossvel.repository;

import com.hossvel.model.FacturaEntity;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

@ApplicationScoped
public class FacturaRepository implements IFacturaRepository{
    private Set<FacturaEntity> facturaEntities = Collections.newSetFromMap(Collections.synchronizedMap(new HashMap<>()));

    public Set<FacturaEntity> listAll() {

        return facturaEntities;
    }

    public FacturaEntity guardar(FacturaEntity facturaEntity) {
        System.out.println(facturaEntity.toString());
        facturaEntities.add(facturaEntity);

        return facturaEntity;
    }
}
