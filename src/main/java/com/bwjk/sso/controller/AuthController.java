package com.bwjk.sso.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bwjk.sso.business.AuthBusiness;
import com.bwjk.sso.model.request.LoginRequestDTO;
import com.bwjk.sso.model.response.LoginResponseDTO;

@RestController()
@RequestMapping(path = "/auth")
public class AuthController {
	
	 private static final Logger LOGGER = Logger.getLogger(AuthController.class);
	  
	@Autowired
	private AuthBusiness authBusiness;

	@PostMapping(path = "/login")
	public LoginResponseDTO login(@Validated @RequestBody LoginRequestDTO loginRequestDTO) {
		LOGGER.info("Enter in login controller ");
		return authBusiness.loginByAccNameAndPassword(loginRequestDTO);
	}
}
