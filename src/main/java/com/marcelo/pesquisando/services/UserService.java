package com.marcelo.pesquisando.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.marcelo.pesquisando.entities.User;
import com.marcelo.pesquisando.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	
	public List<User> findAll(){
		return repository.findAll();
	}

	public User findByuserName(String userName) {
		//OrderBySeatNumberAsc()
		User user =  repository.findByUsername(userName);
		return user;
	}
	
	public User insert(User obj) {
		BCryptPasswordEncoder encoder  = new BCryptPasswordEncoder();	

		obj.setPassword(encoder.encode(obj.getPassword()));
		

		return repository.save(obj);
	}
	
	
	public User upDate(String userName, User obj) {
		
		User entity = repository.findByUsername(userName);
		updateData(entity,obj);
		
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		
		entity.setUsername(obj.getUsername());
		entity.setEnabled(obj.getEnabled());
	
		
	}

	public String userLogado() {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = repository.findByUsername(username);
		
		return user.getUsername();
	}
	

	

}
