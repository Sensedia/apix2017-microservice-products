package com.sensedia.apix.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by renanpetronilho on 23/04/17.
 */
public interface IProductRepository extends JpaRepository<Product, String> {

	@Query("SELECT p FROM Product p where LOWER(p.name)  LIKE LOWER(CONCAT('%',:name,'%'))")
	List<Product> findProductsByNameLike(@Param("name")String name);
}

