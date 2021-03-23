package br.com.dreamteam.produtos.service.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CrudService<DTO> {

    List<DTO> findAll();

    Page<DTO> findAll(Pageable pageable);

    DTO findById(Long id);

    DTO createElement(DTO dto);

    DTO updateElement(Long id, DTO dto);

    void deleteElement(Long id);
}
