package br.com.dreamteam.produtos.service.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CrudService<MODEL> {

    List<MODEL> findAll();

    Page<MODEL> findAll(Pageable pageable);

    MODEL findById(Long id);

    MODEL createElement(MODEL model);

    List<MODEL> createElements(List<MODEL> model);

    MODEL updateElement(Long id, MODEL model);

    boolean deleteElement(Long id);
}
