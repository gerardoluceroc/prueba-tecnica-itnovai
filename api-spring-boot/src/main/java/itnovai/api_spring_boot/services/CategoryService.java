package itnovai.api_spring_boot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itnovai.api_spring_boot.entities.CategoryEntity;
import itnovai.api_spring_boot.repositories.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Iterable<CategoryEntity> getAllCategories(){

        return categoryRepository.findAll();
    }

    public Optional<CategoryEntity> getCategoryById(Long id){
        return categoryRepository.findById(id);
    }
    
}
