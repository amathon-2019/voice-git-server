package com.common.util;
import java.io.UnsupportedEncodingException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.common.collection.CommonVO;
import com.common.enumtype.BizExceptionCode;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 * 파일 처리 관련 모듈
 * 
 * @author Dong-Min Seol
 * @since  2019.05.28
 */
public class JwtMo {
	Logger log = LoggerFactory.getLogger(JwtMo.class);
	
	private static final String SALT =  "sight";
	
	/**
	 * <pre>
	 *     유저 정보가 담긴 토큰 생성
	 * </pre>
	 * @author Dong-Min-Seol
	 * @since  2019. 8. 1.
	 */
	public static String encryptJWT(CommonVO vo) {
		return Jwts.builder()
				   .setIssuer("baram")
				   .setSubject(vo.getString("ID"))
				   .claim("USER_SEQ"     , vo.getString("USER_SEQ"))
				   .claim("ID"           , vo.getString("ID"))
				   .setIssuedAt(Date.from(Instant.now()))
				   .setExpiration(Date.from(Instant.now().plus(30, ChronoUnit.DAYS)))
				   .signWith(SignatureAlgorithm.HS256, SALT.getBytes())
				   .compact();
	}
	/**
	 * <pre>
	 *     유저 정보가 담긴 토큰 해독
	 * </pre>
	 * @author Dong-Min-Seol
	 * @since  2019. 8. 1.
	 */
	public static CommonVO decryptJWT(String jwt) {
		
		// [1] 결과 컨테이너 세팅
		CommonVO result   = new CommonVO();
		String   REPL_CD  = "000000";
		String   REPL_MSG = "정상";
		
		try {
			// [2] JWT 복호화
			Claims claims = Jwts.parser().setSigningKey(SALT.getBytes("UTF-8")).parseClaimsJws(jwt).getBody();
			claims.forEach(result::put);
			
		} catch (ExpiredJwtException e) {
			REPL_CD  = "000002";
			REPL_MSG = BizExceptionCode.search(REPL_CD).getErrMsg();
			e.printStackTrace();
		} catch (UnsupportedJwtException  | MalformedJwtException | SignatureException | 
				 IllegalArgumentException | UnsupportedEncodingException e) {
			REPL_CD  = "000003";
			REPL_MSG = BizExceptionCode.search(REPL_CD).getErrMsg();
			e.printStackTrace();
		} finally {
			// [3] 최종 결과값 세팅
			result.put("REPL_CD", REPL_CD);
			result.put("REPL_MSG", REPL_MSG);
		}
		return result;
	}
}
