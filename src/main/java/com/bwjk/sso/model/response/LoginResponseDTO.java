package com.bwjk.sso.model.response;

import com.bwjk.common.basedto.BaseReponseDTO;

/**
 * login response dto, the token will empty if login fail.
 * @author buzl
 *
 */
public class LoginResponseDTO extends BaseReponseDTO{

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
