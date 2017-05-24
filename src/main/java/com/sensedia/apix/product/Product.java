package com.sensedia.apix.product;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by renanpetronilho on 23/04/17.
 */

@Document(collection = "DOC_PRODUCT")
public class Product implements Serializable {

	@Id
	private String id;
	private String name;
	private String department;
	private String category;
	private String subCategory;
	private Price price;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String image;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Product{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", department='" + department + '\''
				+ ", category='" + category + '\'' + ", subCategory='" + subCategory + '\'' + ", price=" + price + '}';
	}
}
