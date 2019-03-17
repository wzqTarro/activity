package com.activity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.activity.bean.Proposal;
import com.activity.result.ControllerResult;
import com.activity.service.IProposalService;
import com.activity.service.result.ObjectResult;
import com.activity.service.result.PageResult;
import com.activity.util.ResultUtil;
import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/proposal")
@Api(tags = "评论")
public class ProposalController {

	@Autowired
	private IProposalService proposalService;
	
	@RequestMapping(value = "/getProposalByParam", method = RequestMethod.GET)
	@ApiOperation(value = "查询评论", httpMethod = "GET") 
	public ControllerResult getProposalByParam(Integer hdId, Integer dataId, String setDate, Integer pid, 
			Integer pageNum, Integer pageSize) {
		ControllerResult result = new ControllerResult();
		PageResult<Proposal> pageResult = proposalService.getProposal(hdId, dataId, setDate, pid, pageNum, pageSize);
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
	
	@RequestMapping(value="/addProposal", method=RequestMethod.POST)
	@ApiOperation(value="添加评论", httpMethod="POST")
	public ControllerResult addProposal(Proposal proposal) {
		ControllerResult result = new ControllerResult();
		ObjectResult<Proposal> serviceResult = proposalService.addProposal(proposal);
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
	
	@RequestMapping(value="/editProposal", method=RequestMethod.POST)
	@ApiOperation(value="编辑评论", httpMethod="POST")
	public ControllerResult editProposal(Proposal proposal) {
		ControllerResult result = new ControllerResult();
		ObjectResult<Proposal> serviceResult = proposalService.editProposal(proposal);
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
	
	@RequestMapping(value="/delProposal", method=RequestMethod.POST)
	@ApiOperation(value="删除评论", httpMethod="POST")
	public ControllerResult delProposal(Integer id) {
		ControllerResult result = new ControllerResult();
		ResultUtil serviceResult = proposalService.delProposal(id);
		if (!serviceResult.isSuccess()) {
			result.setRespCode(serviceResult.getRespCode());
			result.setRespMsg(serviceResult.getRespMsg());
			return result;
		}
		return result;
	}
}
