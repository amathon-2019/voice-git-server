package com.common.exception;

import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * 공통 비즈니스 로직 Exception Class
 * @author  Dong-Min Seol
 * @since	2019.02.03
 *
 */
public class BizException extends Exception {
	
	// defatul serial ID
	private static final long serialVersionUID = 1L;

	// 최종 error message
	protected String errMsg = "";
	
	// 최종 error code
	protected String errCode = "";
	
	/**
	 * <pre>
	 * Biz Exception Constructor
	 * </pre>
	 * 
     * 공통 비즈니스 로직 Exception Class
     * @author  Dong-Min Seol
     * @since	2019.02.03
	 */
	public BizException() { super(); }
	
	public BizException(String errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg  = errMsg;
	}
	
	public void forceRollBack() {
		TransactionAspectSupport.currentTransactionStatus().isRollbackOnly();
	}
	
	public String getErrMsg()  { return errMsg;  }
	public String getErrCode() { return errCode; }
}
