package com.hossvel.chain;

import com.hossvel.model.FacturaEntity;
import com.hossvel.service.IClienteService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;

@ApplicationScoped
public class ClienteAprobador  implements IAprobadorFactura{
    private IAprobadorFactura next;

    @Inject
    IClienteService iclienteService;

    public void aprobar(FacturaEntity factura) {
        if (!iclienteService.isActive(factura.getCliente())) {
            System.out.println("Cliente Inactivo");
            throw new WebApplicationException("Cliente inactivo", 403);
        }
        if (next != null) next.aprobar(factura);
    }

    public void setNext(IAprobadorFactura next) {
        this.next = next;
    }
}
