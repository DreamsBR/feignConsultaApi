package com.codigo.feign.service.impl;

import com.codigo.feign.aggregates.constans.Constans;
import com.codigo.feign.aggregates.request.PersonaRequest;
import com.codigo.feign.aggregates.response.BaseResponse;
import com.codigo.feign.aggregates.response.ReniecResponse;
import com.codigo.feign.ReniecClient.ReniecClient;
import com.codigo.feign.repository.PersonaRepository;
import com.codigo.feign.service.PersonaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;

    private final ReniecClient reniecClient;

    public PersonaServiceImpl (PersonaRepository personaRepository, ReniecClient reniecClient) {
        this.personaRepository = personaRepository;
        this.reniecClient = reniecClient;
    }
    @Value("${token.api}")
    private String tokenApi;

    @Override
    public BaseResponse crearPersona(PersonaRequest personaRequest) {
        return null;
    }

    @Override
    public BaseResponse getInfoPersona(String numero) {
        ReniecResponse respons = getExecution(numero);
        if (respons != null){
            return new BaseResponse(Constans.CODE_SUCCESS, Constans.MESS_SUCCESS, Optional.of(respons));
        }else{
            return new BaseResponse(Constans.CODE_ERROR, Constans.MESS_ERROR, Optional.of(respons));
        }
    }

    private ReniecResponse getExecution (String numero){
        String authorization = "Bearer " + tokenApi;
        return reniecClient.getInfo(numero, authorization);

    }
}
