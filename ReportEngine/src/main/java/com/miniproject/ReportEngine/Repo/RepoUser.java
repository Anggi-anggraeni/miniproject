package com.miniproject.ReportEngine.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.ReportEngine.Model.Users;

public interface RepoUser extends JpaRepository<Users, Integer> 
{
	public Users findByUsername(String username);
}
