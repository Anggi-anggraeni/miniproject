package com.miniProject.RTFEngine.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniProject.RTFEngine.DAO.PersonalizeDao;
import com.miniProject.RTFEngine.Enitity.Personalize;



@RestController
public class PersonalizeController
{
	@Autowired
	private PersonalizeDao personalizeDao;
	
	@GetMapping("personalize/findAll")
	public List<Personalize> getAll() {

		return personalizeDao.findAll();

	}
	
}
