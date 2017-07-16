package com.bwjk.sso.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwjk.sso.db.entity.UserAuthEntity;
import com.bwjk.sso.db.mapper.UserAuthMapper;
import com.bwjk.sso.model.request.LoginRequestDTO;
import com.bwjk.sso.model.response.LoginResponseDTO;

@Service
public class AuthBusiness {
	
	@Autowired
	private UserAuthMapper userAuthMapper;
	
	public LoginResponseDTO loginByAccNameAndPassword (LoginRequestDTO loginRequestDTO){
		
		LoginResponseDTO responseDTO = null;
		UserAuthEntity userAuth = userAuthMapper.getByAccNameAndPassword(loginRequestDTO.getUserName(), loginRequestDTO.getPassword());
		if(userAuth!=null){
			responseDTO = new LoginResponseDTO();
			responseDTO.setToken("TESTTOKEN");
			responseDTO.setUserId(userAuth.getUserId());
		}
		return responseDTO;
		
	}
}
