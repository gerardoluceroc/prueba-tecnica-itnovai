package itnovai.api_spring_boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getAllCategories() {

        //En caso de no existir un error, se envía la categoría junto con un mensaje del tipo 200
        try {
            Iterable<CategoryEntity> categories = categoryService.getAllCategories();
            return ResponseEntity.ok(categories);

            //En caso de existir un error, se envía la respuesta al cliente
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener las categorías: " + e.getMessage());
        }
    }
}
