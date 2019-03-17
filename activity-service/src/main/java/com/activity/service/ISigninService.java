package com.activity.service;

import com.activity.bean.Signin;
import com.activity.service.result.ObjectResult;
import com.activity.service.result.PageResult;

public interface ISigninService {
	PageResult<Signin> getSignin(Integer userId, Integer hdId, Short type, Integer pageNum, Integer pageSize);
	ObjectResult<Signin> addSignin(Signin signin);
	ObjectResult<Signin> editSignin(Signin signin);
}
