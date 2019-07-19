package com.miniproject.ReportEngine.Model;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;



public class listKlaster 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String titleklaster;
	
	@Column(name="data_source")
	private String dataSource;
	
	private String contact;
	
	
	@Temporal(TemporalType.TIMESTAMP)

	@Column(name="data_of_filling")
	private String dateOfFilling;
	
	@Column(name="update_of_klaster")
	@Temporal(TemporalType.TIMESTAMP)

	private String updateOfKlaster;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitleklaster() {
		return titleklaster;
	}

	public void setTitleklaster(String titleklaster) {
		this.titleklaster = titleklaster;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDateOfFilling() {
		return dateOfFilling;
	}

	public void setDateOfFilling(String dateOfFilling) {
		this.dateOfFilling = dateOfFilling;
	}

	public String getUpdateOfKlaster() {
		return updateOfKlaster;
	}

	public void setUpdateOfKlaster(String updateOfKlaster) {
		this.updateOfKlaster = updateOfKlaster;
	}

}
