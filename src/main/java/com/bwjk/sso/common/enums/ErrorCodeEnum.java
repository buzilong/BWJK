package com.bwjk.sso.common.enums;

public enum ErrorCodeEnum {

	
	ERR_SYSTEM("E10000000","E"),
	ERR_SESSION_TIMEOUT("E10000001","E");
	
	private String code;
	private String actionType;
	private ErrorCodeEnum(String code, String actionType) {
		this.code = code;
		this.actionType = actionType;
	}
	
	public static ErrorCodeEnum valueIn(String orgs){
		for (ErrorCodeEnum enumz : ErrorCodeEnum.values()) {
			if (enumz.getCode().equals(orgs)) {
				return enumz;
			}
		}
		return null;
	}

	public String getCode() {
		return this.code;
	}
	public String getActionType(){
		return this.actionType;
	}
}

