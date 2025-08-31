package com.hossvel.chain;

import com.hossvel.model.FacturaEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.WebApplicationException;

@ApplicationScoped
public class MontoAprobador  implements IAprobadorFactura{
    private IAprobadorFactura next;

    public void aprobar(FacturaEntity factura) {
        if (factura.getMonto() > 10000) {
            System.out.println("Monto Supera 10 000");
            throw new WebApplicationException("Monto excede el límite", 400);
        }
        if (next != null) next.aprobar(factura);
    }

    public void setNext(IAprobadorFactura next) {
        this.next = next;
    }
}
