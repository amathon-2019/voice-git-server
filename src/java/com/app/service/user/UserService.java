package com.app.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.collection.CommonVO;
import com.common.dao.CommonDaoIF;
import com.common.service.BaseService;

@Service
public class UserService extends    BaseService 
						 implements UserServiceIF {
	@Autowired
	CommonDaoIF dao;

	/**
	 * 깃허브 로그인 연동 - 최초로 해당 서버에 접속한 유저일 경우 서버에 정보 저장
	 * 
	 * @author Dong-Min Seool
	 * @since  2019-08-31
	 */
	@Override
	public CommonVO registerUserIfNew(CommonVO param) throws Exception {

		// [1] 결과 컨테이너 세팅
		CommonVO result = new CommonVO();
		
		// [2] DB 에서 해당 유저 조회
		CommonVO user = dao.select("com.app.mapper.user.selectUser", param);

		// [3] 서버에 해당 유저 정보가 없을 경우 신규 데이터 저장
		if(user == null) {
			log.i("[event] 신규 유저 감지 정보 저장  -> 유저명 : "+param.getString("displayName"));
			dao.insert("com.app.mapper.user.signup", param);
		}
		return result;
	}
}















