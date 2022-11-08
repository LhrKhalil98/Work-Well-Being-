package com.esprit.pidev.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Role;
@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {
	Role findByRole(String role);

}
 