package com.example.final_spring.service;

import java.util.List;
import java.util.Optional;

import com.example.final_spring.entity.User;

public interface UserServiceImp {
	public List<User> getAllUser();
	public User createUser(User user);
	public void deleteUserById(int id);
	public Optional<User> findUserById(int id);
}
