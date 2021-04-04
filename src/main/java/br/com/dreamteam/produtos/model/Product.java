package br.com.dreamteam.produtos.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "product")
public class Product {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double value;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Subcategory subcategory;


    @OneToMany(mappedBy = "product")
    private List<Keyword> keywords;

    private Long views;
}
