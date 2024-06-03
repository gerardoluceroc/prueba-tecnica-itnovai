package itnovai.api_spring_boot.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itnovai.api_spring_boot.entities.ProductEntity;
import itnovai.api_spring_boot.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Iterable<ProductEntity> getAllProducts(){

        return productRepository.findAll();
    }

    public Iterable<ProductEntity> getProductByCategory(int category){
        return productRepository.findByCategory(category);
    }
    
}
