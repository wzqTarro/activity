package com.activity.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.activity.bean.Userinfo;
import com.activity.constant.CommonValue;
import com.activity.constant.PageRecord;
import com.activity.dao.dbSql.DeleteId;
import com.activity.dao.dbSql.InsertId;
import com.activity.dao.dbSql.QueryId;
import com.activity.dao.dbSql.UpdateId;
import com.activity.service.CommonService;
import com.activity.service.IUserService;
import com.activity.service.result.ObjectResult;
import com.activity.service.result.PageResult;
import com.activity.thread.CustomThreadLocal;
import com.activity.util.Md5Util;
import com.activity.util.ResultUtil;
import com.activity.util.ValidateUtil;

@Service
public class UserServiceImpl extends CommonService implements IUserService{

	@Override
	public PageResult<Userinfo> getUser(String username, String nicheng, String zh, String password, String dwid, Integer pageNum, Integer pageSize) {
		PageResult<Userinfo> result = new PageResult<>();
		Map<String, Object> param = new HashMap<>(4);
		if (StringUtils.isNoneBlank(username)) {
			param.put("username", username);
		}
		if (StringUtils.isNoneBlank(nicheng)) {
			param.put("nicheng", nicheng);
		}
		if (StringUtils.isNoneBlank(zh)) {
			param.put("zh", zh);
		}
		if (StringUtils.isNoneBlank(dwid)) {
			param.put("dwid", dwid);
		}
		if (StringUtils.isNoneBlank(password)) {
			password = Md5Util.generateMd5(password, CommonValue.LOGIN_SECRET);
			param.put("pwd", password);
		}
		PageRecord<Userinfo> page = queryPageByObject(QueryId.COUNT_USERINFO_BY_PARAM, QueryId.SELECT_USERINFO_BY_PARAM, param, pageNum, pageSize);
		result.setList(page.getList());
		result.setCount(page.getPageTotal());
		return result;
	}

	@Override
	public ResultUtil addUser(Userinfo userinfo) {
		ResultUtil result = new ResultUtil();
		if (userinfo == null) {
			result.error("用户信息不能为空");
			return result;
		}
		String zh = userinfo.getZh();
		String password = userinfo.getPwd();
		if (ValidateUtil.isEmpty(zh, password)) {
			result.error("账号、密码不能为空");
			return result;
		}

		// 判断账号是否存在
		Map<String, Object> param = new HashMap<String, Object>(1);
		param.put("zh", zh);
		Userinfo existsInfo = (Userinfo) queryObjectByParameter(QueryId.SELECT_USERINFO_BY_PARAM, param);
		if (existsInfo != null) {
			result.error("账号已存在");
			return result;
		}

		// 密码加密
		if (StringUtils.isNoneBlank(password)) {
			userinfo.setPwd(Md5Util.generateMd5(password, CommonValue.LOGIN_SECRET));
		}
		
		// 注册时间
		userinfo.setSetdate(new Date());
		insert(InsertId.INSERT_USERINFO, userinfo);
		return result;
	}

	@Override
	public ResultUtil editUser(Userinfo userinfo) {
		ResultUtil result = new ResultUtil();
		if (userinfo != null) {
			Integer id = userinfo.getId();
			if (id == null || new Integer(0).compareTo(id) == 0) {
				result.error("id不能为空");
				return result;
			}
			update(UpdateId.UPDATE_USERINFO, userinfo);
		}
		return result;
	}

	@Override
	public ResultUtil delUser(Integer id) {
		ResultUtil result = new ResultUtil();
		if (id == null || new Integer(0).compareTo(id) == 0) {
			result.error("id不能为空");
			return result;
		}
		delete(DeleteId.DELETE_USERINFO_BY_ID, id);
		return result;
	}

	@Override
	public ObjectResult<Userinfo> saveUser(Userinfo userinfo) {
		ObjectResult<Userinfo> result = new ObjectResult<>();
		if (userinfo == null) {
			result.error("用户信息不能为空");
		}
		Integer id = userinfo.getId();
		if (id != null) {
			editUser(userinfo);
		} else {
			addUser(userinfo);
		}
		result.setData(userinfo);
		return result;
	}

	@Override
	public Userinfo getCurrentLoginInfo() {
		Userinfo userInfo = (Userinfo)CustomThreadLocal.get(CommonValue.CURRENT_LOGIN_INFO);
		return userInfo;
	}
	
}
