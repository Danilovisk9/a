package com.br.var.solutions.adapters.controllers.services.impl;

import com.br.var.solutions.adapters.controllers.services.entities.InformacoesIMC;
import com.br.var.solutions.adapters.controllers.services.useCase.ImcUseCase;
import org.springframework.stereotype.Service;

@Service
public class ImcUseCaseImpl implements ImcUseCase {
    public InformacoesIMC calculoImc(double peso, double altura) {
        return calculaImc(peso, altura);
    }

    private InformacoesIMC calculaImc(double peso, double altura) {
        double imc = peso / (altura * altura);

        InformacoesIMC imcCalculado = new InformacoesIMC();
        if (imc <= 18.5) {
            imcCalculado.setImc(String.valueOf(imc));
            imcCalculado.setClassificacao("Abaixo do peso.");
            return imcCalculado;
        } else if (imc >= 18.5 && imc <= 24.9) {
            imcCalculado.setImc(String.valueOf(imc));
            imcCalculado.setClassificacao("Peso Ideal.");
            return imcCalculado;
        } else if (imc > 24.9 && imc <= 39.9) {
            imcCalculado.setImc(String.valueOf(imc));
            imcCalculado.setClassificacao("Excesso de peso.");
            return imcCalculado;
        } else if (imc > 29.9 && imc <= 34.9) {
            imcCalculado.setImc(String.valueOf(imc));
            imcCalculado.setClassificacao("Obesidade Classe I");
            return imcCalculado;
        } else if (imc > 34.9 && imc < 39.9) {
            imcCalculado.setImc(String.valueOf(imc));
            imcCalculado.setClassificacao("Obesidade Classe II");
            return imcCalculado;
        } else {
            imcCalculado.setImc(String.valueOf(imc));
            imcCalculado.setClassificacao("Obesidade Classe III.");
            return imcCalculado;
        }
    }
}
