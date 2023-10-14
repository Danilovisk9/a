package com.br.var.solutions.adapters.controllers.services.impl;

import com.br.var.solutions.adapters.controllers.services.useCase.ConverteSaldoEmDolarUseCase;
import org.springframework.stereotype.Service;

@Service
public class ConverteSaldoEmDolarUseCaseImpl implements ConverteSaldoEmDolarUseCase {
    public String converteSaldoEmDolar(double saldo) {
        return String.valueOf(saldo / 5.11);
    }
}

