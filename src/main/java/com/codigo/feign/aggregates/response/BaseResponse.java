package com.codigo.feign.aggregates.response;

import lombok.*;

import java.util.Optional;

@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {
    private int code;
    private String message;
    private Optional data;
}
