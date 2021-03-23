package br.com.dreamteam.produtos.controller;

import br.com.dreamteam.produtos.controller.base.BaseController;
import br.com.dreamteam.produtos.dto.ProductDTO;
import br.com.dreamteam.produtos.model.Product;
import br.com.dreamteam.produtos.service.ProductService;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("produto")
public class ProductController extends BaseController<ProductService, Product, ProductDTO> {

    @Override
    protected URI getURILocation(ProductDTO product) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(product.getId()).toUri();
        return uri;
    }
}
