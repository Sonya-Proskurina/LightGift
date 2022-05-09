package com.example.LightGift.controller;

import com.example.LightGift.entity.CategoryEntity;
import com.example.LightGift.exception.NotFoundException;
import com.example.LightGift.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity getCategory(@RequestParam Long id) {
        try {
            return ResponseEntity.ok().body(categoryService.getCategory(id));
        }
        catch (NotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllCategories() {
        try {
            return ResponseEntity.ok().body(categoryService.getCategoriesAll());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping
    public ResponseEntity createCategory(@RequestBody CategoryEntity category) {
        try {
            categoryService.createCategory(category);
            return ResponseEntity.ok("Категория успешно создана");
        }  catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable Long id) {
        try {
            categoryService.deleteCategory(id);
            return ResponseEntity.ok("Категория успешно удалена");
        }  catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
