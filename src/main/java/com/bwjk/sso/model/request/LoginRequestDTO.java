package com.bwjk.sso.model.request;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginRequestDTO {

	@NotEmpty
	public String userName;
	
	@NotEmpty
	public String password;
}
