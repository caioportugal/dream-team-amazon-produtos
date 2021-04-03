package br.com.dreamteam.produtos.dto;

import br.com.dreamteam.produtos.dto.base.BaseDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDTO extends BaseDTO {

    private String name;

    private List<SubcategoryDTO> subcategories;
}
