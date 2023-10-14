package com.br.var.solutions.adapters.controllers;

import com.br.var.solutions.adapters.entities.GenerateToken;
import com.br.var.solutions.adapters.controllers.services.entities.ValidaUsuario;
import com.br.var.solutions.infraestructure.config.security.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
@Slf4j

public class AuthenticateController {

    @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<GenerateToken> generateToken(@RequestParam("client_id") String clientId,
                                                       @RequestParam("password") String password) {


        Log log = null;
        log.info("Iniciando a tentativa de geração de token para o usuário: " + clientId);
        Boolean validaUsuario = ValidaUsuario.validaUsuario(clientId, password);

        if (Boolean.FALSE.equals(validaUsuario)) {
            log.error("Não foi possível gerar o token, pois o usuário ou senha são incorretos.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new GenerateToken());
        }

        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();

        String token = jwtTokenUtil.generateToken(clientId);

        GenerateToken tokenResponse = new GenerateToken();
        tokenResponse.setToken(token);

        log.info("Token gerado com sucessopara o usuário: " + clientId + " Em: " + System.currentTimeMillis());

        return ResponseEntity.ok(tokenResponse);
    }
}
