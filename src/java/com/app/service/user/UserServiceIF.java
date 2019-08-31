package com.app.service.user;

import com.common.collection.CommonVO;

public interface UserServiceIF {
	
	public CommonVO registerUserIfNew(CommonVO param) throws Exception;
}
