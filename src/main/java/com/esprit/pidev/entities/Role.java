package com.esprit.pidev.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity 
public class Role implements Serializable {

@Id
@GeneratedValue(strategy =
GenerationType.AUTO)
private int id;
@Enumerated(EnumType.STRING)
private RoleName role;

public Role() {
	super();
	// TODO Auto-generated constructor stub
}
public Role(int id, RoleName role) {
	super();
	this.id = id;
	this.role = role;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getRole() {
	
	return role.toString();
}
public void setRole(RoleName role) {
	this.role = role;
}


}
