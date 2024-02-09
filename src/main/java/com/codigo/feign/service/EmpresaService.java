package com.codigo.feign.service;

import com.codigo.feign.aggregates.request.EmpresaRequest;
import com.codigo.feign.aggregates.request.PersonaRequest;
import com.codigo.feign.aggregates.response.BaseResponse;
import com.codigo.feign.aggregates.response.SunatResponse;

public interface EmpresaService {

    BaseResponse crearEmpresa(EmpresaRequest empresaRequest);

    BaseResponse getInfoEmpresa(String numero);
}
