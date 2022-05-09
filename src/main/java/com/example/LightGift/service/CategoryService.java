package com.example.LightGift.service;
import com.example.LightGift.entity.CategoryEntity;
import com.example.LightGift.exception.CategoryAlreadyExistException;
import com.example.LightGift.exception.NotFoundException;
import com.example.LightGift.model.Category;
import com.example.LightGift.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public void createCategory(CategoryEntity category) throws CategoryAlreadyExistException {
        if (categoryRepository.findByName(category.getName())!=null){
            throw new CategoryAlreadyExistException("Категория уже существует");
        }
        categoryRepository.save(category);
    }

    public Category getCategory(Long id) throws NotFoundException {
        CategoryEntity category = categoryRepository.findById(id).orElse(null);
        if (category==null) {
            throw new NotFoundException("Продукт не найден");
        }
        return Category.toModel(category);
    }

    public List<Category> getCategoriesAll() {
        return Streamable.of(categoryRepository.findAll()).toList().stream().map(Category::toModel).collect(Collectors.toList());
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
