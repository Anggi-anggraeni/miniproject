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
@Table(name ="list_klaster")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)

public class listKlaster implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String titleklaster;
	
	@Column(name="data_source")
	private String dataSource;
	
	private String contact;
	
	
	@Temporal(TemporalType.TIMESTAMP)

	@Column(name="date_of_filling")
	private Date dateOfFilling;
	
	@Column(name="update_of_klaster")
	@Temporal(TemporalType.TIMESTAMP)

	private Date updateOfKlaster;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Date getDateOfFilling() {
		return dateOfFilling;
	}

	public void setDateOfFilling(Date dateOfFilling) {
		this.dateOfFilling = dateOfFilling;
	}

	public Date getUpdateOfKlaster() {
		return updateOfKlaster;
	}

	public void setUpdateOfKlaster(Date updateOfKlaster) {
		this.updateOfKlaster = updateOfKlaster;
	}

}
