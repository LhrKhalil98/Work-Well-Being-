package com.esprit.pidev.services;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.pidev.entities.Notification;
import com.esprit.pidev.entities.User;
import com.esprit.pidev.repos.INotificationRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service @RequiredArgsConstructor @Transactional @Slf4j
public class ServiceImpINotification implements ServiceINotification{
	@Autowired
	private INotificationRepository notificationRepo ; 

	@Override
	public void ajouterNotification( User user , String message , String title) {
		Notification notification = new Notification () ; 
		notification.setDescription(message);
		notification.setTitle(title);
		notification.setUser(user);
		notificationRepo.save(notification) ;  
		
		 
	}


	
	
	
	

}
