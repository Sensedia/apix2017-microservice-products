package com.sensedia.apix.notification;

import java.io.Serializable;

/**
 * Created by renanpetronilho on 24/05/17.
 */
public class NotificationCallback implements Serializable{

	private String senderId;
	private String product;

	public NotificationCallback(String senderId, String product) {
		this.senderId = senderId;
		this.product = product;
	}

	public NotificationCallback() {
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "NotificationCallback{" + "senderId='" + senderId + '\'' + ", product='" + product + '\'' + '}';
	}
}
