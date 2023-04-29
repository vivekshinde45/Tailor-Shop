package com.tailor.Shop.Mappings;

import org.springframework.stereotype.Component;

import com.tailor.Shop.Entities.Category;
import com.tailor.Shop.Payload.CategoryDto;

@Component
public class CategoryMapping {
    public Category dtoTCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        return category;
    }

    public CategoryDto categoryToDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setDescription(category.getDescription());
        return categoryDto;
    }
}
