package com.miniproject.ReportEngine.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;



@Data
@Entity 
@Table(name ="list_customer")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)

public class listCustomer  implements Serializable
{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	private Integer id;
	private String name;
	private String address;
	private String phone;
	private String gender;
	private String email;
	
	
	@Column(name="date_of_register",updatable=true)
	@Temporal(TemporalType.TIMESTAMP)

	private Date dateOfRegister;
	
	@Column(name="active_account")
	private Boolean activeAccount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfRegister() {
		return dateOfRegister;
	}

	public void setDateOfRegister(Date dateOfRegister) {
		this.dateOfRegister = dateOfRegister;
	}

	public Boolean getActiveAccount() {
		return activeAccount;
	}

	public void setActiveAccount(Boolean activeAccount) {
		this.activeAccount = activeAccount;
	}
	
}
