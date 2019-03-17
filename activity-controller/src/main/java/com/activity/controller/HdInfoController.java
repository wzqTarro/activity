package com.activity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.activity.bean.Hdinfo;
import com.activity.result.ControllerResult;
import com.activity.service.IHdInfoService;
import com.activity.service.result.ObjectResult;
import com.activity.service.result.PageResult;
import com.activity.util.ResultUtil;
import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/hdinfo")
@Api(tags = "活动信息")
public class HdInfoController {

	@Autowired
	private IHdInfoService hdInfoService;
	
	@RequestMapping(value = "/getHdInfo", method = RequestMethod.GET)
	@ApiOperation(value = "查询活动", httpMethod = "GET") 
	public ControllerResult getHdInfo(Integer typeId, Integer jbId, String title, 
			String setDate, Integer userId, Integer unitId, Short state, Integer pageNum, Integer pageSize) {
		ControllerResult result = new ControllerResult();
		PageResult<Hdinfo> pageResult = hdInfoService.getHdinfo(typeId, jbId, title, setDate, userId, unitId, state, pageNum, pageSize);
		if (!pageResult.isSuccess()) {
			result.setRespCode(pageResult.getRespCode());
			result.setRespMsg(pageResult.getRespMsg());
			return result;
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("list", pageResult.getList());
		jsonObject.put("count", pageResult.getCount());
		result.setData(jsonObject);
		return result;
	}
	
	@RequestMapping(value="/addHdInfo", method=RequestMethod.POST)
	@ApiOperation(value="添加活动", httpMethod="POST")
	public ControllerResult addHdInfo(Hdinfo hdInfo) {
		ControllerResult result = new ControllerResult();
		ObjectResult<Hdinfo> serviceResult = hdInfoService.addHdinfo(hdInfo);
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
	
	@RequestMapping(value="/editHdInfo", method=RequestMethod.POST)
	@ApiOperation(value="编辑活动", httpMethod="POST")
	public ControllerResult editHdInfo(Hdinfo hdInfo) {
		ControllerResult result = new ControllerResult();
		ObjectResult<Hdinfo> serviceResult = hdInfoService.editHdinfo(hdInfo);
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
	
	@RequestMapping(value="/delHdInfo", method=RequestMethod.POST)
	@ApiOperation(value="删除活动", httpMethod="POST")
	public ControllerResult delHdInfo(Integer id) {
		ControllerResult result = new ControllerResult();
		ResultUtil serviceResult = hdInfoService.delHdinfo(id);
		if (!serviceResult.isSuccess()) {
			result.setRespCode(serviceResult.getRespCode());
			result.setRespMsg(serviceResult.getRespMsg());
			return result;
		}
		return result;
	}
}
