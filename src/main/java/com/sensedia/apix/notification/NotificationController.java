package com.sensedia.apix.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by renanpetronilho on 24/05/17.
 */
@RestController
public class NotificationController {

	@Autowired
	private INotificationRepository repository;

	@RequestMapping(value = "/notifications", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> postNotification(@RequestBody Notification notification){
		repository.save(notification);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/notifications",method = RequestMethod.GET)
	public ResponseEntity<List<Notification>> getNotification(){
		List<Notification> result = repository.findAll();
		if (result.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
		}
	}
}
