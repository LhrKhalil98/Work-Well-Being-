package com.esprit.pidev.services;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.esprit.pidev.entities.Role;
import com.esprit.pidev.entities.User;
import com.esprit.pidev.repos.IRoleRepository;
import com.esprit.pidev.repos.IUserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class ServiceImpIUser implements ServiceIUser ,UserDetailsService {
	
	private static final long EXPIRE_TOKEN_AFTER_MINUTES = 10;
	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private IRoleRepository roleRepository;
	
	@Autowired
	private ServiceINotification notificationService ; 

	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		{
			User user = userRepository.findByUserName(username);
			Collection<SimpleGrantedAuthority> authorities = new ArrayList<>() ; 
			user.getRoles().forEach(role -> {authorities.add(new SimpleGrantedAuthority(role.getRole())) ; 
			});
			return new org.springframework.security.core.userdetails.User(user.getUserName(),
			user.getPassword(),user.isVerified(), true, true, true, authorities); 
		}
	}



	
	public User findUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
		}

	@Override
	public User saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

		user.setVerified(true);
		user.setAbrroved(false);
		String message = "There is a new user : "+user.getUserName()+"Waiting for verification " ; 

		Collection<User> users = userRepository.findAll() ; 
		for( User user1 : users ){
			for( Role role : user1.getRoles()){
				if(role.getRole()=="ADMIN"){
					System.out.println(role.getRole());
					notificationService.ajouterNotification(user1, message, "New User");
				}
			}
			
		}
		return userRepository.save(user); 
		
		 
	}

	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		User user  = userRepository.findByUserName(username) ; 
		Role role = roleRepository.findByRole(roleName) ; 
		user.getRoles().add(role); 
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}




	@Override
	public void activerAccount(String username) {
		User user =  userRepository.findByUserName(username);
		user.setAbrroved(true);
		userRepository.save(user) ; 
	}




	@Override
	public String forgotPassword(String email) {
		Optional<User> userOptional = Optional
				.ofNullable(userRepository.findByEmail(email));

		if (!userOptional.isPresent()) {
			return "Invalid email id.";
		}
		User user = userOptional.get();
		user.setToken(generateToken());
		user.setTokenCreationDate(LocalDateTime.now());

		user = userRepository.save(user);

		return user.getToken();
	}

	@Override
	public String resetPassword(String token, String password) {
		
		Optional<User> userOptional = Optional
				.ofNullable(userRepository.findByToken(token));

		if (!userOptional.isPresent()) {
			return "Invalid token.";
		}

		LocalDateTime tokenCreationDate = userOptional.get().getTokenCreationDate();
		if (isTokenExpired(tokenCreationDate)) {
			return "Token expired.";
		}

		User user = userOptional.get();
		
		

		user.setPassword(bCryptPasswordEncoder.encode(password));
	

		user.setToken(null);
		user.setTokenCreationDate(null);
		userRepository.save(user);

		return "Your password successfully updated.";
	}

	@Override
	public String generateToken() {
		StringBuilder token = new StringBuilder();

		return token.append(UUID.randomUUID().toString())
				.append(UUID.randomUUID().toString()).toString();
	}

	@Override
	public boolean isTokenExpired(LocalDateTime tokenCreationDate) {
		LocalDateTime now = LocalDateTime.now();
		Duration diff = Duration.between(tokenCreationDate, now);

		return diff.toMinutes() >= EXPIRE_TOKEN_AFTER_MINUTES;
	}




	




	


}
