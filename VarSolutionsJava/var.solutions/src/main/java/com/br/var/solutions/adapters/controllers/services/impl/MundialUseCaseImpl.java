package com.br.var.solutions.adapters.controllers.services.impl;

import com.br.var.solutions.adapters.controllers.services.useCase.MundialUseCase;
import org.springframework.stereotype.Service;

@Service
public class MundialUseCaseImpl implements MundialUseCase {

    public String calculoMundial(String time){
        return calculaMundial(time);
    }
    private String calculaMundial(String time) {
        if (time.equalsIgnoreCase("Sao Paulo")) {
            return "Parabens, o seu time possui 3 mundiais de clubes conforme a FIFA";
        } else if (time.equalsIgnoreCase("Palmeiras")) {
            return "Seu time nao tem mundial";
        } else if (time.equalsIgnoreCase("Santos")) {
            return "Seu time tem dois mundiais";
        } else {
            return "Poxa, que pena, continue torcendo para seu clube ganhar um mundial";
        }
    }
}
