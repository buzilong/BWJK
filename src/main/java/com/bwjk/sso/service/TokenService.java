package com.bwjk.sso.service;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.bwjk.common.exception.BusinessException;
import com.bwjk.sso.common.enums.ErrorCodeEnum;
import com.bwjk.sso.provider.EncrypAESProvider;


@ Service
public class TokenService {

	private static final Logger LOGGER = Logger.getLogger(TokenService.class);

	private EncrypAESProvider encrypAESProvider;

	TokenService(@Value("${token.secretkey}") String tokenSecretKey)
			throws NoSuchAlgorithmException, NoSuchPaddingException {
		encrypAESProvider = new EncrypAESProvider(tokenSecretKey);
	}

	/**
	 * Get encoded token 
	 * @param userId
	 * @return
	 * @throws BusinessException 
	 */
	public String generateToken(String userId) throws BusinessException {
		if (StringUtils.isEmpty(userId)) {
			return "";
		}
		String result = "";
		try {
			result = encrypAESProvider.Encrytor(String.valueOf(userId) + System.currentTimeMillis());
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException
				| UnsupportedEncodingException e) {
			LOGGER.error(String.format("Token 生成失败。user id:[%s]", userId));
			throw new BusinessException(String.format("Token 生成失败。user id:[%s]", userId), e,
					ErrorCodeEnum.ERR_SYSTEM.getCode(), ErrorCodeEnum.ERR_SYSTEM.getActionType());
		}
		return result;
	}
}
