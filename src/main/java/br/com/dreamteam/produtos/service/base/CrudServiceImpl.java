package br.com.dreamteam.produtos.service.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class CrudServiceImpl<L extends JpaRepository, MODEL> implements CrudService<MODEL> {

    @Autowired
    protected L repository;

    @Override
    public List<MODEL> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<MODEL> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public MODEL findById(Long id) {
        Optional<MODEL> optional = repository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public MODEL createElement(MODEL model) {
        return (MODEL) repository.save(model);
    }

    @Override
    public List<MODEL> createElements(List<MODEL> model) {
        return (List<MODEL>) repository.saveAll(model);
    }

    @Override
    public MODEL updateElement(Long id, MODEL model) {
        Optional<MODEL> t = (Optional) repository.findById(id);
        if (t.isPresent()){
            return (MODEL) repository.save(model);
        }
        return null;
    }

    @Override
    public boolean deleteElement(Long id) {
        boolean exists = repository.existsById(id);
        if (exists) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
