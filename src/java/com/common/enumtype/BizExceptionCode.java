package com.common.enumtype;

import java.util.Arrays;

/**
 * <pre>
 * 공통 에러코드 enum class
 * </pre>
 * 
 * @author 	Dong-Min Seol
 * @since  2019.02.23
 */
public enum BizExceptionCode {
	
	// 정상 에러코드 
	COMMON_ERROR_000000(200, "000000", "정상"),
	
	// 비정상 에러코드 (공통)
	COMMON_ERROR_000001(500,"000001", "공통 [unknown exception] 알 수 없는 에러입니다."),
	
	// 유저 관련 
	//   [1] JWT 인증 관련
	COMMON_ERROR_100001(412,"100001", "로그인 시간이 만료되었습니다"),
	COMMON_ERROR_100002(403,"100002", "로그인 [unknown exception] 관리자에게 문의해주세요");
	
	private int    replStatus;	// http 응답코드
	private String errMsg;		// 에러 메시지
	private String errCode;		// 에러 코드
	
	private BizExceptionCode(int repl_status ,String errCode, String errMsg) {
		this.replStatus = repl_status;
		this.errCode = errCode;
		this.errMsg = errMsg;
	}
	
	public String getErrMsg() {
		return errMsg;
	}

	public String getErrCode() {
		return errCode;
	}
	
	public int getReplStatus() {
		return replStatus;
	}

	/**
	 * <pre>
	 * 에러코드 기반 에러 조회 enum method
	 * 
	 * @author   Dong-Min Seol
	 * @since    2019.02.23
	 * @param    errCode   enum 에러 코드
	 * @return   ErrorCodeType 
	 * </pre> 
	 * 
	 */
	public static BizExceptionCode search(String errCode) {
		
		return Arrays.stream(BizExceptionCode.values())
					 .filter(t -> errCode.equals(t.getErrCode()))
					 .findAny()
					 .orElse(null);
	}
}
