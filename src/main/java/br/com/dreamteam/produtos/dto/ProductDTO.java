package br.com.dreamteam.produtos.dto;

import br.com.dreamteam.produtos.dto.base.BaseDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO extends BaseDTO {

    private String name;
}
