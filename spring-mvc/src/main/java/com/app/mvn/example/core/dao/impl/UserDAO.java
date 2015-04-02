package com.app.mvn.example.core.dao.impl;

import java.util.List;

import com.app.mvn.example.core.model.User;

public interface UserDAO {
	
	public void saveUser(User user);
	public void updateUser(User user);
	public void deleteUser(String id);
	public List<User> getAllUser();

}
