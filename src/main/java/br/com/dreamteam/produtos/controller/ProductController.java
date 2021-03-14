package br.com.dreamteam.produtos.controller;

import br.com.dreamteam.produtos.controller.base.BaseController;
import br.com.dreamteam.produtos.dto.ProductDto;
import br.com.dreamteam.produtos.model.Product;
import br.com.dreamteam.produtos.service.ProductService;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("produto")
public class ProductController extends BaseController<ProductService, Product, ProductDto> {

    @Override
    protected List convertToListDto(List<Product> products) {
        return modelMapper.map(products, new TypeToken<List<ProductDto>>() {}.getType());
    }

    @Override
    protected ProductDto convertToDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    protected Product convertToModel(ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }
}
