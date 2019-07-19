package com.miniproject.ReportEngine.Model;

import java.math.BigInteger;
import java.util.Date;

import lombok.Data;

@Data
public class CustomerReport 
{
	private Long id;
	
	private String name;
	
	private String address;
	
	private String phone;
	
	private String gender;
	
	private String email;
	
	private Date dateOfRegister;
	
	private Boolean activeAccount;
	

	
	
}
