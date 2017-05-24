package com.sensedia.apix.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * Created by renanpetronilho on 23/04/17.
 */
@RestController
public class ProductController {

	@Autowired
	private IProductRepository repository;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Product>> getAll(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "price", required = false) BigDecimal price, Pageable pageable) {
		List<Product> products;
		if (Objects.nonNull(name) && Objects.nonNull(price)) {
			products = repository.findProductsByNameLikeAndPrice(name, price);
		} else if (Objects.nonNull(name)) {
			products = repository.findProductsByNameLike(name);
		} else {
			products = repository.findAll(pageable).getContent();
		}
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
	public ResponseEntity<Product> getById(@PathVariable("productId") String id) {
		Product product = repository.findOne(id);
		if (Objects.isNull(product)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@RequestMapping(value = "/products/{productId}/images", method = RequestMethod.GET)
	public ResponseEntity<ProductImage> getImage(@PathVariable("productId") String id) {
		Product product = repository.findOne(id);
		if (Objects.isNull(product)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new ProductImage(product.getImage()), HttpStatus.OK);
	}


	@RequestMapping(value = "/products", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> postProduct(@RequestBody Product product){
		repository.save(product);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
