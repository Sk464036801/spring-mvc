package com.app.mvn.example.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mvn.example.core.dao.impl.UserDAO;
import com.app.mvn.example.core.model.User;
import com.app.mvn.example.core.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private UserDAO userDao;

	public void saveUser(User user) {
		
		userDao.saveUser(user);
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	public void deleteUser(String id) {
		userDao.deleteUser(id);
	}

	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Autowired
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	

}
