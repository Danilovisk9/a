package com.br.var.solutions.adapters.controllers.services.impl;

import com.br.var.solutions.adapters.controllers.services.useCase.AnoNascimentoUseCase;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AnoNascimentoUseCaseImpl implements AnoNascimentoUseCase {
    public int calculoAnoNasc(int idade) {
        return calculaAnoNascimento(idade);
    }

    private int calculaAnoNascimento(int idade) {
        LocalDate datalocal = LocalDate.now();
        int anoAtual = datalocal.getYear();
        return anoAtual - idade;
    }
}