package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.User;
import com.example.repository.UserRepository;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping
	public @ResponseBody String index() {
		return "Hello Woniper Spring Boot~";
	}

	@RequestMapping("/users")
	public @ResponseBody List<User> getUserList() {
		return ((JpaRepository<User, Long>) userRepository).findAll();
	}
	
	@RequestMapping("/userAdd")
	public @ResponseBody List<User> serUserAdd(User user) {
		
		user.setName("홍길동");
		user.setAge(30);
		
		userRepository.save(user); 
		
		return ((JpaRepository<User, Long>) userRepository).findAll();
	}
	

}
