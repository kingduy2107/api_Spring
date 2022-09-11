package com.example.final_spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.final_spring.entity.User;
import com.example.final_spring.service.UserService;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/user")
public class UserController {
	// Le Quang Dao
	@Autowired UserService userService;
	
	@GetMapping("")
	public ResponseEntity<?> getAllUser() {
		return new ResponseEntity<List<User>>(userService.getAllUser(), HttpStatus.OK);
	}
	@PostMapping("")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable("id") int id) {
		try {
			userService.deleteUserById(id);
			return new ResponseEntity<String>("", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>("", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUserById(@PathVariable("id") int id, @RequestBody User user) {
		Optional<User> optional = userService.findUserById(id);
		if(optional.isPresent()) {
			User _user = optional.get();
			_user.setFullname(user.getFullname());
			_user.setEmail(user.getEmail());
			_user.setPassword(user.getPassword());
			_user.setAddress(user.getAddress());
			_user.setPhone(user.getPhone());
			return new ResponseEntity<User>(userService.createUser(_user), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
}
