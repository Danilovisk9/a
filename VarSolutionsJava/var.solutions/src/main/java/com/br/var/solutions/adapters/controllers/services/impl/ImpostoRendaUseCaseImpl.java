package com.br.var.solutions.adapters.controllers.services.impl;

import ch.qos.logback.classic.Logger;
import com.br.var.solutions.adapters.controllers.services.useCase.ImpostoRendaUseCase;
import org.springframework.stereotype.Service;

@Service
public class ImpostoRendaUseCaseImpl implements ImpostoRendaUseCase {

    private String calculaFaixaImpostoRenda() {
        return calculaFaixaImpostoRenda();
    }

    // Regra: Base de calculo é Salario Brueto x ALiquota - Dedução
    public String calculaFaixaImpostoRenda(double salario) {

        Logger log = null;
        log.info("Iniciando o calculo de imposto de renda: " + salario);

        String novoSalarioCalculado;

        if (salario < 1903.98) {
            return "isento";

        } else if (salario > 190 && salario < 2826.65) {
            double calculoIRF = 142.80 - ((salario * 0.075) / 100);
            double novoSalario = salario - calculoIRF;
            novoSalarioCalculado = String.valueOf(novoSalario);

            return novoSalarioCalculado;

        } else if (salario >= 2826.66 && salario < 3751.05) {
            double calculoIRF = 354.80 - ((salario * 0.15) / 100);
            double novoSalario = salario - calculoIRF;
            novoSalarioCalculado = String.valueOf(novoSalario);

            return novoSalarioCalculado;

        } else if (salario >= 3751.06 && salario < 4664.68) {
            double calculoIRF = 636.13 - ((salario * 0.22) / 100);
            double novoSalario = salario - calculoIRF;
            novoSalarioCalculado = String.valueOf(novoSalario);

            return novoSalarioCalculado;
        } else {
            double calculoIRF = 869.36 - ((salario * 275) / 100);
            double novoSalario = salario - calculoIRF;
            novoSalarioCalculado = String.valueOf(novoSalario);

            return novoSalarioCalculado;
        }
    }
}
