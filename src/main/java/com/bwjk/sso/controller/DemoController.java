package com.bwjk.sso.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bwjk.sso.db.model.Demo;
import com.bwjk.sso.model.request.DemoReqDTO;
import com.bwjk.sso.service.DemoService;

@RestController
public class DemoController {
	private static final Logger LOGGER = Logger.getLogger(DemoController.class);
	@Autowired
	private DemoService demoService;
	
	@RequestMapping("/likeName")
	public List<Demo> likeName(@Validated DemoReqDTO requestDTO) {
		
		long startTime = System.currentTimeMillis();
		List<Demo>  result = demoService.likeName(requestDTO.getName());
		
		LOGGER.info("Controller cost time:" + (System.currentTimeMillis() - startTime));

		return result;

	}
}
