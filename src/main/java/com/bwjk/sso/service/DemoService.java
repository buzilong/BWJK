package com.bwjk.sso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwjk.sso.db.mapper.DemoMappper;
import com.bwjk.sso.db.model.Demo;

@Service
public class DemoService {
	@Autowired
	private DemoMappper demoMappper;

	public List<Demo> likeName(String name) {
		return demoMappper.likeName(name);
	}
}
