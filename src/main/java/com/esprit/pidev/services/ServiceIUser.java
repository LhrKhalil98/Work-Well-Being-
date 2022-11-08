package com.esprit.pidev.services;

import java.time.LocalDateTime;
import java.util.List;

import com.esprit.pidev.entities.Role;
import com.esprit.pidev.entities.User;

public interface ServiceIUser {
	
	public User saveUser(User user);
	public User findUserByUserName(String username); 
	public Role saveRole(Role role);
	void addRoleToUser ( String username , String roleName ) ; 
	List<User> getUsers();
	void activerAccount (String username) ; 
	public String forgotPassword(String email) ; 
	public String resetPassword(String token, String password) ; 
	 String generateToken() ; 
	public boolean isTokenExpired(LocalDateTime tokenCreationDate) ; 
}
