package br.com.confidencecambio.javabasico.service;

import br.com.confidencecambio.javabasico.entity.ClienteEntity;
import br.com.confidencecambio.javabasico.repository.ClienteRespository;
import org.dom4j.util.StringUtils;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRespository clienteRespository;

    public Double calcularIMC(Double peso, Double altura) {
        Double imc = peso / (altura * altura);
        return imc;
    }

    public Optional<ClienteEntity> validarNomeDiferenteNulo(String nome) {
        Optional<ClienteEntity> optionalClienteEntity = Optional.ofNullable(clienteRespository.findByNome(nome));
        if (optionalClienteEntity.isPresent()) {
            return optionalClienteEntity;
        }
        return null;
    }

    public Optional<ClienteEntity> validarNomeDiferenteVazio(String nome) {
        Optional<ClienteEntity> optionalClienteEntity = Optional.ofNullable(clienteRespository.findByNome(nome));
        if (!optionalClienteEntity.isEmpty()) {
            return optionalClienteEntity;
        }
        return null;
    }

    public Optional<ClienteEntity> validarNomeSemEspacoInicioFim(String nome) {
        Optional<ClienteEntity> optionalClienteEntity = Optional.ofNullable(clienteRespository.findByNome(nome));
        if (StringUtils.startsWithWhitespace(optionalClienteEntity.get().getNome())
                && StringUtils.endsWithWhitespace(optionalClienteEntity.get().getNome())) {
            return optionalClienteEntity;
        }
        return null;
    }

    public String obterPrimeiroNome(String nome) {
        Optional<ClienteEntity> optionalClienteEntity = Optional.ofNullable(clienteRespository.findByNome(nome));
        if (optionalClienteEntity.isPresent()) {
            String nomeCompleto = optionalClienteEntity.get().getNome();
            String primeiroNome = nomeCompleto.split(" ")[0];
            return primeiroNome;
        }
        return null;
    }

    public String[] obterUltimoNome(String nome) {
        Optional<ClienteEntity> optionalClienteEntity = Optional.ofNullable(clienteRespository.findByNome(nome));
        if (optionalClienteEntity.isPresent()) {
            String nomeCompleto = optionalClienteEntity.get().getNome();
            String[] textoSeparado = nomeCompleto.split(" ");
            String primeiroNome = nomeCompleto.split(" ")[0];
            //Arrays.stream(textoSeparado).dropWhile(primeiroNome);
            return null;
        }
        return null;
    }

    public String retornarNomeLetrasMaiuscula(String nome) {
        Optional<ClienteEntity> optionalClienteEntity = Optional.ofNullable(clienteRespository.findByNome(nome));
        if (optionalClienteEntity.isPresent()) {
            return optionalClienteEntity.get().getNome().toUpperCase(Locale.ROOT);
        }
        return null;
    }

}
