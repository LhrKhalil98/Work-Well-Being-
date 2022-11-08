package com.esprit.pidev.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Departement;
@Repository
public interface IDepartementRepository extends JpaRepository<Departement, Integer>{

}
