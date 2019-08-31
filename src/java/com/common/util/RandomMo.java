package com.common.util;

/**
 * 랜덤 모듈
 * 
 * @author Dong-Min Seol
 * @since  2019.05.28
 */
public class RandomMo {
	
	// 가져올 랜덤 표본
	private static final char[] A_Z_0_9 = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j','k','l', 'm', 'n','o','p',
										    'q','r','s','t','u','v','w','x','y','z', '1','2','3','4','5','6','7','8','9','0' };
	
	/**
	 * <pre>
	 *    a-z / 0-9의  문자를 랜덤으로 조합해서 문자열로 리턴한다.
	 * </pre>
	 * @param  생성할 문자열 길이
	 * @author Dong-Min-Seol
	 * @since  2019. 8. 9.
	 */
	public static String getRandomString(int size) {
		String       result;
		StringBuffer sb = new StringBuffer(size);
		
		for(int i = 0 ; i < size; i++) {
			int r = (int) (Math.random()*A_Z_0_9.length);
			sb.append(A_Z_0_9[r]);
		}
		
		result = sb.toString();
		sb     = null;
		return result;
	}
}
