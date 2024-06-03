package itnovai.api_spring_boot.repositories;

import org.springframework.data.repository.CrudRepository;

import itnovai.api_spring_boot.entities.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

    Iterable<ProductEntity> findByCategory(int category);
    
}
