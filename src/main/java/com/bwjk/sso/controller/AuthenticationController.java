package com.bwjk.sso.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bwjk.sso.model.request.LoginRequestDTO;

@RestController()
@RequestMapping(path = "/auth")
public class AuthenticationController {

	@PostMapping(path="/login")
	public void login(@Validated @RequestBody LoginRequestDTO request){
		System.out.println("test");
	}
}
