package com.example.LightGift.controller;

import com.example.LightGift.entity.ProductEntity;
import com.example.LightGift.exception.NotFoundException;
import com.example.LightGift.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//alias mysql=/usr/local/mysql/bin/mysql
//mysql -u root -p
//use lightgift;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ResponseEntity getProduct(@RequestParam Long id) {
        try {
            return ResponseEntity.ok().body(productService.getProduct(id));
        }
        catch (NotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody ProductEntity product,@RequestParam Long id) {
        try {
            productService.createProduct(product, id);
            return ResponseEntity.ok("Продукт успешно создан ");
        }  catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) {
        try {
            productService.deleteProduct(id);
            return ResponseEntity.ok("Продукт успешно удален");
        }  catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
