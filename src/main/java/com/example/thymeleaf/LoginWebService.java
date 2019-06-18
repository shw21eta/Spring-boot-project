package com.example.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginWebService {
	
	@Autowired
	LoginRepository loginRepository;
	
	public User getUserDetails(String username) {
		return loginRepository.findOne(username);
	}
	
	public void addUser(User user) {
		loginRepository.save(user);
//		System.out.println("User info: username-"+user.getUsername()+" Password-"+user.getPassword());
//		System.out.println("User is saved");
	}
	
	public User getUser(String name) {
		return loginRepository.findOne(name);
	}
}
