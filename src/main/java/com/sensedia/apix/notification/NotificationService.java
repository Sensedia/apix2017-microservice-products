package com.sensedia.apix.notification;

import com.sensedia.apix.product.IProductRepository;
import com.sensedia.apix.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by renanpetronilho on 24/05/17.
 */
@Service
public class NotificationService implements INotificationService {

	@Autowired
	private INotificationRepository notificationRepository;

	@Autowired
	private IProductRepository productRepository;

	@Override
	public void checkProduct() {
		List<Notification> notifications = notificationRepository.findAll();
		notifications.forEach(notification -> {
			List<Product> products = productRepository.findProductsByNameLike(notification.getProduct());
			if(!products.isEmpty()){
				callbackSender(notification, products.get(0));
			}
		});
	}

	@Override
	public void callbackSender(Notification notification, Product product) {
		System.out.println(notification);
		System.out.println(product);
	}
}
