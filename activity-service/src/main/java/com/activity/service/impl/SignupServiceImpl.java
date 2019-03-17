package com.activity.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.activity.bean.Signup;
import com.activity.constant.PageRecord;
import com.activity.dao.dbSql.DeleteId;
import com.activity.dao.dbSql.InsertId;
import com.activity.dao.dbSql.QueryId;
import com.activity.dao.dbSql.UpdateId;
import com.activity.service.CommonService;
import com.activity.service.ISignupService;
import com.activity.service.result.ObjectResult;
import com.activity.service.result.PageResult;
import com.activity.util.ResultUtil;

@Service
public class SignupServiceImpl extends CommonService implements ISignupService{

	@Override
	public PageResult<Signup> getSignup(Integer userId, Integer hdId, String setDate, Integer pageNum, Integer pageSize) {
		PageResult<Signup> result = new PageResult<>();
		Map<String, Object> param = new HashMap<>(3);
		if (StringUtils.isNoneEmpty(setDate)) {
			param.put("setDate", setDate);
		}
		if (userId != null) {
			param.put("userId", userId);
		}
		if (hdId != null) {
			param.put("hdId", hdId);
		}
		PageRecord<Signup> page = queryPageByObject(QueryId.COUNT_SIGNUP_BY_PARAM, QueryId.SELECT_SIGNUP_BY_PARAM, param, pageNum, pageSize);
		result.setCount(page.getPageTotal());
		result.setList(page.getList());
		return result;
	}

	@Override
	public ObjectResult<Signup> addSignup(Signup signup) {
		ObjectResult<Signup> result = new ObjectResult<Signup>();
		if (signup == null) {
			result.error("报名信息不能为空");
			return result;
		}
		signup.setSetdate(new Date());
		insert(InsertId.INSERT_SIGNUP, signup);
		result.setData(signup);
		return result;
	}

	@Override
	public ObjectResult<Signup> editSignup(Signup signup) {
		ObjectResult<Signup> result = new ObjectResult<Signup>();
		if (signup != null) {
			if (signup.getId() == null) {
				result.error("id不能为空");
			}
			update(UpdateId.UPDATE_SIGNUP, signup);
			result.setData(signup);
		}
		return result;
	}

	@Override
	public ResultUtil delSignup(Integer id) {
		ResultUtil result = new ResultUtil();
		if (id == null) {
			result.error("id不能为空");
		}
		delete(DeleteId.DELETE_SIGNUP_BY_ID, id);
		return result;
	}

}
