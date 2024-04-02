package com.productscatalogue.productservice.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.productscatalogue.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
