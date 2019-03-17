package com.activity.service;

import org.springframework.web.multipart.MultipartFile;

import com.activity.bean.Datainfo;
import com.activity.service.result.ObjectResult;
import com.activity.service.result.PageResult;
import com.activity.util.ResultUtil;

public interface IDataInfoService {

	PageResult<Datainfo> getDatainfoByParam(String fileName, String dataType, String setDate, 
			String title, Integer userId, Integer hdId, Integer pageNum, Integer pageSize);
	
	ObjectResult<Datainfo> addDatainfo(Datainfo dataInfo, MultipartFile file, String filePath);
	ObjectResult<Datainfo> editDatainfo(Datainfo dataInfo, MultipartFile file, String filePath);
	ResultUtil delDatainfo(Integer id);
}
