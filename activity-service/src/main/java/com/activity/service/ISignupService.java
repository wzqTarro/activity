package com.activity.service;

import com.activity.bean.Signup;
import com.activity.service.result.ObjectResult;
import com.activity.service.result.PageResult;
import com.activity.util.ResultUtil;

public interface ISignupService {

	PageResult<Signup> getSignup(Integer userId, Integer hdId, String setDate, Integer pageNum, Integer pageSize);
	
	ObjectResult<Signup> addSignup(Signup signup);
	
	ObjectResult<Signup> editSignup(Signup signup);
	
	ResultUtil delSignup(Integer id);
}
