package com.activity.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.activity.bean.Hdinfo;
import com.activity.constant.PageRecord;
import com.activity.dao.dbSql.DeleteId;
import com.activity.dao.dbSql.InsertId;
import com.activity.dao.dbSql.QueryId;
import com.activity.dao.dbSql.UpdateId;
import com.activity.service.CommonService;
import com.activity.service.IHdInfoService;
import com.activity.service.result.ObjectResult;
import com.activity.service.result.PageResult;
import com.activity.util.ResultUtil;

/**
 * 活动信息
 *                       
 * @Filename HdInfoServiceImpl.java
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
public class HdInfoServiceImpl extends CommonService implements IHdInfoService{

	@Override
	public PageResult<Hdinfo> getHdinfo(Integer typeId, Integer jbId, String title, String setDate, Integer userId,
			Integer unitId, Short state, Integer pageNum, Integer pageSize) {
		PageResult<Hdinfo> result = new PageResult<>();
		Map<String, Object> param = new HashMap<>(7);
		if (StringUtils.isNoneEmpty(title)) {
			param.put("title", title);
		}
		if (typeId != null) {
			param.put("tyepId", typeId);
		}
		if (jbId != null) {
			param.put("jbId", jbId);
		}
		if (StringUtils.isNoneEmpty(setDate)) {
			param.put("setDate", setDate);
		}
		if (userId != null) {
			param.put("userId", userId);
		}
		if (unitId != null) {
			param.put("unitId", unitId);
		}
		if (state != null) {
			param.put("state", state);
		}
		PageRecord<Hdinfo> page = queryPageByObject(QueryId.COUNT_HDINFO_BY_PARAM, QueryId.SELECT_HDINFO_BY_PARAM, param, pageNum, pageSize);
		result.setCount(page.getPageTotal());
		result.setList(page.getList());
		return result;
	}

	@Override
	public ObjectResult<Hdinfo> addHdinfo(Hdinfo hdInfo) {
		ObjectResult<Hdinfo> result = new ObjectResult<Hdinfo>();
		if (hdInfo == null) {
			result.error("活动信息不能为空");
			return result;
		}
		hdInfo.setSetdate(new Date());
		insert(InsertId.INSERT_HDINFO, hdInfo);
		result.setData(hdInfo);
		return result;
	}

	@Override
	public ObjectResult<Hdinfo> editHdinfo(Hdinfo hdInfo) {
		ObjectResult<Hdinfo> result = new ObjectResult<Hdinfo>();
		if (hdInfo != null) {
			if (hdInfo.getId() == null) {
				result.error("id不能为空");
			}
			update(UpdateId.UPDATE_HDINFO, hdInfo);	
		}
		return result;
	}

	@Override
	public ResultUtil delHdinfo(Integer id) {
		ResultUtil result = new ResultUtil();
		if (id == null) {
			result.error("id不能为空");
		}
		Map<String, Object> param = new HashMap<String, Object>(1);
		param.put("hdId", id);
		delete(DeleteId.DELETE_PROPOSAL_BY_PARAM, param);
		delete(DeleteId.DELETE_DATAINFO_BY_PARAM, param);
		delete(DeleteId.DELETE_HDINFO_BY_ID, id);
		
		return result;
	}

}
