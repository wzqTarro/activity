package com.activity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.activity.bean.Typeinfo;
import com.activity.result.ControllerResult;
import com.activity.service.ITypeInfoService;
import com.activity.service.result.ListResult;
import com.activity.service.result.ObjectResult;
import com.activity.util.ResultUtil;
import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/typeinfo")
@Api(tags = "活动类型")
public class TypeInfoController {

	@Autowired
	private ITypeInfoService typeinfoService;
	
	@RequestMapping(value="/getTyepInfo", method=RequestMethod.GET)
	@ApiOperation(value="获取活动类型", httpMethod="GET")
	public ControllerResult getTyepInfo(Integer pid) {
		ControllerResult result = new ControllerResult();
		ListResult<Typeinfo> listResult = typeinfoService.getTypeInfo(pid);
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
	
	@RequestMapping(value="/addTyepInfo", method=RequestMethod.POST)
	@ApiOperation(value="添加活动类型", httpMethod="POST")
	public ControllerResult addTyepInfo(Typeinfo typeinfo) {
		ControllerResult result = new ControllerResult();
		ObjectResult<Typeinfo> serviceResult = typeinfoService.addTypeInfo(typeinfo);
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
	
	@RequestMapping(value="/editTyepInfo", method=RequestMethod.POST)
	@ApiOperation(value="编辑活动类型", httpMethod="POST")
	public ControllerResult editTyepInfo(Typeinfo typeinfo) {
		ControllerResult result = new ControllerResult();
		ObjectResult<Typeinfo> serviceResult = typeinfoService.editTypeInfo(typeinfo);
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
	
	@RequestMapping(value="/delTyepInfo", method=RequestMethod.POST)
	@ApiOperation(value="删除活动类型", httpMethod="POST")
	public ControllerResult delTyepInfo(Integer id) {
		ControllerResult result = new ControllerResult();
		ResultUtil serviceResult = typeinfoService.delTypeInfo(id);
		if (!serviceResult.isSuccess()) {
			result.setRespCode(serviceResult.getRespCode());
			result.setRespMsg(serviceResult.getRespMsg());
			return result;
		}
		return result;
	}
}
