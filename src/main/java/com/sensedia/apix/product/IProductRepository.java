package com.sensedia.apix.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by renanpetronilho on 23/04/17.
 */
public interface IProductRepository extends JpaRepository<Product, String> {

	@Query("SELECT p FROM Product p where LOWER(p.name)  LIKE LOWER(CONCAT('%',:name,'%')) order by p.value")
	List<Product> findProductsByNameLike(@Param("name") String name);

	@Query("SELECT p FROM Product p where LOWER(p.name)  LIKE LOWER(CONCAT('%',:name,'%'))  and p.value <= :price order by p.value")
	List<Product> findProductsByNameLikeAndPrice(@Param("name") String name, @Param("price") BigDecimal price);
}
