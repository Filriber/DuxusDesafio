package br.com.duxusdesafio.controller;

import br.com.duxusdesafio.service.ApiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {


    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }


}
