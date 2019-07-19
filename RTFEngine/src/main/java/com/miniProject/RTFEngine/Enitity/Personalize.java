package com.miniProject.RTFEngine.Enitity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name ="personalize")

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Personalize {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(name ="type_person")
	private String personType;
	
	@Column(name ="person_id")
	private String personId;
	
	private String blood;
	
	
}
