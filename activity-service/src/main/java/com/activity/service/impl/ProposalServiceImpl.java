package com.activity.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.activity.bean.Proposal;
import com.activity.constant.PageRecord;
import com.activity.dao.dbSql.DeleteId;
import com.activity.dao.dbSql.InsertId;
import com.activity.dao.dbSql.QueryId;
import com.activity.dao.dbSql.UpdateId;
import com.activity.service.CommonService;
import com.activity.service.IProposalService;
import com.activity.service.result.ObjectResult;
import com.activity.service.result.PageResult;
import com.activity.util.ResultUtil;

/**
 * 评论
 *                       
 * @Filename ProposalServiceImpl.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author wangziqin
 *
 * @Email wangziqin@zcareze.com
 *       
 * @History
 * <li>Author: wangziqin</li>
 * <li>Date: 2019年3月3日</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 *
 */
@Service
public class ProposalServiceImpl extends CommonService implements IProposalService{

	@Override
	public PageResult<Proposal> getProposal(Integer hdId, Integer dataId, String setDate, Integer pid, Integer pageNum,
			Integer pageSize) {
		PageResult<Proposal> result = new PageResult<Proposal>();
		Map<String, Object> param = new HashMap<>();
		if (hdId != null) {
			param.put("hdId", hdId);
		}
		if (dataId != null) {
			param.put("dataId", dataId);
		}
		if (StringUtils.isNoneEmpty(setDate)) {
			param.put("setDate", setDate);
		}
		if (pid != null) {
			param.put("pId", pid);
		}
		PageRecord<Proposal> page = queryPageByObject(QueryId.COUNT_PROPOSAL_BY_PARAM, QueryId.SELECT_PROPOSAL_BY_PARAM, param, pageNum, pageSize);
		result.setCount(page.getPageTotal());
		result.setList(page.getList());
		return result;
	}

	@Override
	public ObjectResult<Proposal> addProposal(Proposal proposal) {
		ObjectResult<Proposal> result = new ObjectResult<Proposal>();
		if (proposal == null) {
			result.error("评论不能为空");
			return result;
		}
		insert(InsertId.INSERT_PROPOSAL, proposal);
		result.setData(proposal);
		return result;
	}

	@Override
	public ObjectResult<Proposal> editProposal(Proposal proposal) {
		ObjectResult<Proposal> result = new ObjectResult<Proposal>();
		if (proposal != null) {
			if (proposal.getId() == null) {
				result.error("评论ID不能为空");
				return result;
			}
			update(UpdateId.UPDATE_PROPOSAL, proposal);
			result.setData(proposal);
		}
		return result;
	}

	@Override
	public ResultUtil delProposal(Integer id) {
		ResultUtil result = new ResultUtil();
		if (id == null) {
			result.error("评论ID不能为空");
			return result;
		}
		delete(DeleteId.DELETE_PROPASAL_BY_ID, id);
		return result;
	}

}
