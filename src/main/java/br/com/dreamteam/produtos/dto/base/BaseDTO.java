package br.com.dreamteam.produtos.dto.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BaseDTO {

    @EqualsAndHashCode.Include
    private Long id;
}
