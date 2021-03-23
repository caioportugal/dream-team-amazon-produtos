package br.com.dreamteam.produtos.service;

import br.com.dreamteam.produtos.dto.ProductDTO;
import br.com.dreamteam.produtos.model.Product;
import br.com.dreamteam.produtos.repository.ProductRepository;
import br.com.dreamteam.produtos.service.base.CrudServiceImpl;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends CrudServiceImpl<ProductRepository, Product, ProductDTO> {

    @Override
    protected List<ProductDTO> convertToListDto(List<Product> products) {
        return modelMapper.map(products, new TypeToken<List<ProductDTO>>() {}.getType());
    }

    @Override
    protected ProductDTO convertToDto(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    protected Product convertToModel(ProductDTO product) {
        return modelMapper.map(product, Product.class);
    }
}
