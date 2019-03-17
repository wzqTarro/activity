package com.activity.service;

import com.activity.bean.Proposal;
import com.activity.service.result.ObjectResult;
import com.activity.service.result.PageResult;
import com.activity.util.ResultUtil;

public interface IProposalService {
	PageResult<Proposal> getProposal(Integer hdId, Integer dataId, String setDate, Integer pid, Integer pageNum, Integer pageSize);
	ObjectResult<Proposal> addProposal(Proposal proposal);
	ObjectResult<Proposal> editProposal(Proposal proposal);
	ResultUtil delProposal(Integer id);
}
