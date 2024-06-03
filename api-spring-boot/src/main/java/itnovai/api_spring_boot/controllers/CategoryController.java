package itnovai.api_spring_boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import itnovai.api_spring_boot.entities.CategoryEntity;
import itnovai.api_spring_boot.services.CategoryService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/category")
public class CategoryController {
    
    @Autowired
    CategoryService categoryService;

    @GetMapping("/all")
    public Iterable<CategoryEntity> getAllCategories(){

        return categoryService.getAllCategories();

    }
}
