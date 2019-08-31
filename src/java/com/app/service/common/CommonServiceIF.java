package com.app.service.common;

import com.common.collection.CommonVO;

public interface CommonServiceIF {
	
	public CommonVO OAuthTest(CommonVO param) throws Exception;
	
	public CommonVO fileUploadTest(CommonVO param) throws Exception;
}
