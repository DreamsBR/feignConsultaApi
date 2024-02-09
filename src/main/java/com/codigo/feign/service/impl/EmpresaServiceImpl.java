package com.codigo.feign.service.impl;

import com.codigo.feign.ReniecClient.SunatClient;
import com.codigo.feign.aggregates.constans.Constans;
import com.codigo.feign.aggregates.request.EmpresaRequest;
import com.codigo.feign.aggregates.request.PersonaRequest;
import com.codigo.feign.aggregates.response.BaseResponse;
import com.codigo.feign.aggregates.response.ReniecResponse;
import com.codigo.feign.aggregates.response.SunatResponse;
import com.codigo.feign.entity.PersonaEntity;
import com.codigo.feign.repository.EmpresaRepository;
import com.codigo.feign.service.EmpresaService;
import com.codigo.feign.service.PersonaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;

    private final SunatClient sunatClient;

    public EmpresaServiceImpl(EmpresaRepository empresaRepository, SunatClient sunatClient) {
        this.empresaRepository = empresaRepository;
        this.sunatClient = sunatClient;
    }
    @Value("${token.api}")
    private String tokenApi;

    @Override
    public BaseResponse crearEmpresa(EmpresaRequest empresaRequest) {

        return null;
    }

    @Override
    public BaseResponse getInfoEmpresa(String numero) {
        SunatResponse respons = getInfo(numero);
        if (respons != null){
            return new BaseResponse(Constans.CODE_SUCCESS, Constans.MESS_SUCCESS, Optional.of(respons));
        }else{
            return new BaseResponse(Constans.CODE_ERROR, Constans.MESS_ERROR, Optional.of(respons));
        }
    }

    private SunatResponse getInfo(String ruc){
        String authorization = "Bearer " + tokenApi;
        return sunatClient.getInfo(ruc, authorization);
    }
}
