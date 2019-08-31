package com.common.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <pre>
 * HashMap 기반의 commonVO
 * </pre>
 * 
 * @author  Dong-Min Seol 
 * @since	2019.02.03
 */
public class CommonVO extends HashMap<String, Object> {
	
	private static final long serialVersionUID = 1L;
	private static ObjectMapper mapper = new ObjectMapper();
	
	/**
	 * <pre>
	 * default 생성자
	 * </pre>
	 */
	public CommonVO() {}
	
	/**
	 * <pre>
	 * Map을 데이터를 받아서 VO에 세팅하는 생성자
	 * </pre>
	 * 
	 * @author  Dong-Min Seol
	 * @since   2019.02.03
	 */
	public <E> CommonVO (Map<String, Object> map) {
		map.forEach(this::put);
	}
	
	
	/**
	 * 해당 key 값이 비어있는지 확인하는 함수
	 * 
	 * @author  Dong-Min Seol
	 * @since   2019.02.03
	 * @return  true (null || 공백) / false ( 값이 존재 )
	 * 
	 */
	public boolean isEmpty(String key) {
		boolean flag = false;
		if (this.get(key) == null || this.getString(key).equals("")) {
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 해당 key의 Value를 String 형태로 가져오는 함수
	 * 
	 * @author  Dong-Min Seol
	 * @since   2019.02.03
	 * @return  value of key (String type)
	 *
	 */
	public String getString(String key) {
		return Optional.of(String.valueOf(this.get(key)))
					   .filter(i -> ! "null".equals(i))
					   .filter(i -> ! i.isEmpty())
					   .orElse("");
	}
	
	/**
	 * 해당 key의 Value를 int 형태로 가져오는 함수
	 * 
	 * @author  Dong-Min Seol
	 * @since   2019.02.03
	 * @return  value of key (String type)
	 *
	 */
	public int getInt(String key) {
		return Optional.of(String.valueOf(this.get(key)))
					   .filter(i -> ! "null".equals(i))
					   .filter(i -> ! i.isEmpty())
					   .map(Integer::parseInt)
					   .orElse(0);
	}
	
	/**
	 * jackson 라이브러리 기반 CommonVOList 내용을 JSON string으로 리턴하는 함수
	 * 
	 * @author Dong-Min Seol
	 * @since  2019.04.01
	 */
	public String toJson() {
		String result = "";
		try {
			result = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}
}
