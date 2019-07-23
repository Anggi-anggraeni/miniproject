package com.miniproject.ReportEngine.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.miniproject.ReportEngine.Model.listKlaster;

public interface RepoKlas extends JpaRepository<listKlaster, Integer >{

	@Query(value = "select id, titleklaster, data_source, contact, date_of_filling, update_of_klaster  " + 
			"from list_klaster", nativeQuery = true )
	public List<Object[]> klasterReport();
}
