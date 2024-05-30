package com.example.FirstApp.api.category;

import com.example.FirstApp.api.category.dto.CategoryDtoAdauga;
import com.example.FirstApp.domain.category.Category;
import com.example.FirstApp.domain.category.CategoryRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping("/adauga")
    Category adauga(@RequestBody CategoryDtoAdauga commandDto) {

        Category categoryToBeSaved = new Category();

        categoryToBeSaved.setName(commandDto.getName());

        return categoryRepository.save(categoryToBeSaved);

    }

}
