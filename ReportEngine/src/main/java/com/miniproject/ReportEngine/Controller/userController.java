package com.miniproject.ReportEngine.Controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.ReportEngine.Repo.RepoUser;

@RestController
@RequestMapping("admin")
public class userController 
{
	@Autowired
	RepoUser repoUser;
	
	@RequestMapping("")
	public HashMap<String, Object> admin() {

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("message", "masuk sebagai admin");

		return map;

	}	
	
	@RequestMapping("user")

	public HashMap<String, Object> user() {

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("message", "masuk sebagai user");

		return map;

	}
	
}
