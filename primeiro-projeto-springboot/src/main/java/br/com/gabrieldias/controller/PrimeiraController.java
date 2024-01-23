package br.com.gabrieldias.controller;


import br.com.gabrieldias.model.Objeto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController // Essa anotacao diz que essa classe vai ser um controlador de uma aplicacao web
@CrossOrigin(origins = "*") // Essa anotacao diz que qualquer servidor pode fazer requisicoes para este controlador
@RequestMapping("/primeiraController") // Toda vez que eu acessar a url /primeiraController vai cair dentro desta classe
public class PrimeiraController {


    @GetMapping("/primeiroMetodo/{id}") // Utilizar PathParams quando eu quiser passar um parametro na url, ideal para operacoes do tipo GET
    // Toda vez que eu acessar a url /primeiraController/primeiroMetodo vai cair dentro deste metodo, o {id} e um parametro que eu posso passar na url
    public String primeiroMetodo(@PathVariable Integer id) { // Essa anotacao diz que o parametro id vai ser o parametro que eu passei na url
        return "O parametro é " + id;
    }

    // Query Params
    @GetMapping("/metodoComQueryParams") // Ideal para operacoes do tipo GET, utilizar para receber dados de consulta
    public String metodoComQueryParams(@RequestParam String id, @RequestParam(name = "nome") String name) { // RequestParam é uma anotacao para dizer que o parametro id vai ser um parametro que eu vou passar na url
        return "O parametro com metodoQueryParams é " + id + "e o parametro name é " + name;
    }

    @GetMapping("/metodoComQueryParams2")
    public String metodoComQueryParams2(@RequestParam Map<String, String> allParams) { // @RequestParam com Map para pegar todos os parametros que eu passar na url
        return "Os parametros com metodoQueryParams é " + allParams.entrySet();
    }

    @GetMapping("/metodoJson")
    // Toda vez que eu acessar a url /primeiraController/metodoJson vai cair dentro deste metodo
    @ResponseBody // Essa anotacao diz que o retorno deste metodo vai ser o corpo da resposta da requisicao
    public Objeto metodoJson() {
        System.out.println("Funcionou!");
        return new Objeto(1, "Gabriel");
    }

    @PostMapping("/metodoComBodyParams")
    public String metodoComBodyParams(@RequestBody Usuario usuario) { // Utilizar quando eu quiser passar um objeto no corpo da requisicao, ideal para operacoes do tipo POST, PUT, DELETE
        return "O parametro com metodoComBodyParams é " + usuario.username + "e o parametro password é " + usuario.password;
    }

    @PostMapping("/metodoComHeaders")
    public String metodoComHeader(@RequestHeader("name") String name) { // // Utilizar quando eu quiser extrair um valor específico do cabeçalho "name" da requisição, útil quando você precisa extrair informações específicas dos cabeçalhos da solicitação, e você usa a anotação @RequestHeader para indicar qual cabeçalho você está interessado.
        return "O parametro com metodoComHeader é " + name;
    }

    @PostMapping("/metodoComListHeaders")
    public String metodoComListHeader(@RequestHeader Map<String, String> headers) { // Utilizar quando eu quiser extrair todos os valores do cabeçalho da requisição, útil quando você precisa extrair informações específicas dos cabeçalhos da solicitação, e você usa a anotação @RequestHeader para indicar qual cabeçalho você está interessado.
        return "O parametro com metodoComHeader é " + headers.entrySet();
    }

    record Usuario(String username, String password) { //
    }

}
