package com.buzl.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buzl.springboot.db.mapper.DemoMappper;
import com.buzl.springboot.db.model.Demo;

@Service
public class DemoService {
	@Autowired
	private DemoMappper demoMappper;

	public List<Demo> likeName(String name) {
		return demoMappper.likeName(name);
	}
}
