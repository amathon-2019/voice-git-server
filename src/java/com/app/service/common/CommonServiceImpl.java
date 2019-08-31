package com.app.service.common;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.common.collection.CommonVO;
import com.common.dao.CommonDaoIF;
import com.common.service.BaseService;
import com.common.util.DateMo;
import com.common.util.RandomMo;

@Service
public class CommonServiceImpl extends BaseService 
							   implements CommonServiceIF {

	@Autowired
	CommonDaoIF dao;
	
	@Value("#{common['FILE_PATH']}")
	String filePath;
	
	@Override
	public CommonVO OAuthTest(CommonVO param) throws Exception {
		return null;
	}

	@Override
	public CommonVO fileUploadTest(CommonVO param) throws Exception {
		
		CommonVO result = new CommonVO();
		
		MultipartFile fileInput  = (MultipartFile) param.get("uploadFile");
		
		String path = filePath + "/temp/" + DateMo.getYYYYMMDD("_") + RandomMo.getRandomString(5)+ "_" + fileInput.getOriginalFilename();;
		File fileOutput = new File(path);

		FileCopyUtils.copy(fileInput.getBytes(), fileOutput);
		return result;
	}
}















