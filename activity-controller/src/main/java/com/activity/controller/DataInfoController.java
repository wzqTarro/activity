package com.activity.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.activity.bean.Datainfo;
import com.activity.result.ControllerResult;
import com.activity.service.IDataInfoService;
import com.activity.service.result.ObjectResult;
import com.activity.service.result.PageResult;
import com.activity.util.ResultUtil;
import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/dataInfo")
@Api(tags = "资源")
public class DataInfoController {
	
	@Autowired
	private IDataInfoService dataInfoService;
	
	@RequestMapping(value = "/getDatainfoByParam", method = RequestMethod.GET)
	@ApiOperation(value = "查询资源", httpMethod = "GET") 
	public ControllerResult getDatainfoByParam(String fileName, String dataType, String setDate, 
			String title, Integer userId, Integer hdId, Integer pageNum, Integer pageSize) {
		ControllerResult result = new ControllerResult();
		PageResult<Datainfo> pageResult = dataInfoService.getDatainfoByParam(fileName, dataType, setDate, title, userId, hdId, pageNum, pageSize);
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
	
	@RequestMapping(value="/addDataInfo", method=RequestMethod.POST)
	@ApiOperation(value="添加资源", httpMethod="POST")
	public ControllerResult addDataInfo(Datainfo dataInfo, MultipartFile file, HttpServletRequest request) {
		ControllerResult result = new ControllerResult();
		String path = request.getContextPath();
		ObjectResult<Datainfo> serviceResult = dataInfoService.addDatainfo(dataInfo, file, path);
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
	
	@RequestMapping(value="/editDataInfo", method=RequestMethod.POST)
	@ApiOperation(value="编辑资源", httpMethod="POST")
	public ControllerResult editDataInfo(Datainfo datainfo, MultipartFile file, HttpServletRequest request) {
		ControllerResult result = new ControllerResult();
		String path = request.getContextPath();
		ObjectResult<Datainfo> serviceResult = dataInfoService.editDatainfo(datainfo, file, path);
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
	
	@RequestMapping(value="/delDataInfo", method=RequestMethod.POST)
	@ApiOperation(value="删除资源", httpMethod="POST")
	public ControllerResult delDataInfo(Integer id) {
		ControllerResult result = new ControllerResult();
		ResultUtil serviceResult = dataInfoService.delDatainfo(id);
		if (!serviceResult.isSuccess()) {
			result.setRespCode(serviceResult.getRespCode());
			result.setRespMsg(serviceResult.getRespMsg());
			return result;
		}
		return result;
	}
}
