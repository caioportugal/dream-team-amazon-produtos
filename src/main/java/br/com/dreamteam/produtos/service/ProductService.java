package br.com.dreamteam.produtos.service;

import br.com.dreamteam.produtos.model.Product;
import br.com.dreamteam.produtos.repository.ProductRepository;
import br.com.dreamteam.produtos.service.base.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends CrudServiceImpl<ProductRepository, Product> {
}
