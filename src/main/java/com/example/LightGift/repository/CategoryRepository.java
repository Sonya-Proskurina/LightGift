package com.example.LightGift.repository;

import com.example.LightGift.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {
        CategoryEntity findByName(String name);
}
