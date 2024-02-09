package com.codigo.feign.controller;


import com.codigo.feign.aggregates.response.BaseResponse;
import com.codigo.feign.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/persona")
@RequiredArgsConstructor
public class PersonaController {

    private final PersonaService personaService;


    @GetMapping("/{numero}")
    private BaseResponse getInfoReniec(@PathVariable("numero") String numero){
        return personaService.getInfoPersona(numero);
    }
}
