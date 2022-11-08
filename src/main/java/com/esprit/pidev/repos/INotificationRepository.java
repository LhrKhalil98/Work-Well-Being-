package com.esprit.pidev.repos;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.esprit.pidev.entities.Notification;


@Repository
public interface INotificationRepository extends JpaRepository<Notification, Integer> {
    
  

}
