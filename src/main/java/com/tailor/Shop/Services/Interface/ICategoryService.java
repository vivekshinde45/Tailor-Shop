package com.tailor.Shop.Services.Interface;

import java.util.List;

import com.tailor.Shop.Payload.CategoryDto;

public interface ICategoryService {
    // CRUD
    CategoryDto create(CategoryDto categoryDto);

    CategoryDto update(CategoryDto categoryDto, Integer categoryId);

    void delete(Integer categoryId);

    CategoryDto getById(Integer categoryId);

    List<CategoryDto> getAll();
}
