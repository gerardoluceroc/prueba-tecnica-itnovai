package itnovai.api_spring_boot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import itnovai.api_spring_boot.entities.CategoryEntity;
import itnovai.api_spring_boot.entities.ProductEntity;
import itnovai.api_spring_boot.services.CategoryService;
import itnovai.api_spring_boot.services.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    //Obtener todos los productos
    @GetMapping("/all")
    public ResponseEntity<Iterable<ProductEntity>> getAllProducts(){

        Iterable<ProductEntity> products = productService.getAllProducts();

        // Retorna los productos y el código de estado 200 OK
        return ResponseEntity.ok(products);
    }

    //Filtrar productos por categoría
    @GetMapping("/category/{id_category}")
    public ResponseEntity<Iterable<ProductEntity>> getProductByCategory(@PathVariable Long id_category){

        //Se obtiene la entidad categoría con una id especifica
        CategoryEntity category = categoryService.getCategoryById(id_category).get();

        //Se buscan los productos con la categoría de entrada
        Iterable<ProductEntity> products = productService.getProductByCategory(category);

        // Retorna los productos y el código de estado 200 OK
        return ResponseEntity.ok(products);
    }

    @GetMapping("/name/{name_product}")
    public ResponseEntity<Iterable<ProductEntity>> getProductByName(@PathVariable String name_product) {

        // Llama al método ProductService para buscar productos por nombre
        Iterable<ProductEntity> products = productService.getProductByName(name_product);

        // Retorna los productos y el código de estado 200 OK
        return ResponseEntity.ok(products);
    }
    
    
}
