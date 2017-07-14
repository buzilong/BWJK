package com.bwjk.sso.controller;

import com.bwjk.sso.common.config.Constant;
import com.bwjk.sso.common.util.JwtUtil;
import com.bwjk.sso.model.request.LoginRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

	private RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private JwtUtil jwt;

	@RequestMapping("/test")
	public long test(int times) {

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {
			restTemplate.getForObject("http://localhost:8088/likeName?name=bu", String.class);
		}

		return System.currentTimeMillis() - startTime;

	}

	@RequestMapping("/user/login")
	public Object getAccessToken(LoginRequestDTO loginRequest) {
		System.out.println("/user/login");
		String subject = JwtUtil.generalSubject(loginRequest);
		try {
			String token = jwt.createJWT(Constant.JWT_ID, subject, Constant.JWT_TTL);
			return token;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Failed";
	}
}
