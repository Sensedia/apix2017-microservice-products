package com.sensedia.apix.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by renanpetronilho on 23/04/17.
 */
@RestController
public class ProductController{

    @Autowired
    private IProductRepository repository;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getAll(Pageable pageable){
        List<Product> products = repository.findAll(pageable).getContent();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @RequestMapping(value = "/categories/{categoryId}/products", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getAll(@PathVariable("categoryId") String id){
        List<Product> products = repository.findProductsByCategoryId(id);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
