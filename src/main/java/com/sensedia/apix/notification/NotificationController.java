package com.sensedia.apix.notification;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sensedia.apix.product.Product;

import io.swagger.annotations.ApiOperation;

/**
 * Created by renanpetronilho on 24/05/17.
 */
@Api(value = "/notifications", description = "Recurso responsável por gerenciar operações relacionadas as notificações")
@RestController
public class NotificationController {

	@Autowired
	private INotificationRepository repository;

	@ApiOperation(value = "Insere uma nova notificação.", code = 201, response = Notification.class)
	@RequestMapping(value = "/notifications", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> postNotification(@RequestBody Notification notification) {
		repository.save(notification);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "Página de resultado que deseja recuperar (0..N)"),
			@ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "Número de registro por página."), })
	@ApiOperation(value = "Retorna uma lista notificações.", response = Notification.class, responseContainer = "List")
	@RequestMapping(value = "/notifications", method = RequestMethod.GET)
	public ResponseEntity<List<Notification>> getNotification(Pageable pageable) {
		List<Notification> result = repository.findAll(pageable).getContent();
		if (result.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
		}
	}
}
