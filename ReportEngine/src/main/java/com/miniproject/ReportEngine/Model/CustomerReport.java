package com.miniproject.ReportEngine.Model;


import java.util.Date;

import lombok.Data;

@Data
public class CustomerReport 
{
	private Integer id;
	
	private String name;
	
	private String address;
	
	private String phone;
	
	private String gender;
	
	private String email;
	
	private Date dateOfRegister;
	
	private Boolean activeAccount;
	

	
	
}
