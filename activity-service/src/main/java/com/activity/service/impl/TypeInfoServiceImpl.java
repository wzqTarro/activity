package com.activity.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.activity.bean.Typeinfo;
import com.activity.dao.dbSql.InsertId;
import com.activity.dao.dbSql.QueryId;
import com.activity.dao.dbSql.UpdateId;
import com.activity.service.CommonService;
import com.activity.service.ITypeInfoService;
import com.activity.service.result.ListResult;
import com.activity.service.result.ObjectResult;
import com.activity.util.ResultUtil;

/**
 * 活动类型
 *                       
 * @Filename TypeInfoServiceImpl.java
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
public class TypeInfoServiceImpl extends CommonService implements ITypeInfoService{

	@Override
	public ListResult<Typeinfo> getTypeInfo(Integer pid) {
		ListResult<Typeinfo> result = new ListResult<Typeinfo>();
		Map<String, Object> param = new HashMap<>(1);
		if (pid != null) {
			param.put("pid", pid);
		}
		List<Typeinfo> list = queryListByObject(QueryId.SELECT_TYEPINFO_BY_PARAM, param);
		result.setList(list);
		return result;
	}

	@Override
	public ObjectResult<Typeinfo> addTypeInfo(Typeinfo typeInfo) {
		ObjectResult<Typeinfo> result = new ObjectResult<Typeinfo>();
		if (typeInfo == null) {
			result.error("活动类型不能为空");
			return result;
		}
		insert(InsertId.INSERT_TYPEINFO, typeInfo);
		return result;
	}

	@Override
	public ObjectResult<Typeinfo> editTypeInfo(Typeinfo typeInfo) {
		ObjectResult<Typeinfo> result = new ObjectResult<>();
		Integer id = typeInfo.getId();
		if (id == null || id.compareTo(new Integer(0)) == 0) {
			result.error("id不能为空");
			return result;
		}
		update(UpdateId.UPDATE_TYPEINFO, typeInfo);
		result.setData(typeInfo);
		return result;
	}

	@Override
	public ResultUtil delTypeInfo(Integer pid) {
		ResultUtil result = new ResultUtil();
		Map<String, Object> param = new HashMap<>(1);
		param.put("pid", pid);
		List<Typeinfo> list = queryListByObject(QueryId.SELECT_TYEPINFO_BY_PARAM, param);
		if (!CollectionUtils.isEmpty(list)) {
			result.error("请先删除下级活动类型");
			return result;
		}
		return result;
	}

}
