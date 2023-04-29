package com.tailor.Shop.Services.Implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tailor.Shop.Entities.Category;
import com.tailor.Shop.Exceptions.ResourceNotFoundException;
import com.tailor.Shop.Mappings.CategoryMapping;
import com.tailor.Shop.Payload.CategoryDto;
import com.tailor.Shop.Repositories.CategoryRepository;
import com.tailor.Shop.Services.Interface.ICategoryService;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository _categoryRepository;

    @Autowired
    private CategoryMapping _categoryMapping;

    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        Category category = this._categoryMapping.dtoTCategory(categoryDto);
        Category savedCategory = this._categoryRepository.save(category);
        return this._categoryMapping.categoryToDto(savedCategory);
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto, Integer categoryId) {
        Category category = this._categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Category",
                        "Id",
                        categoryId + ""));
        categoryDto.setId(category.getId());
        category = this._categoryMapping.dtoTCategory(categoryDto);
        Category updatedCategory = this._categoryRepository.save(category);
        return this._categoryMapping.categoryToDto(updatedCategory);
    }

    @Override
    public void delete(Integer categoryId) {
        Category category = this._categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Category",
                        "Id",
                        categoryId + ""));
        this._categoryRepository.delete(category);
    }

    @Override
    public CategoryDto getById(Integer categoryId) {
        Category category = this._categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Category",
                        "Id",
                        categoryId + ""));
        return this._categoryMapping.categoryToDto(category);
    }

    @Override
    public List<CategoryDto> getAll() {
        return this._categoryRepository.findAll()
                .stream().map(
                        category -> this._categoryMapping.categoryToDto(category))
                .collect(Collectors.toList());
    }

}
