package com.sensedia.apix.product;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by renanpetronilho on 23/04/17.
 */
public interface IProductRepository extends MongoRepository<Product, String> {

    List<Product> findProductsByCategoryId(String categoryId);
}

