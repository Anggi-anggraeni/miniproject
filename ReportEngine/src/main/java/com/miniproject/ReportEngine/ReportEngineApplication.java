package com.miniproject.ReportEngine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.miniproject.ReportEngine.Repo.RepoCust;
import com.miniproject.ReportEngine.Repo.RepoKlas;

@SpringBootApplication

@EnableJpaAuditing
public class ReportEngineApplication {

	@Autowired
	RepoCust repoCust;
//	RepoKlas repoKlas;

	@Autowired
	public ReportEngineApplication(RepoCust repoCust)
	{
		this.repoCust = repoCust;
	}
	
//	@Autowired
//	public ReportEngineApplication(RepoKlas repoKlas)
//	{
//		this.repoKlas = repoKlas;
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(ReportEngineApplication.class, args);
	}

}
