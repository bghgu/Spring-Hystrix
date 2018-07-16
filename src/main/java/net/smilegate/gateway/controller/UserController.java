package net.smilegate.gateway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.smilegate.gateway.model.USER;
import net.smilegate.gateway.service.impl.*;

@Slf4j
@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	//private UserServiceImpl userService;
	private HystrixUserServiceImpl userService;
	
	@GetMapping("")
	public List<USER> getUsers() {
		return userService.findAll();
	}
	
	@GetMapping("/{user_idx}")
	public USER getUsersByUserIdx(@PathVariable final int user_idx) {
		return userService.findOne(user_idx);
	}
	
	@PostMapping("")
	public ResponseEntity postUser(@RequestBody final USER userReq) {
		userService.save(userReq);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@PutMapping("/{user_idx}")
	public ResponseEntity updateUserByUserIdx(@PathVariable final int user_idx, @RequestBody final USER userReq) {
		userService.update(user_idx, userReq);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{user_idx}")
	public ResponseEntity deleteUserByUserIdx(@PathVariable final int user_idx) {
		userService.delete(user_idx);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

}
