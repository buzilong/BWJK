package com.bwjk.sso.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwjk.common.basedto.AuthInfo;
import com.bwjk.sso.common.util.JwtUtil;
import com.bwjk.sso.db.entity.UserAuthEntity;
import com.bwjk.sso.db.mapper.UserAuthMapper;
import com.bwjk.sso.model.request.LoginRequestDTO;
import com.bwjk.sso.model.response.LoginResponseDTO;
import com.google.gson.Gson;

@Service
public class AuthBusiness {
	
	private static Gson GSON = new Gson();
	
	@Autowired
	private UserAuthMapper userAuthMapper;
	@Autowired
	private JwtUtil jwtUtil;
	
	public LoginResponseDTO loginByAccNameAndPassword(LoginRequestDTO loginRequestDTO) {

		LoginResponseDTO responseDTO = null;
		UserAuthEntity userAuth = userAuthMapper.getByAccNameAndPassword(loginRequestDTO.getUserName(),
				loginRequestDTO.getPassword());
		if (userAuth != null) {
			String token = generateJWTToken(userAuth);
			responseDTO = new LoginResponseDTO();
			responseDTO.setToken(token);
			responseDTO.setUserId(userAuth.getUserId());
		}
		return responseDTO;
	}
	
	private String generateJWTToken(UserAuthEntity userAuth){
		AuthInfo authInfo= new AuthInfo();
		authInfo.setAccName(userAuth.getAccName());
		//authInfo.setLoginTime(new Date());
		authInfo.setUserId(userAuth.getUserId());
		authInfo.setRefreshTime(System.currentTimeMillis());
		
		return jwtUtil.createJWT(userAuth.getUserId(), GSON.toJson(authInfo), 60*60*1000);
	}
}
