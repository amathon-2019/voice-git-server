package com.common.dao;

import java.util.List;

import com.common.collection.CommonVO;
import com.common.collection.CommonVOList;

/**
 * 공통 Dao 인터페이스 
 * 
 * @author Dong-Min Seol
 * @since  2019.03.03
 */
public interface CommonDaoIF {
	
	// 단일 조회
	public CommonVO select(String mapperId, CommonVO param);
	
	// 삽입
	public int insert(String mapperId, CommonVO param);
	
	// 수정
	public int update(String mapperId, CommonVO param);
	
	// 삭제
	public int delete(String mapperId, CommonVO param);

	// 리스트 조회 [일반 리스트]
	public List<CommonVO> selectList(String mapperId, CommonVO param);
	
	// 리스트 조회 [CommonVOList]
	public CommonVOList<CommonVO> selectCommonVOList(String mapperId, CommonVO param);
}
