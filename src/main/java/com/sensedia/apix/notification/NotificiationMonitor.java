package com.sensedia.apix.notification;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by renanpetronilho on 24/05/17.
 */
@Aspect
@Component
public class NotificiationMonitor {

	@Autowired
	private INotificationService notificationService;

	@AfterReturning("execution(* com.sensedia.apix.product.ProductController.postProduct(..))")
	public void logServiceAccess(JoinPoint joinPoint) {
		System.out.println("Completed: " + joinPoint);
		new Thread(() -> notificationService.checkProduct()).start();
	}
}
