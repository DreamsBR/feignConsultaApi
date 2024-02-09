package com.codigo.feign.controller;


import com.codigo.feign.aggregates.response.BaseResponse;
import com.codigo.feign.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/sunat/v1")
@RequiredArgsConstructor
public class EmpresaController {

    private final EmpresaService empresaService;

    @GetMapping("/{numero}")
     private BaseResponse getEmpresaData(@PathVariable("numero") String numero){
        return empresaService.getInfoEmpresa(numero);
    }
}
