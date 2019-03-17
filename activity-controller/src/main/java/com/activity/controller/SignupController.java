package com.activity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.activity.bean.Signup;
import com.activity.result.ControllerResult;
import com.activity.service.ISignupService;
import com.activity.service.result.ListResult;
import com.activity.service.result.ObjectResult;
import com.activity.util.ResultUtil;
import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/signup")
@Api(tags = "报名")
public class SignupController {

	@Autowired
	private ISignupService signupService;
	
	@RequestMapping(value="/getSignup", method=RequestMethod.GET)
	@ApiOperation(value="获取报名信息", httpMethod="GET")
	public ControllerResult getSignup(Integer userId, Integer hdId, String setDate, Integer pageNum, Integer pageSize) {
		ControllerResult result = new ControllerResult();
		ListResult<Signup> listResult = signupService.getSignup(userId, hdId, setDate, pageNum, pageSize);
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
	
	@RequestMapping(value="/addSignup", method=RequestMethod.POST)
	@ApiOperation(value="添加报名信息", httpMethod="POST")
	public ControllerResult addSignup(Signup signup) {
		ControllerResult result = new ControllerResult();
		ObjectResult<Signup> serviceResult = signupService.addSignup(signup);
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
	
	@RequestMapping(value="/editSignup", method=RequestMethod.POST)
	@ApiOperation(value="编辑报名信息", httpMethod="POST")
	public ControllerResult editSignup(Signup signup) {
		ControllerResult result = new ControllerResult();
		ObjectResult<Signup> serviceResult = signupService.editSignup(signup);
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
	
	@RequestMapping(value="/delSignup", method=RequestMethod.POST)
	@ApiOperation(value="删除报名", httpMethod="POST")
	public ControllerResult delSignup(Integer id) {
		ControllerResult result = new ControllerResult();
		ResultUtil serviceResult = signupService.delSignup(id);
		if (!serviceResult.isSuccess()) {
			result.setRespCode(serviceResult.getRespCode());
			result.setRespMsg(serviceResult.getRespMsg());
			return result;
		}
		return result;
	}
}
