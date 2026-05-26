package com.famisanar.store.controller;

import com.famisanar.store.dto.SellRequest;
import com.famisanar.store.dto.StatisticsResponse;
import com.famisanar.store.entity.Product;
import com.famisanar.store.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @PostMapping("/{id}/sell")
    public void sellProduct(@PathVariable Long id,
                            @RequestBody SellRequest request) {

        productService.sellProduct(id, request.getQuantity());
    }

    @PostMapping("/{id}/order")
    public String orderProduct(@PathVariable Long id) {
        return productService.orderProduct(id);
    }

    @GetMapping("/statistics")
    public StatisticsResponse getStatistics() {
        return productService.getStatistics();
    }
}