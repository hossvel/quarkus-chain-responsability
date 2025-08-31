package com.hossvel.chain;

import com.hossvel.model.FacturaEntity;

public interface IAprobadorFactura {
    void aprobar(FacturaEntity factura);
    void setNext(IAprobadorFactura next);
}
