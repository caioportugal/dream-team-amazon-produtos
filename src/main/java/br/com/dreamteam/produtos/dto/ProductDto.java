package br.com.dreamteam.produtos.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ProductDto {

    private Long id;

    private String name;
}
