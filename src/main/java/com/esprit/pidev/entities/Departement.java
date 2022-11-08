package com.esprit.pidev.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Departement  implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id ; 
	@Column
	private String departementName ;
	@OneToMany(mappedBy="departement", 
			cascade={CascadeType.PERSIST, },
			fetch=FetchType.EAGER)
	private List<User> users;
	
	public Departement(int id, String departementName) {
		super();
		this.id = id;
		this.departementName = departementName;
	}
	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepartementName() {
		return departementName;
	}
	public void setDepartementName(String departementName) {
		this.departementName = departementName;
	} 
	
	

}
