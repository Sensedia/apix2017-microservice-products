package com.sensedia.apix.notification;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sensedia.apix.product.IProductRepository;
import com.sensedia.apix.product.Product;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by renanpetronilho on 24/05/17.
 */
@Service
public class NotificationService implements INotificationService {

	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

	@Autowired
	private INotificationRepository notificationRepository;

	@Autowired
	private IProductRepository productRepository;

	@Autowired
	private OkHttpClient clientHttp;

	@Autowired
	private ObjectMapper mapper;

	@Override
	public void checkProduct() {
		List<Notification> notifications = notificationRepository.findAll();
		notifications.forEach(notification -> {
			List<Product> products = productRepository.findProductsByNameLike(notification.getProduct());
			if (!products.isEmpty()) {
				callbackSender(notification, products.get(0));
			}
		});
	}

	@Override
	public void callbackSender(Notification notification, Product product) {
		try {
			NotificationCallback callback = new NotificationCallback(notification.getSenderId(), product.getId());
			String json = mapper.writeValueAsString(callback);
			System.out.println(json);
			RequestBody body = RequestBody.create(JSON, json);
			Request request = new Request.Builder().url(notification.getCallback()).post(body).build();
			Response response = clientHttp.newCall(request).execute();
			if (response.isSuccessful()) {
				notificationRepository.delete(notification.getId());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
