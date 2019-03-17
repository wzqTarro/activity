package com.activity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.activity.bean.Signin;
import com.activity.result.ControllerResult;
import com.activity.service.ISigninService;
import com.activity.service.result.ListResult;
import com.activity.service.result.ObjectResult;
import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/signin")
@Api(tags = "签到")
public class SigninController {

	@Autowired
	private ISigninService signinService;
	
	@RequestMapping(value="/getSignin", method=RequestMethod.GET)
	@ApiOperation(value="获取签到情况", httpMethod="GET")
	public ControllerResult getSignin(Integer userId, Integer hdId, Short type, Integer pageNum, Integer pageSize) {
		ControllerResult result = new ControllerResult();
		ListResult<Signin> listResult = signinService.getSignin(userId, hdId, type, pageNum, pageSize);
		if (!listResult.isSuccess()) {
			result.setRespCode(listResult.getRespCode());
			result.setRespMsg(listResult.getRespMsg());
			return result;
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("list", listResult.getList());
		result.setData(jsonObject);
		return result;
	}
	
	@RequestMapping(value="/addSignin", method=RequestMethod.POST)
	@ApiOperation(value="签到", httpMethod="POST")
	public ControllerResult addSignin(Signin signin) {
		ControllerResult result = new ControllerResult();
		ObjectResult<Signin> serviceResult = signinService.addSignin(signin);
		if (!serviceResult.isSuccess()) {
			result.setRespCode(serviceResult.getRespCode());
			result.setRespMsg(serviceResult.getRespMsg());
			return result;
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", serviceResult.getData());
		result.setData(jsonObject);
		return result;
	}
	
	@RequestMapping(value="/editSignin", method=RequestMethod.POST)
	@ApiOperation(value="签退", httpMethod="POST")
	public ControllerResult editSignin(Signin signin) {
		ControllerResult result = new ControllerResult();
		ObjectResult<Signin> serviceResult = signinService.editSignin(signin);
		if (!serviceResult.isSuccess()) {
			result.setRespCode(serviceResult.getRespCode());
			result.setRespMsg(serviceResult.getRespMsg());
			return result;
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", serviceResult.getData());
		result.setData(jsonObject);
		return result;
	}
	
}
