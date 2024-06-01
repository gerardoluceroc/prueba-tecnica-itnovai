package itnovai.api_spring_boot.services;

import java.util.ArrayList;

import org.hibernate.mapping.List;
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
    
}
