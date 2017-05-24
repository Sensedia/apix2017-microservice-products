package com.sensedia.apix.product;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by renanpetronilho on 23/04/17.
 */
@Entity
@Table(name = "T_PRODUCT")
public class Product implements Serializable {

	@Id
	private String id;
	private String name;
	private String department;
	private String category;
	private String subCategory;
	private BigDecimal value;
	private String installment;
	private Integer loyalty;
	private Integer installmentNumber;
	private BigDecimal installmentValue;
	private Boolean available;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Lob
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getInstallment() {
		return installment;
	}

	public void setInstallment(String installment) {
		this.installment = installment;
	}

	public Integer getLoyalty() {
		return loyalty;
	}

	public void setLoyalty(Integer loyalty) {
		this.loyalty = loyalty;
	}

	public Integer getInstallmentNumber() {
		return installmentNumber;
	}

	public void setInstallmentNumber(Integer installmentNumber) {
		this.installmentNumber = installmentNumber;
	}

	public BigDecimal getInstallmentValue() {
		return installmentValue;
	}

	public void setInstallmentValue(BigDecimal installmentValue) {
		this.installmentValue = installmentValue;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Product{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", department='" + department + '\''
				+ ", category='" + category + '\'' + ", subCategory='" + subCategory + '\'' + ", value=" + value
				+ ", installment='" + installment + '\'' + ", loyalty=" + loyalty + ", installmentNumber="
				+ installmentNumber + ", installmentValue=" + installmentValue + ", available=" + available + '}';
	}
}
