package com.sensedia.apix.notification;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by renanpetronilho on 24/05/17.
 */
public interface INotificationRepository extends JpaRepository<Notification, String> {
}
