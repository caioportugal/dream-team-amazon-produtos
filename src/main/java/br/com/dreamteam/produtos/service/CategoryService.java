package br.com.dreamteam.produtos.service;

import br.com.dreamteam.produtos.dto.CategoryDTO;
import br.com.dreamteam.produtos.model.Category;
import br.com.dreamteam.produtos.repository.CategoryRepository;
import br.com.dreamteam.produtos.service.base.CrudServiceImpl;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService extends CrudServiceImpl<CategoryRepository, Category, CategoryDTO> {

    @Override
    protected List<CategoryDTO> convertToListDto(List<Category> categories) {
        return modelMapper.map(categories, new TypeToken<List<CategoryDTO>>() {}.getType());
    }

    @Override
    protected CategoryDTO convertToDto(Category category) {
        return modelMapper.map(category, CategoryDTO.class);
    }

    @Override
    protected Category convertToModel(CategoryDTO category) {
        return modelMapper.map(category, Category.class);
    }
}
