package br.com.dreamteam.produtos.controller.base;

import br.com.dreamteam.produtos.service.base.CrudService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public abstract class BaseController<K extends CrudService, MODEL, DTO>{

    @Autowired
    protected K service;

    @Autowired
    protected ModelMapper modelMapper;

    @Autowired
    protected ObjectMapper objectMapper;

    @GetMapping("")
    public ResponseEntity getAllElements() {
        List<MODEL> models = (List<MODEL>) service.findAll();
        if (models != null && models.size() > 0) {
            return ResponseEntity.ok(convertToListDto(models));
        }
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping("/paginado")
    public ResponseEntity getAllElements(Pageable pageable) {
        Page<MODEL> page = (Page<MODEL>) service.findAll(pageable);
        if (page != null && page.getTotalElements() > 0) {
            return ResponseEntity
                    .ok(new PageImpl(convertToListDto(page.getContent()), pageable, page.getTotalElements()));
        }
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping("/{id}")
    public ResponseEntity getElementById(@PathVariable Long id) {
        MODEL model = (MODEL) service.findById(id);
        if (model != null) {
            return ResponseEntity.ok(convertToDto(model));
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity createElement(@RequestBody DTO dto) {
        MODEL model = convertToModel(dto);
        MODEL modelCreated = (MODEL) service.createElement(model);
        if (modelCreated != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(convertToDto(modelCreated));
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateElement(@PathVariable Long id, @RequestBody DTO dto) {
        MODEL model = convertToModel(dto);
        MODEL modelUpdate = (MODEL) service.updateElement(id, model);
        if (modelUpdate != null) {
            return ResponseEntity.status(HttpStatus.OK).body(convertToDto(model));
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteElement(@PathVariable Long id) {
        boolean success = service.deleteElement(id);
        if (success){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    protected abstract List convertToListDto(List<MODEL> models);

    protected abstract DTO convertToDto(MODEL model);

    protected abstract MODEL convertToModel(DTO dto);


}
