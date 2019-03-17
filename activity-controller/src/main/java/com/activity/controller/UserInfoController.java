package com.activity.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.activity.annotation.PassToken;
import com.activity.bean.Userinfo;
import com.activity.constant.CommonValue;
import com.activity.result.ControllerResult;
import com.activity.service.IUserService;
import com.activity.service.result.PageResult;
import com.activity.thread.CustomThreadLocal;
import com.activity.util.JwtUtil;
import com.activity.util.ResultUtil;
import com.activity.vo.UserinfoVO;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/userinfo")
@Api(tags = "用户管理")
public class UserInfoController {
	
	@Autowired
	private IUserService userService;
	
	@PassToken
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ApiOperation(value = "登陆", httpMethod = "POST")
	public ControllerResult login(String zh, String pwd) {
		ControllerResult result = new ControllerResult();
		PageResult<Userinfo> listResult = userService.getUser(null, null, zh, pwd, null, null, null);
		if (!listResult.isSuccess()) {
			result.setRespCode(result.getRespCode());
			result.setRespMsg(result.getRespMsg());
			return result;
		}
		List<Userinfo> list = listResult.getList();
		if (CollectionUtils.isEmpty(list)) {
			result.error("账号或密码错误");
		} else {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("token", JwtUtil.createToken(list.get(0).getZh(), null));
			result.setData(jsonObject);
		}
		return result;
	}
	
	@PassToken
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	@ApiOperation(value = "注销", httpMethod = "POST")
	public ControllerResult logout() {
		ControllerResult result = new ControllerResult();
		CustomThreadLocal.remove(CommonValue.CURRENT_LOGIN_INFO);
		return result;
	}

	@RequestMapping(value = "/getUserinfo", method = RequestMethod.GET)
	@ApiOperation(value = "多条件查询用户信息", httpMethod = "GET")
	public ControllerResult getUserinfo(String username, String zh, String nicheng, String dwid, Integer pageNum, Integer pageSize) {
		ControllerResult result = new ControllerResult();
		PageResult<Userinfo> listResult = userService.getUser(username, nicheng, zh, null, dwid, pageNum, pageSize);
		if (!listResult.isSuccess()) {
			result.setRespCode(listResult.getRespCode());
			result.setRespMsg(listResult.getRespMsg());
			return result;
		}
		JSONArray jsonArray = new JSONArray();
		List<Userinfo> list = listResult.getList();
		for (int i = 0; i < list.size(); i++) {
			Userinfo info = list.get(i);
			UserinfoVO vo = new UserinfoVO();
			BeanUtils.copyProperties(info, vo);
			jsonArray.add(vo);
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("list", jsonArray);
		jsonObject.put("count", listResult.getCount());
		result.setData(jsonObject);
		return result;
	}
	
	@RequestMapping(value = "/saveUserinfo", method = RequestMethod.POST)
	@ApiOperation(value = "保存用户", httpMethod = "POST")
	public ControllerResult saveUserinfo(Userinfo userinfo) {
		ControllerResult result = new ControllerResult();
		ResultUtil resultUtil = userService.saveUser(userinfo);
		if (!resultUtil.isSuccess()) {
			result.setRespCode(resultUtil.getRespCode());
			result.setRespMsg(resultUtil.getRespMsg());
			return result;
		}
		return result;
	}
	
	@RequestMapping(value = "/editUserinfo", method = RequestMethod.POST)
	@ApiOperation(value = "编辑用户信息", httpMethod = "POST")
	public ControllerResult editUserinfo(Userinfo userinfo) {
		ControllerResult result = new ControllerResult();
		ResultUtil resultUtil = userService.editUser(userinfo);
		if (!resultUtil.isSuccess()) {
			result.setRespCode(resultUtil.getRespCode());
			result.setRespMsg(resultUtil.getRespMsg());
			return result;
		}
		return result;
	}
	
	@PassToken
	@RequestMapping(value = "/addUserinfo", method = RequestMethod.POST)
	@ApiOperation(value = "添加用户信息", httpMethod = "POST")
	public ControllerResult addUserinfo(Userinfo userinfo) {
		ControllerResult result = new ControllerResult();
		ResultUtil resultUtil = userService.addUser(userinfo);
		if (!resultUtil.isSuccess()) {
			result.setRespCode(resultUtil.getRespCode());
			result.setRespMsg(resultUtil.getRespMsg());
			return result;
		}
		return result;
	}
	
	@RequestMapping(value = "/delUserinfo", method = RequestMethod.POST)
	@ApiOperation(value = "删除用户信息", httpMethod = "POST")
	public ControllerResult delUserinfo(Integer id) {
		ControllerResult result = new ControllerResult();
		ResultUtil resultUtil = userService.delUser(id);
		if (!resultUtil.isSuccess()) {
			result.setRespCode(resultUtil.getRespCode());
			result.setRespMsg(resultUtil.getRespMsg());
			return result;
		}
		return result;
	}
}
