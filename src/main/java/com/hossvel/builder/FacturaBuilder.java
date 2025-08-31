package com.hossvel.builder;

import com.hossvel.model.FacturaDTO;
import com.hossvel.model.FacturaEntity;

public class FacturaBuilder {

    private final FacturaEntity factura = new FacturaEntity();

    public FacturaBuilder desdeDTO(FacturaDTO dto) {
        factura.setCliente(dto.cliente);
        factura.setMonto(dto.monto);
        factura.setFechaEmision(dto.fechaEmision);
        return this;
    }

    public FacturaEntity build() {
        return factura;
    }
}
