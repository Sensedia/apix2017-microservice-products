package com.sensedia.apix.notification;

import com.sensedia.apix.product.Product;

/**
 * Created by renanpetronilho on 24/05/17.
 */
public interface INotificationService {

	void checkProduct();
	void callbackSender(Notification notification, Product product);
}
