package com.sensedia.apix.product;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * Created by renanpetronilho on 24/05/17.
 */
@ApiModel(description = "Modelo da imagem de produtos.")
public class ProductImage implements Serializable {

	private String data;

	public ProductImage() {
	}

	public ProductImage(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
