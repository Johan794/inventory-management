package com.api.inventario.infrastructure.adapter.rest.api;


import com.api.inventario.infrastructure.dto.inputDto.AreaInputDto;
import com.api.inventario.infrastructure.dto.outputDto.AreaOutDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Generic value: I : input dto O: OutPutDto
 */


public interface CrudApi<I,O> {
    @PostMapping("/create")
    O create(I dto);

    @PutMapping("/update")
    O update(I dto);

    @DeleteMapping("/delete/{id}")
    O delete(@PathVariable String id);

    @GetMapping("/getById/{id}")
    O getById(@PathVariable String id);

    @GetMapping("/getAll")
    List<O> getAll();
}
