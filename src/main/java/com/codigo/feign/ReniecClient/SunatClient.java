package com.codigo.feign.ReniecClient;


import com.codigo.feign.aggregates.response.ReniecResponse;
import com.codigo.feign.aggregates.response.SunatResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "sunat-client", url = "${sunat.url}")
public interface SunatClient {

    @GetMapping("/ruc")
    SunatResponse getInfo(@RequestParam("numero")String numero,
                          @RequestHeader("Authorization") String autorization);




}
