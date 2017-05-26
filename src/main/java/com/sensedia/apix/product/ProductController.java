package com.sensedia.apix.product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * Created by renanpetronilho on 23/04/17.
 */
@Api(value = "/products", description = "Recurso responsavel por gerenciar operações relacionadas ao produto")
@RestController
public class ProductController {

	@Autowired
	private IProductRepository repository;

	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "Página de resultado que deseja recuperar (0..N)"),
			@ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "Número de registro por página."), })
	@ApiOperation(value = "Retorna uma lista de produtos.", response = Product.class, responseContainer = "List")
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Product>> getAll(
			@ApiParam(value = "Nome do produto.") @RequestParam(value = "name", required = false) String name,
			@ApiParam(value = "Preço aproximado do produto.") @RequestParam(value = "price", required = false) BigDecimal price,
			Pageable pageable) {
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

	@ApiOperation(value = "Retorna um produto de acordo com ID informado.", response = Product.class)
	@RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
	public ResponseEntity<Product> getById(@PathVariable("productId") String id) {
		Product product = repository.findOne(id);
		if (Objects.isNull(product)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@ApiOperation(value = "Retorna a imagem do produto em base64, de acordo com ID informado.", response = ProductImage.class)
	@RequestMapping(value = "/products/{productId}/images", method = RequestMethod.GET)
	public ResponseEntity<ProductImage> getImage(@PathVariable("productId") String id) {
		Product product = repository.findOne(id);
		if (Objects.isNull(product)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new ProductImage(product.getImage()), HttpStatus.OK);
	}

	@ApiOperation(value = "Insere um novo produto.", code = 201, response = Product.class)
	@RequestMapping(value = "/products", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> postProduct(@RequestBody Product product) {
		repository.save(product);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
