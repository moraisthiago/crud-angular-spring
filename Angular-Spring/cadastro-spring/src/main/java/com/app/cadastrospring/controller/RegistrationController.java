package com.app.cadastrospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.cadastrospring.model._User;
import com.app.cadastrospring.service.RegistrationService;

@RestController
public class RegistrationController {
	
	
	@Autowired
	private RegistrationService service;
	
	@PostMapping("/registeruser")
	@CrossOrigin(origins = "http://localhost:4200")
	public _User registerUser(@RequestBody _User user) throws Exception {
	String tempEmailId = user.getEmailId();
	if (tempEmailId != null && !"".equals(tempEmailId)) {
		_User userobj = service.fetchUserbyEmailId(tempEmailId);
		if(userobj != null){
		throw new Exception("O usuário" + tempEmailId + "já existe!");
	}
	 }
	_User userObj = null;
	userObj = service.saveUser(user);
	return userObj;	
}
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public _User loginUser(@RequestBody _User user) throws Exception {
		String tempEmailId = user.getEmailId();
		String tempPass = user.getPassword();
		_User userObj = null;
		if(tempEmailId != null && tempPass != null){
		   userObj = service.fetchUserbyEmailIdAndPass(tempEmailId, tempPass);
		}
		if(userObj == null) {
			throw new Exception("Usuário não encontrado!");
		}
		
		return userObj;
	}

}
