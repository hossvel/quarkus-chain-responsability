package com.hossvel.service;

import com.hossvel.builder.FacturaBuilder;
import com.hossvel.chain.AprobacionServiceChain;
import com.hossvel.model.FacturaEntity;
import com.hossvel.model.FacturaDTO;
import com.hossvel.repository.IFacturaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Set;
@ApplicationScoped
public class FacturaService implements IFacturaService {

    @Inject
    IFacturaRepository facturaRepository;
    @Inject
    AprobacionServiceChain aprobacionServiceChain;

    public FacturaEntity crearFactura(FacturaDTO dto) {


        FacturaEntity entity = new FacturaBuilder()
                .desdeDTO(dto)
                .build();

        aprobacionServiceChain.aprobarFactura(entity);

        return facturaRepository.guardar(entity);

    }

    @Override
    public Set<FacturaEntity> listAll() {
        return facturaRepository.listAll();
    }
}
