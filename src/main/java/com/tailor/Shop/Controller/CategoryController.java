package com.tailor.Shop.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tailor.Shop.Payload.CategoryDto;
import com.tailor.Shop.Services.Implementation.CategoryService;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService _categoryService;

    // CRUD
    @PostMapping
    public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto categoryDto) {
        CategoryDto savedCategory = this._categoryService.create(categoryDto);
        return new ResponseEntity<CategoryDto>(savedCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> update(@RequestBody CategoryDto categoryDto,
            @PathVariable Integer categoryId) {
        CategoryDto updatedCategory = this._categoryService.update(categoryDto, categoryId);
        return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<String> delete(@PathVariable Integer categoryId) {
        this._categoryService.delete(categoryId);
        return new ResponseEntity<String>("Category deleted successful of ID: " + categoryId,
                HttpStatus.OK);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getByID(@PathVariable Integer categoryId) {
        CategoryDto category = this._categoryService.getById(categoryId);
        return new ResponseEntity<CategoryDto>(category, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAll() {
        List<CategoryDto> categories = this._categoryService.getAll();
        return ResponseEntity.ok(categories);
    }
}
