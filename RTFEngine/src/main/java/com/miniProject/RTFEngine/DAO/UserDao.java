package com.miniProject.RTFEngine.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniProject.RTFEngine.Enitity.User;

public interface UserDao extends JpaRepository <User , Long>{

	
}
