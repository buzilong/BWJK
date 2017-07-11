package com.buzl.springboot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "/auth")
public class AuthenticationController {

	@PostMapping(path="/login")
	public void login(){
		System.out.println("test");
	}
}
