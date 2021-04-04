package br.com.dreamteam.produtos.controller;

import br.com.dreamteam.produtos.controller.base.BaseController;
import br.com.dreamteam.produtos.dto.SubcategoryDTO;
import br.com.dreamteam.produtos.service.SubcategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/subcategory")
public class SubcategoryController extends BaseController<SubcategoryService, SubcategoryDTO> {

    @Override
    protected URI getURILocation(SubcategoryDTO subcategory) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(subcategory.getId()).toUri();
        return uri;
    }
}
