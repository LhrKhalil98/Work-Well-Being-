package com.esprit.pidev.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id ; 
	@Column
	private String userName ; 
	@Column
	private String Name ; 
	@Column
	private String lastName ; 
	@Column
	private Date birthDate ; 
	@Column
	private String currentPosition ; 
	@Column
	private int phone ; 
	@Column(unique=true)
	//@Pattern(regex=".+\@.+\..+")
	private String email ; 
	@Column
	private String password ; 
	@Column
	private boolean isVerified; 
	@Column
	private boolean isAbrroved; 
	@Column
	private int points ; 
	

	private String token;
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime tokenCreationDate;
	
	@OneToMany(mappedBy="user", 
			cascade={CascadeType.PERSIST, },
			fetch=FetchType.EAGER)
	private List<Notification> notifications;
	@ManyToMany(cascade={CascadeType.PERSIST} , fetch =FetchType.EAGER ) 
	private Set<Role> roles ;
	
	@JsonIgnore
	private Departement departement;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String userName, String name, String lastName, Date birthDate, String currentPosition,
			int phone, String email, String password, boolean isVerified,boolean isAbrroved ,Departement departement ,  int points, List<Notification> notifications,
			Set<Role> roles) {
		super();
		this.id = id;
		this.userName = userName;
		Name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.currentPosition = currentPosition;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.isVerified = isVerified;
		this.points = points;
		this.notifications = notifications;
		this.roles = roles;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getCurrentPosition() {
		return currentPosition;
	}
	public void setCurrentPosition(String currentPosition) {
		this.currentPosition = currentPosition;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isVerified() {
		return isVerified;
	}
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public List<Notification> getNotifications() {
		return notifications;
	}
	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public boolean isAbrroved() {
		return isAbrroved;
	}
	public void setAbrroved(boolean isAbrroved) {
		this.isAbrroved = isAbrroved;
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public LocalDateTime getTokenCreationDate() {
		return tokenCreationDate;
	}
	public void setTokenCreationDate(LocalDateTime tokenCreationDate) {
		this.tokenCreationDate = tokenCreationDate;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

	
	

}
