package com.famisanar.store.service;

import com.famisanar.store.entity.Product; // Importa tu entidad
import com.famisanar.store.repository.ProductRepository; // Importa tu repositorio
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl {

    // Esto es vital: sin esto, productRepository te dará error (cannot find symbol)
    @Autowired
    private ProductRepository productRepository;

    public String orderProduct(Long productId) {

        // Buscamos el producto en la base de datos
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Lógica de stock
        if (product.getStock() <= product.getMinimumStock()) {
            return "Pedido realizado al proveedor para el producto: " + product.getName();
        }

        return "El producto aún tiene stock suficiente";
    }
}