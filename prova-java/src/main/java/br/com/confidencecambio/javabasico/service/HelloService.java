package br.com.confidencecambio.javabasico.service;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HelloService {

    private static final String valorPadrao = "Mundo";

    public String retornaValorValido(@Nullable String nome) {
        return Optional.ofNullable(nome).orElse(valorPadrao);
    }
}
