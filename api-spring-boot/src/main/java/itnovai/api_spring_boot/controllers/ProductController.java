package itnovai.api_spring_boot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import itnovai.api_spring_boot.entities.CategoryEntity;
import itnovai.api_spring_boot.entities.ProductEntity;
import itnovai.api_spring_boot.services.CategoryService;
import itnovai.api_spring_boot.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    //Obtener todos los productos
    @GetMapping("/all")
    public Iterable<ProductEntity> getAllProducts(){
        return productService.getAllProducts();
    }

    //Filtrar productos por categoría
    @GetMapping("/category/{id_category}")
    public Iterable<ProductEntity> getProductByCategory(@PathVariable Long id_category){

        CategoryEntity category = categoryService.getCategoryById(id_category).get();


        return productService.getProductByCategory(category);
    }
    
}
