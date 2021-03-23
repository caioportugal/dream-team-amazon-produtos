package br.com.dreamteam.produtos.service.base;

import br.com.dreamteam.produtos.dto.base.BaseDTO;
import br.com.dreamteam.produtos.exception.BusinessException;
import br.com.dreamteam.produtos.exception.ResourceNotFoundException;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public abstract class CrudServiceImpl<L extends JpaRepository, MODEL, DTO extends BaseDTO> implements CrudService<DTO> {

    @Autowired
    protected L repository;

    @Autowired
    protected ModelMapper modelMapper;

    @Override
    public List<DTO> findAll() {
        List<MODEL> models = (List<MODEL>)repository.findAll();
        return convertToListDto(models);
    }

    @Override
    public Page<DTO> findAll(Pageable pageable) {
        Page<MODEL> page = (Page<MODEL>) repository.findAll(pageable);
        return page.map(m -> convertToDto(m));
    }

    @Override
    @Transactional(readOnly = true)
    @SneakyThrows
    public DTO findById(Long id) {
        Optional optionalModel = repository.findById(id);
        MODEL model = (MODEL) optionalModel.orElseThrow(() -> new ResourceNotFoundException("Resource not found for id" + id));
        return convertToDto(model);
    }

    @Override
    @Transactional
    public DTO createElement(DTO dto) {
        MODEL model = convertToModel(dto);
        model = (MODEL) repository.save(model);
        return convertToDto(model);
    }

    @Override
    @Transactional
    public DTO updateElement(Long id, DTO dto) {
        if (repository.existsById(id)) {
            dto.setId(id);
            MODEL model = (MODEL) repository.getOne(id);
            model = convertToModel(dto);
            model = (MODEL) repository.save(model);

            return convertToDto(model);
        } else {
            throw new ResourceNotFoundException("Resource not found for id: " + id);
        }
    }

    @Override
    public void deleteElement(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Resource not found for id: " + id);
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException("Data integrity violation");
        }
    }

    protected abstract List<DTO> convertToListDto(List<MODEL> models);

    protected abstract DTO convertToDto(MODEL model);

    protected abstract MODEL convertToModel(DTO dto);
}
