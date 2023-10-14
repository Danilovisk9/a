package com.br.var.solutions.adapters.controllers.services.useCase;

import com.br.var.solutions.adapters.controllers.services.entities.InformacoesIMC;
import com.br.var.solutions.adapters.entities.PessoaRequest;
import com.br.var.solutions.adapters.entities.PessoaResponse;

public interface MontaRespostaFrontUseCase {
    PessoaResponse montarRespostaFrontEnd(PessoaRequest pessoaRequest, InformacoesIMC imc, int anoNascimento, String impostoRenda, String validaMundial, String saldoEmDolar);
}
