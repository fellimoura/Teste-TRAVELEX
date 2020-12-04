package br.com.confidencecambio.javabasico.controller;

import br.com.confidencecambio.javabasico.constants.ConstantsPath;
import br.com.confidencecambio.javabasico.entity.ClienteEntity;
import br.com.confidencecambio.javabasico.service.ClienteService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(value = ConstantsPath.PATH_CONFIDENCE_CAMBIO)
@Api(tags = {"Planeta"})
public class ClienteController {

    @Autowired
    private ClienteService service;

    @ApiOperation(value = "Realiza o calculo do IMC.")
    @ApiResponses({ @ApiResponse(code = 200, message = "Ok", response = String.class),
            @ApiResponse(code = 422, message = "Erro de validação nos campos", response = String.class),
            @ApiResponse(code = 500, message = "Erro interno do servidor", response = String.class), })
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> calcularIMC(@RequestParam("peso") Double peso, @RequestParam("altura") Double altura) {

        Double imc = service.calcularIMC(peso, altura);

        if (Objects.nonNull(imc)) {
            return new ResponseEntity<Double>(imc, HttpStatus.OK);
        }
        return new ResponseEntity<String>("Erro. Não conseguiu calcular IMC, por favor, tente mais tarde!", HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "Realiza busca do cliente pelo nome.")
    @ApiParam(name = "nome", required = false, type = "string")
    @ApiResponses({ @ApiResponse(code = 200, message = "Ok", responseContainer = "List", response = String.class),
            @ApiResponse(code = 500, message = "Erro interno do servidor", response = String.class), })
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> validarNomeDiferenteNulo(@RequestParam("nome") String nome) {

        Optional<ClienteEntity> optionalClienteEntity = service.validarNomeDiferenteNulo(nome);

        if (Objects.nonNull(optionalClienteEntity)) {
            return new ResponseEntity<String>(optionalClienteEntity.get().getNome(), HttpStatus.OK);
        }
        return new ResponseEntity<String>("Erro. Não conseguiu buscar o nome, por favor, tente mais tarde!", HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "Realiza busca do cliente pelo nome.")
    @ApiParam(name = "nome", required = false, type = "string")
    @ApiResponses({ @ApiResponse(code = 200, message = "Ok", responseContainer = "List", response = String.class),
            @ApiResponse(code = 500, message = "Erro interno do servidor", response = String.class), })
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> validarNomeDiferenteVazio(@RequestParam("nome") String nome) {

        Optional<ClienteEntity> optionalClienteEntity = service.validarNomeDiferenteVazio(nome);

        if (Objects.nonNull(optionalClienteEntity)) {
            return new ResponseEntity<String>(optionalClienteEntity.get().getNome(), HttpStatus.OK);
        }
        return new ResponseEntity<String>("Erro. Não conseguiu buscar o nome, por favor, tente mais tarde!", HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "Realiza busca do cliente pelo nome.")
    @ApiParam(name = "nome", required = false, type = "string")
    @ApiResponses({ @ApiResponse(code = 200, message = "Ok", responseContainer = "List", response = String.class),
            @ApiResponse(code = 500, message = "Erro interno do servidor", response = String.class), })
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> validarNomeSemEspacoInicioFim(@RequestParam("nome") String nome) {

        Optional<ClienteEntity> optionalClienteEntity = service.validarNomeSemEspacoInicioFim(nome);

        if (Objects.nonNull(optionalClienteEntity)) {
            return new ResponseEntity<String>(optionalClienteEntity.get().getNome(), HttpStatus.OK);
        }
        return new ResponseEntity<String>("Erro. Não conseguiu buscar o nome, por favor, tente mais tarde!", HttpStatus.BAD_REQUEST);
    }
    @ApiOperation(value = "Realiza busca do cliente pelo nome.")
    @ApiParam(name = "nome", required = false, type = "string")
    @ApiResponses({ @ApiResponse(code = 200, message = "Ok", responseContainer = "List", response = String.class),
            @ApiResponse(code = 500, message = "Erro interno do servidor", response = String.class), })
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> obterPrimeiroNome(@RequestParam("nome") String nome) {

        String primeiroNome = service.obterPrimeiroNome(nome);

        if (Objects.nonNull(primeiroNome)) {
            return new ResponseEntity<String>(primeiroNome, HttpStatus.OK);
        }
        return new ResponseEntity<String>("Erro. Não conseguiu buscar o nome, por favor, tente mais tarde!", HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "Realiza busca do cliente pelo nome.")
    @ApiParam(name = "nome", required = false, type = "string")
    @ApiResponses({ @ApiResponse(code = 200, message = "Ok", responseContainer = "List", response = String.class),
            @ApiResponse(code = 500, message = "Erro interno do servidor", response = String.class), })
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> retornarNomeLetrasMaiuscula(@RequestParam("nome") String nome) {

        String primeiroNome = service.retornarNomeLetrasMaiuscula(nome);

        if (Objects.nonNull(primeiroNome)) {
            return new ResponseEntity<String>(primeiroNome, HttpStatus.OK);
        }
        return new ResponseEntity<String>("Erro. Não conseguiu buscar o nome, por favor, tente mais tarde!", HttpStatus.BAD_REQUEST);
    }
}
