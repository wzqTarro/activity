package com.activity.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.activity.bean.Datainfo;
import com.activity.bean.Userinfo;
import com.activity.constant.PageRecord;
import com.activity.dao.dbSql.DeleteId;
import com.activity.dao.dbSql.InsertId;
import com.activity.dao.dbSql.QueryId;
import com.activity.dao.dbSql.UpdateId;
import com.activity.service.CommonService;
import com.activity.service.IDataInfoService;
import com.activity.service.IUserService;
import com.activity.service.result.ObjectResult;
import com.activity.service.result.PageResult;
import com.activity.util.ResultUtil;

/**
 * 资源
 *                       
 * @Filename DataInfoServiceImpl.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author wangziqin
 *
 * @Email wangziqin@zcareze.com
 *       
 * @History
 * <li>Author: wangziqin</li>
 * <li>Date: 2019年3月2日</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 *
 */
@Service
public class DataInfoServiceImpl extends CommonService implements IDataInfoService{
	
	private static Logger LOGGER = LoggerFactory.getLogger(DataInfoServiceImpl.class);
	
	@Value("${file.path}")
	private static String FILE_PATH;
	
	@Autowired
	private IUserService userService;

	@Override
	public PageResult<Datainfo> getDatainfoByParam(String fileName, String dataType, String setDate, String title,
			Integer userId, Integer hdId, Integer pageNum, Integer pageSize) {
		PageResult<Datainfo> result = new PageResult<Datainfo>();
		Map<String, Object> param = new HashMap<>(6);
		if (StringUtils.isNoneEmpty(fileName)) {
			param.put("fileName", fileName);
		}
		if (StringUtils.isNoneEmpty(dataType)) {
			param.put("dataType", dataType);
		}
		if (StringUtils.isNoneEmpty(setDate)) {
			param.put("setDate", setDate);
		}
		if (StringUtils.isNoneEmpty(title)) {
			param.put("title", title);
		}
		if (userId != null) {
			param.put("userId", userId);
		}
		if (hdId != null) {
			param.put("hdId", hdId);
		}
		PageRecord<Datainfo> page = queryPageByObject(QueryId.COUNT_DATAINFO_BY_PARAM, QueryId.SELECT_DATAINFO_BY_PARAM, param, pageNum, pageSize);
		result.setCount(page.getPageTotal());
		result.setList(page.getList());
		return result;
	}

	@Override
	public ObjectResult<Datainfo> addDatainfo(Datainfo dataInfo, MultipartFile file, String filePath) {
		ObjectResult<Datainfo> result = new ObjectResult<Datainfo>();
		Userinfo loginInfo = userService.getCurrentLoginInfo();
		if (dataInfo == null) {
			result.error("资源信息不能为空");
			return result;
		}
		Integer userId = loginInfo.getId();
		if (file != null) {
			filePath = filePath + FILE_PATH + "/" + userId + "/" + file.getOriginalFilename();
			try {
				file.transferTo(new File(filePath));
			} catch (IllegalStateException | IOException e) {
				LOGGER.error("文件上传失败", e);
			}
			dataInfo.setFilepath(filePath);
		}
		dataInfo.setUserid(userId);
		dataInfo.setSetdate(new Date());
		insert(InsertId.INSERT_DATAINFO, dataInfo);
		result.setData(dataInfo);
		return result;
	}

	@Override
	public ObjectResult<Datainfo> editDatainfo(Datainfo dataInfo, MultipartFile file, String filePath) {
		ObjectResult<Datainfo> result = new ObjectResult<Datainfo>();
		if (dataInfo != null) {
			if (dataInfo.getId() != null) {
				update(UpdateId.UPDATE_DATAINFO, dataInfo);
				result.setData(dataInfo);
			}
		}
		
		return result;
	}

	@Override
	public ResultUtil delDatainfo(Integer id) {
		ResultUtil result = new ResultUtil();
		if (id == null) {
			result.error("id不能为空");
			return result;
		}
		Map<String, Object> param = new HashMap<String, Object>(1);
		param.put("dataId", id);
		delete(DeleteId.DELETE_PROPOSAL_BY_PARAM, param);
		delete(DeleteId.DELETE_DATAINFO_BY_ID, id);
		return result;
	}

	
}
