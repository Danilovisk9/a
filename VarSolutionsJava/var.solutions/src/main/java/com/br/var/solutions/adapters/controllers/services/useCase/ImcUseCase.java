package com.br.var.solutions.adapters.controllers.services.useCase;

import com.br.var.solutions.adapters.controllers.services.entities.InformacoesIMC;

public interface ImcUseCase {
     InformacoesIMC calculoImc(double peso, double altura);
}
