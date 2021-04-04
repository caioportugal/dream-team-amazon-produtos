package br.com.dreamteam.produtos.repository;

import br.com.dreamteam.produtos.model.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeywordRepository extends JpaRepository<Keyword, Long> {

    List<Keyword> findByDescriptionContainingIgnoreCase(String description);

    void deleteByProductId(Long productId);
}
