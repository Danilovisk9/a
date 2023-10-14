package com.br.var.solutions.adapters.controllers.services.impl;

import com.br.var.solutions.adapters.controllers.services.entities.InformacoesIMC;
import com.br.var.solutions.adapters.entities.PessoaRequest;
import com.br.var.solutions.adapters.entities.PessoaResponse;
import com.br.var.solutions.adapters.controllers.services.useCase.MontaRespostaFrontUseCase;
import org.springframework.stereotype.Service;

@Service
public class MontaRespostaFrontUseCaseImpl implements MontaRespostaFrontUseCase {
    public PessoaResponse montarRespostaFrontEnd(PessoaRequest pessoaRequest, InformacoesIMC imc, int anoNascimento, String impostoRenda, String validaMundial, String saldoEmDolar) {
        PessoaResponse response = new PessoaResponse();

        response.setNome(pessoaRequest.getNome());
        response.setSobrenome(pessoaRequest.getSobrenome());
        response.setEndereco(pessoaRequest.getEndereco());
        response.setIdade(pessoaRequest.getIdade());
        response.setPeso(pessoaRequest.getPeso());
        response.setAltura(pessoaRequest.getAltura());
        response.setSaldo(pessoaRequest.getSaldo());
        response.setImc(imc.getImc());
        response.setClassificacaoIMC(imc.getClassificacao());
        response.setSalario(impostoRenda);
        response.setAnoNascimento(anoNascimento);
        response.setMundialClubes(validaMundial);
        response.setSaldoEmDolar(saldoEmDolar);
        response.setTime(pessoaRequest.getTime());

        return response;
    }
}
