package com.example.LightGift.service;

import com.example.LightGift.entity.CategoryEntity;
import com.example.LightGift.entity.ProductEntity;
import com.example.LightGift.exception.NotFoundException;
import com.example.LightGift.model.Product;
import com.example.LightGift.repository.CategoryRepository;
import com.example.LightGift.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

     public void createProduct(ProductEntity product, Long id) throws NotFoundException {
         CategoryEntity category = categoryRepository.findById(id).orElse(null);
         if (category==null) {
             throw new NotFoundException("Категория не найдена");
         }
         product.setCategory(category);
         productRepository.save(product);
     }

    public Product getProduct(Long id) throws NotFoundException {
         ProductEntity product = productRepository.findById(id).orElse(null);
        if (product==null) {
            throw new NotFoundException("Продукт не найден");
        }
        return Product.toModel(product);
    }

    public void deleteProduct(Long id) {
         productRepository.deleteById(id);
    }
}
