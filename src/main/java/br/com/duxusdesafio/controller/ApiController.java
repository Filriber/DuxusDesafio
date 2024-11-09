package br.com.duxusdesafio.controller;

import br.com.duxusdesafio.dto.*;
import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.service.ApiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {


    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @PostMapping("/cadastrar-integrantes")
    ResponseEntity<Object> cadastrarIntegrantes(@RequestBody IntegrantesRequest integrantesRequest) {

       apiService.cadastrarIntegrantes(integrantesRequest);
       return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/buscar-todos-integrantes")
    ResponseEntity<List<IntegrantesResponse>> buscarIntegrantes() {
        return ResponseEntity.ok(apiService.buscarIntegrantes());
    }

    @GetMapping("/buscar-integrante-por-nome")
    ResponseEntity<IntegrantesResponse> buscarIntegrantePorNome(
            @RequestParam("nome") String nome) {
        return ResponseEntity.ok(apiService.buscarIntegrantePorNome(nome));
    }
    @PostMapping ("/cadastrar-times")
    ResponseEntity<Object> cadastrarTimes(@RequestBody TimeRequest timeRequest){

        apiService.cadastrarTime(timeRequest);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/time-da-data")
    ResponseEntity<TimeResponse> buscarTimePorData(
            @RequestParam("data") LocalDate data){
        return ResponseEntity.ok(apiService.buscarTimePorData(data));
    }




}
