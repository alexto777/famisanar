package com.famisanar.store.service;

import com.famisanar.store.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

// 1. Faltaba definir la clase
@Service
public class ProductServiceImpl {

    // 2. Necesitas el repositorio inyectado para que 'productRepository' funcione
    // (Asegúrate de tener esta interfaz creada en tu carpeta repository)
    @Autowired
    private ProductRepository productRepository;

    @Override
    public String orderProduct(Long productId) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        if (product.getStock() <= product.getMinimumStock()) {
            return "Pedido realizado al proveedor para el producto: " + product.getName();
        }

        return "El producto aún tiene stock suficiente";
    }
} // 3. Asegúrate de cerrar la llave de la clase al final