package br.com.dreamteam.produtos.service;

import br.com.dreamteam.produtos.dto.KeywordDTO;
import br.com.dreamteam.produtos.model.Keyword;
import br.com.dreamteam.produtos.model.Product;
import br.com.dreamteam.produtos.repository.KeywordRepository;
import br.com.dreamteam.produtos.service.base.CrudServiceImpl;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KeywordService {

    @Autowired
    private KeywordRepository keywordRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Keyword> createElements(Product product, List<KeywordDTO> keywordsDTO) {
        List<Keyword> keywords = new ArrayList<>();

        keywordsDTO.forEach(keywordDTO -> {
            Keyword keyword = convertToModel(keywordDTO);
            keyword.setProduct(product);

            keywords.add(keyword);
        });

        return keywordRepository.saveAll(keywords);
    }

    public List<Keyword> updateElements(Product product, List<KeywordDTO> keywordsDTO) {
        keywordRepository.deleteByProductId(product.getId());
        return createElements(product, keywordsDTO);
    }

    public List<Long> findKeywordsIds(String description) {
        List<Keyword> keywords = findByDescription(description);

        List<Long> keywordsIds = keywords.stream()
                .map(Keyword::getId).collect(Collectors.toList());

        return keywordsIds;
    }

    public List<Keyword> findByDescription(String description) {
        return keywordRepository.findByDescriptionContainingIgnoreCase(description);
    }

    private Keyword convertToModel(KeywordDTO keyword) {
        return modelMapper.map(keyword, Keyword.class);
    }

}
