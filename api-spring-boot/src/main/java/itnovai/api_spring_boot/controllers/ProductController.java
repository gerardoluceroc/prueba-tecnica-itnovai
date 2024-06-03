package itnovai.api_spring_boot.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    // Obtener todos los productos
    @GetMapping("/all")
    public ResponseEntity<?> getAllProducts() {
        try {
            Iterable<ProductEntity> products = productService.getAllProducts();
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener los productos: " + e.getMessage());
        }
    }

    // Filtrar productos por categoría
    @GetMapping("/category/{id_category}")
    public ResponseEntity<?> getProductByCategory(@PathVariable Long id_category) {
        try {
            Optional<CategoryEntity> optionalCategory = categoryService.getCategoryById(id_category);

            //Si se encuentra el producto, se envía como respuesta junto a un mensaje del tipo 200
            if (optionalCategory.isPresent()) {
                CategoryEntity category = optionalCategory.get();
                Iterable<ProductEntity> products = productService.getProductByCategory(category);
                return ResponseEntity.ok(products);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoría no encontrada");
            }
            //En caso de no encontrarse, se envía la respuesta al cliente
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener productos por categoría: " + e.getMessage());
        }
    }

    // Filtrar productos por nombre
    @GetMapping("/name/{name_product}")
    public ResponseEntity<?> getProductByName(@PathVariable String name_product) {

        //Si se no existe errores en la ejecución, se envía como respuesta el producto junto a un mensaje del tipo 200
        try {
            Iterable<ProductEntity> products = productService.getProductByName(name_product);
            return ResponseEntity.ok(products);

        //En caso de existir un error, se envía la respuesta al cliente
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener productos por nombre: " + e.getMessage());
        }
    }
}
