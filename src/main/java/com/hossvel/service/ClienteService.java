package com.hossvel.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClienteService implements IClienteService{
    @Override
    public boolean isActive(String cliente) {
        return !cliente.isBlank();
    }
}
