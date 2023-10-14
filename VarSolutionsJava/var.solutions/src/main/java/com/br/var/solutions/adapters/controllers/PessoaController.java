package com.br.var.solutions.adapters.controllers;


import ch.qos.logback.classic.Logger;
import com.br.var.solutions.adapters.controllers.services.useCase.*;
import com.br.var.solutions.adapters.entities.PessoaRequest;
import com.br.var.solutions.adapters.entities.PessoaResponse;
import com.br.var.solutions.adapters.controllers.services.entities.InformacoesIMC;
import lombok.extern.slf4j.Slf4j;
import org.jboss.logging.BasicLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Objects;

@RestController
@RequestMapping("/pessoa")
@CrossOrigin(origins = "*")
@Slf4j


public class PessoaController {

    //        1                    2               3               4
    // Publico / Privado | Tipo de retorno | nome do método | parametros
    @Autowired
    private MundialUseCase mundialUseCase;
    @Autowired
    private ImcUseCase imcUseCase;

    @Autowired
    private AnoNascimentoUseCase anoNascimentoUseCase;

    @Autowired
    private ImpostoRendaUseCase impostoRendaUseCase;

    @Autowired
    private ConverteSaldoEmDolarUseCase converteSaldoEmDolar;

    @Autowired
    private MontaRespostaFrontUseCase montaRespostaFrontUseCase;

    // EndPoint
    @GetMapping
    public ResponseEntity<Object> get() {
        PessoaRequest pessoaRequest1 = new PessoaRequest();
        pessoaRequest1.setNome("Danilo");
        pessoaRequest1.setSobrenome("Dias");
        pessoaRequest1.setEndereco("Rua Lua");
        pessoaRequest1.setIdade(16);

        return ResponseEntity.ok(pessoaRequest1);
    }

    @GetMapping("/resumo")
    public ResponseEntity<Object> getPessoa(@RequestBody PessoaRequest pessoaRequest, @RequestParam(value = "valida_mundial") Boolean DesejavalidaMundial) {
        InformacoesIMC imc = new InformacoesIMC();
        int anoNascimento = 0;
        String impostoRenda = null;
        String validaMundial = null;
        String saldoEmDolar = null;


        if (!pessoaRequest.getNome().isEmpty()) {

            Logger log = null;
            log.debug("Iniciando o processo de resumo da pessoa: ", pessoaRequest);

            if (Objects.nonNull(pessoaRequest.getPeso()) && Objects.nonNull(pessoaRequest.getAltura())) {
                log.error("Iniciando o calculo do IMC");
                imc = imcUseCase.calculoImc(pessoaRequest.getPeso(), pessoaRequest.getAltura());
            }

            if (Objects.nonNull(pessoaRequest.getIdade())) {
                log.info("Iniciando o calculo do ano de nascimento");
                anoNascimento = anoNascimentoUseCase.calculoAnoNasc(pessoaRequest.getIdade());
            }

            if (Objects.nonNull(pessoaRequest.getSalario())) {
                log.debug("Iniciando o calculo do imposto de renda");
                impostoRenda = impostoRendaUseCase.calculaFaixaImpostoRenda(pessoaRequest.getSalario());
            }

            if (Boolean.TRUE.equals(DesejavalidaMundial)) {
                if (Objects.nonNull(pessoaRequest.getTime())) log.info("Validando se o time de coração tem Mundial");
                validaMundial = mundialUseCase.calculoMundial(pessoaRequest.getTime());
            }


            if (Objects.nonNull(pessoaRequest.getSaldo())) {
                log.info("Convertendo real em Dólar");
                saldoEmDolar = converteSaldoEmDolar.converteSaldoEmDolar(pessoaRequest.getSaldo());
            }

            log.info("Montando objeto de retorno para o front-end");
            PessoaResponse resumo = montaRespostaFrontUseCase.montarRespostaFrontEnd(pessoaRequest, imc, anoNascimento, impostoRenda, validaMundial, saldoEmDolar);

            return ResponseEntity.ok(resumo);
        }
        return ResponseEntity.noContent().build();
    }
}



