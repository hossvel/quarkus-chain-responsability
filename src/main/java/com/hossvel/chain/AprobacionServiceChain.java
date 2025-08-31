package com.hossvel.chain;

import com.hossvel.model.FacturaEntity;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AprobacionServiceChain {

    @Inject
    MontoAprobador monto;
    @Inject
    ClienteAprobador cliente;
    @Inject
    FechaAprobador fecha;

    @PostConstruct
    void init() {
        monto.setNext(cliente);
        cliente.setNext(fecha);
    }

    public void aprobarFactura(FacturaEntity factura) {
        monto.aprobar(factura);
        factura.setAprobada(true);

    }
}