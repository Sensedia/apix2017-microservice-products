package com.sensedia.apix.notification;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by renanpetronilho on 24/05/17.
 */
@Entity
@Table(name = "T_NOTIFICATION")
@JsonIgnoreProperties
@ApiModel(description = "Modelo para criar notificações de intenção de compra.")
public class Notification {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	public String id;

	private String product;
	private String senderId;
	private String callback;

	public Notification() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}

	@Override
	public String toString() {
		return "Notification{" + "id='" + id + '\'' + ", product='" + product + '\'' + ", senderId='" + senderId + '\''
				+ ", callback='" + callback + '\'' + '}';
	}
}
