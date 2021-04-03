package br.com.dreamteam.produtos.service;

import br.com.dreamteam.produtos.dto.SubcategoryDTO;
import br.com.dreamteam.produtos.model.Subcategory;
import br.com.dreamteam.produtos.repository.SubcategoryRepository;
import br.com.dreamteam.produtos.service.base.CrudServiceImpl;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubcategoryService extends CrudServiceImpl<SubcategoryRepository, Subcategory, SubcategoryDTO> {

    @Override
    protected List<SubcategoryDTO> convertToListDto(List<Subcategory> subcategories) {
        return modelMapper.map(subcategories, new TypeToken<List<SubcategoryDTO>>() {}.getType());
    }

    @Override
    protected SubcategoryDTO convertToDto(Subcategory subcategory) {
        return modelMapper.map(subcategory, SubcategoryDTO.class);
    }

    @Override
    protected Subcategory convertToModel(SubcategoryDTO subcategory) {
        return modelMapper.map(subcategory, Subcategory.class);
    }
}
