package com.esprit.pidev.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.User;
@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
	User findByUserName(String userName);
	User findByEmail(String email);

	User findByToken(String token);

}
