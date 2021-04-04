package br.com.dreamteam.produtos.repository;

import br.com.dreamteam.produtos.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoryIdOrderByViewsDesc(Long categoryId);

    List<Product> findBySubcategoryId(Long subcategoryId);

    List<Product> findByKeywordsIdIn(List<Long> keywordsIds);

    @Query(value = "SELECT views FROM product p WHERE p.id = ?1", nativeQuery = true)
    Long findViewsById(Long id);
}
