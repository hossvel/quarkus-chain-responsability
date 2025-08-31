package com.hossvel.chain;

import com.hossvel.model.FacturaEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.WebApplicationException;

import java.time.LocalDate;

@ApplicationScoped
public class FechaAprobador implements IAprobadorFactura{
    private IAprobadorFactura next;

    public void aprobar(FacturaEntity factura) {
        if (factura.getFechaEmision().isAfter(LocalDate.now())) {
            System.out.println("Fecha Invalida");
            throw new WebApplicationException("Fecha inválida", 400);
        }
        if (next != null) next.aprobar(factura);
    }

    public void setNext(IAprobadorFactura next) {
        this.next = next;
    }
}
