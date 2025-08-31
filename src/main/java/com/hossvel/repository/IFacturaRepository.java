package com.hossvel.repository;

import com.hossvel.model.FacturaEntity;

import java.util.Set;

public interface IFacturaRepository {

    public Set<FacturaEntity> listAll();
    public FacturaEntity guardar(FacturaEntity facturaEntity);
}
