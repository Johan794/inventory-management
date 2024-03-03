package com.api.inventario.infrastructure.adapter.rest.api;


import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Generic value: I : input dto O: OutPutDto
 */


public interface CrudApi<I,O> {
    @PostMapping("/create")
    O create(@RequestBody I dto);

    @PutMapping("/update")
    O update(@RequestBody I dto);

    @DeleteMapping("/delete/{id}")
    O delete(@PathVariable String id);

    @GetMapping("/getById/{id}")
    O getById(@PathVariable String id);

    @GetMapping("/getAll")
    List<O> getAll();
}
