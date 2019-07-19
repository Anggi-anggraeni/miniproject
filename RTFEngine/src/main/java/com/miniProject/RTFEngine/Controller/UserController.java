package com.miniProject.RTFEngine.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniProject.RTFEngine.DAO.UserDao;
import com.miniProject.RTFEngine.Enitity.User;

@RestController
public class UserController 
{
	@Autowired
	private UserDao userDao;
	
	@GetMapping("user/findAll")
	public List<User> getAll() {

		return userDao.findAll();

	}
}
