package com.api.inventario.infrastructure.adapter.rest.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface ReportsApi {
    @PostMapping("/generateReport")
    void generateReport(@RequestParam String fileType);
}
