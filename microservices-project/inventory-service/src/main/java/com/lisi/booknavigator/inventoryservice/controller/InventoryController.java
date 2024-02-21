package com.lisi.booknavigator.inventoryservice.controller;

import com.lisi.booknavigator.inventoryservice.service.InventoryService;
import com.lisi.booknavigator.inventoryservice.dto.InventoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    // http://localhost:8082/api/inventory/iphone-13,iphone13-red

    // http://localhost:8082/api/inventory?skuCode=iphone-13&skuC ode=iphone13-red

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> IsInStock(@RequestParam List<String> skuCode){
        return inventoryService.isInStock(skuCode);
    }
}
