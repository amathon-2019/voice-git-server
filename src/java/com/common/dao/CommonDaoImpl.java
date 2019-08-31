package com.common.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.common.collection.CommonVO;
import com.common.collection.CommonVOList;

/**
 * 공통 Dao 인터페이스 imple
 * 
 * @author Dong-Min Seol
 * @since  2019.03.03
 */
@Repository
public class CommonDaoImpl implements CommonDaoIF{

	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public int insert(String mapperId, CommonVO param){
		return sqlSession.insert(mapperId, param);
	}

	@Override
	public int update(String mapperId, CommonVO param) {
		return sqlSession.update(mapperId, param);
	}

	@Override
	public int delete(String mapperId, CommonVO param) {
		return sqlSession.delete(mapperId, param);
	}

	@Override
	public CommonVO select(String mapperId, CommonVO param) {
		return sqlSession.selectOne(mapperId, param);
	}
	
	@Override
	public List<CommonVO> selectList(String mapperId, CommonVO param) {
		return sqlSession.selectList(mapperId, param);
	}
	
	@Override
	public CommonVOList<CommonVO> selectCommonVOList(String mapperId, CommonVO param) {
		return new CommonVOList<>(sqlSession.selectList(mapperId, param));
	}
}
