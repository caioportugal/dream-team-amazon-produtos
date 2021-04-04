package br.com.dreamteam.produtos.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.util.ObjectUtils;

import javax.persistence.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "keyword")
public class Keyword {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToOne
    private Product product;

    @Override
    public String toString() {
        return !ObjectUtils.isEmpty(description) ? description : "";
    }
}
