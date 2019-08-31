package com.common.util;

import java.time.LocalDate;

/**
 * 랜덤 모듈
 * 
 * @author Dong-Min Seol
 * @since  2019.05.28
 */
public class DateMo {
	
	
	/**
	 * <pre>
	 *   현재 년 월 일을 yyyymmdd 형식으로 리턴한다.
	 * </pre>
	 * @param  생성할 문자열 길이
	 * @author Dong-Min-Seol
	 * @since  2019. 8. 9.
	 */
	public static String getYYYYMMDD(String delimeter) {
		String       result;
		StringBuffer sb   = new StringBuffer(20);
		LocalDate    time = LocalDate.now();
		 
		int year  = time.getYear();
		int month = time.getMonthValue();
		int date  = time.getDayOfMonth();
		
		result = sb.append(year).append(delimeter)
				   .append(month).append(delimeter)
				   .append(date).append(delimeter).toString();
		
		sb.delete(0, sb.length());
		sb = null;
		return result;
	}
	
	// Overloaded
	public static String getYYYYMMDD() {
		return DateMo.getYYYYMMDD("");
	}
	
}
