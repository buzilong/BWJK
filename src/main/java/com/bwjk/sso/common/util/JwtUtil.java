package com.bwjk.sso.common.util;

import com.alibaba.fastjson.JSONObject;
import com.bwjk.sso.common.config.Constant;
import com.bwjk.sso.model.request.LoginRequestDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

@Component
public class JwtUtil {
	
	@Value("${spring.profiles.active}")
    private static String profiles;
	
	/**
	 * 由字符串生成加密key
	 * @return
	 */
	private static SecretKey generalKey(){
		String stringKey = profiles+ Constant.JWT_SECRET;
		byte[] encodedKey = Base64.decodeBase64(stringKey);
	    SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
	    return key;
	}

	/**
	 * 创建jwt
	 * @param id
	 * @param subject
	 * @param ttlMillis
	 * @return
	 * @throws Exception
	 */
	public static String createJWT(String id, String subject, long ttlMillis) throws Exception {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		// 生成签名密钥
		SecretKey key = generalKey();

		// 添加构成JWT的参数
		JwtBuilder builder = Jwts.builder()
			.setId(id)
			.setIssuedAt(now)
			.setSubject(subject)
		    .signWith(signatureAlgorithm, key);

		// 添加Token过期时间
		if (ttlMillis >= 0) {
		    long expMillis = nowMillis + ttlMillis;
		    Date exp = new Date(expMillis);
		    builder.setExpiration(exp);
		}
		return builder.compact();
	}
	
	/**
	 * 解密jwt
	 * @param jwt
	 * @return
	 * @throws Exception
	 */
	public static Claims parseJWT(String jwt) throws Exception{
		SecretKey key = generalKey();
		Claims claims = Jwts.parser()         
		   .setSigningKey(key)
		   .parseClaimsJws(jwt).getBody();
		return claims;
	}
	
	/**
	 * 生成subject信息
	 * @param loginRequest
	 * @return
	 */
	public static String generalSubject(LoginRequestDTO loginRequest){
		JSONObject jo = new JSONObject();
		jo.put("userName", loginRequest.getUserName());
		return jo.toJSONString();
	}

	public static void main(String[] arge) {
		System.out.println(String.valueOf("1"));
	}
}
