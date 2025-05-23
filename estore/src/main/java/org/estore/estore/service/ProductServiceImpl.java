package org.estore.estore.service;

import lombok.AllArgsConstructor;
import org.estore.estore.exception.ProductNotFoundException;
import org.estore.estore.model.Product;
import org.estore.estore.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    @Override
    public Product getProductBy(String id) {
        return productRepository.findById(id)
                .orElseThrow(()->new ProductNotFoundException("product not found"));
    }
}
