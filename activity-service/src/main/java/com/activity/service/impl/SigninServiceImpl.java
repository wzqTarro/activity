package com.activity.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.activity.bean.Signin;
import com.activity.constant.PageRecord;
import com.activity.dao.dbSql.InsertId;
import com.activity.dao.dbSql.QueryId;
import com.activity.dao.dbSql.UpdateId;
import com.activity.service.CommonService;
import com.activity.service.ISigninService;
import com.activity.service.result.ObjectResult;
import com.activity.service.result.PageResult;

/**
 * 签到
 *                       
 * @Filename SigninServiceImpl.java
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
 * <li>Date: 2019年3月3日</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 *
 */
@Service
public class SigninServiceImpl extends CommonService implements ISigninService{

	@Override
	public PageResult<Signin> getSignin(Integer userId, Integer hdId, Short type, Integer pageNum, Integer pageSize) {
		PageResult<Signin> result = new PageResult<>();
		Map<String, Object> param = new HashMap<>(7);
		if (userId != null) {
			param.put("userId", userId);
		}
		if (hdId != null) {
			param.put("hdId", hdId);
		}
		if (type != null) {
			param.put("type", type);
		}
		PageRecord<Signin> page = queryPageByObject(QueryId.COUNT_SIGNIN_BY_PARAM, QueryId.SELECT_SIGNIN_BY_PARAM, param, pageNum, pageSize);
		result.setCount(page.getPageTotal());
		result.setList(page.getList());
		return result;
	}

	@Override
	public ObjectResult<Signin> addSignin(Signin signin) {
		ObjectResult<Signin> result = new ObjectResult<Signin>();
		if (signin == null) {
			result.error("签到不能为空");
			return result;
		}
		signin.setSetdate(new Date());
		signin.setType((short) 0);
		insert(InsertId.INSERT_SIGNIN, signin);
		result.setData(signin);
		return result;
	}

	@Override
	public ObjectResult<Signin> editSignin(Signin signin) {
		ObjectResult<Signin> result = new ObjectResult<Signin>();
		if (signin != null) {
			if (signin.getId() == null) {
				result.error("id不能为空");
			}
			signin.setType((short) 1);
			update(UpdateId.UPDATE_SIGNIN, signin);
			result.setData(signin);
		}
		return result;
	}

}
