package com.hossvel.service;

import com.hossvel.model.FacturaEntity;
import com.hossvel.model.FacturaDTO;

import java.util.Set;

public interface IFacturaService {
    public FacturaEntity crearFactura(FacturaDTO dto);
    public Set<FacturaEntity> listAll();

}
