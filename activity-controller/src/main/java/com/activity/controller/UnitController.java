package com.activity.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.activity.bean.Unit;
import com.activity.result.ControllerResult;
import com.activity.service.IUnitService;
import com.activity.service.result.ListResult;
import com.activity.util.ResultUtil;
import com.activity.vo.UnitVO;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation; 

@RestController
@RequestMapping("/unit")
@Api(tags = "单位管理")
public class UnitController {

	@Autowired
	private IUnitService unitService;

	@RequestMapping(value = "/getUnit", method = RequestMethod.GET)
	@ApiOperation(value = "查询单位列表", httpMethod = "GET") 
	public ControllerResult getUnit(Integer pid){
		ControllerResult result = new ControllerResult();
		ListResult<Unit> listResult = unitService.getUnitByPid(pid);
		if (!listResult.isSuccess()) {
			result.setRespCode(listResult.getRespCode());
			result.setRespMsg(listResult.getRespMsg());
			return result;
		}
		JSONArray array = new JSONArray();
		List<Unit> list = listResult.getList();
		for (int i = 0; i < list.size(); i++) {
			UnitVO vo = new UnitVO();
			BeanUtils.copyProperties(list.get(i), vo);
			array.add(vo);
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("list", array);
		result.setData(jsonObject);
		return result;
	}
	
	@RequestMapping(value = "/addUnit", method = RequestMethod.POST)
	@ApiOperation(value = "添加单位", httpMethod = "POST") 
	public ControllerResult addUnit(Unit unit){
		ControllerResult result = new ControllerResult();
		ResultUtil resultUtil = unitService.addUnit(unit);
		if (!resultUtil.isSuccess()) {
			result.setRespCode(resultUtil.getRespCode());
			result.setRespMsg(resultUtil.getRespMsg());
			return result;
		}
		return result;
	}
	
	@RequestMapping(value = "/editUnit", method = RequestMethod.POST)
	@ApiOperation(value = "编辑单位", httpMethod = "POST") 
	public ControllerResult editUnit(Unit unit){
		ControllerResult result = new ControllerResult();
		ResultUtil resultUtil = unitService.editUnit(unit);
		if (!resultUtil.isSuccess()) {
			result.setRespCode(resultUtil.getRespCode());
			result.setRespMsg(resultUtil.getRespMsg());
			return result;
		}
		return result;
	}
	
	@RequestMapping(value = "/delUnit", method = RequestMethod.POST)
	@ApiOperation(value = "删除单位", httpMethod = "POST") 
	public ControllerResult delUnit(Integer id){
		ControllerResult result = new ControllerResult();
		ResultUtil resultUtil = unitService.delUnit(id);
		if (!resultUtil.isSuccess()) {
			result.setRespCode(resultUtil.getRespCode());
			result.setRespMsg(resultUtil.getRespMsg());
			return result;
		}
		return result;
	}
}
