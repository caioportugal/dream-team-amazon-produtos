package br.com.dreamteam.produtos.controller.base;

import br.com.dreamteam.produtos.service.base.CrudService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public abstract class BaseController<K extends CrudService, DTO>{

    @Autowired
    protected K service;

    @Autowired
    protected ObjectMapper objectMapper;

    @GetMapping
    public ResponseEntity findAll() {
        List<DTO> dtos = (List<DTO>) service.findAll();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/paginado")
    public ResponseEntity findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                  @RequestParam(value = "itemsPerPage", defaultValue = "12") Integer itemsPerPage,
                                  @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
                                  @RequestParam(value = "direction", defaultValue = "DESC") Sort.Direction direction) {
        PageRequest pageRequest = PageRequest.of(page, itemsPerPage, direction,  orderBy);
        Page<DTO> pageDto = service.findAll(pageRequest);
        return ResponseEntity.ok(pageDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        DTO dto = (DTO)service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity createElement(@RequestBody DTO dto) {
        dto= (DTO) service.createElement(dto);
        URI uri = getURILocation(dto);
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateElement(@PathVariable Long id, @RequestBody DTO dto) {
        dto = (DTO) service.updateElement(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteElement(@PathVariable Long id) {
        service.deleteElement(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    protected abstract URI getURILocation(DTO dto);
}
