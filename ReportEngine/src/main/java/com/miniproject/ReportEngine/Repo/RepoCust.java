package com.miniproject.ReportEngine.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.miniproject.ReportEngine.Model.listCustomer;

public interface RepoCust extends JpaRepository<listCustomer, Long> {

	@Query(value = "select id, name, address, phone, gender, email, date_of_register, active_account" + 
			"from list_customer", nativeQuery = true )
	public List<Object[]> customerReport();
}
