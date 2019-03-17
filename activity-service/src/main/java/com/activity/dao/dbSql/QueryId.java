package com.activity.dao.dbSql;

public class QueryId {
	
	/** 
	 * 用户信息
	 */
	public static final String SELECT_USERINFO_BY_ID = "UserinfoMapper.selectByPrimaryKey";
	public static final String SELECT_USERINFO_BY_PARAM = "UserinfoMapper.selectByParam";
	public static final String COUNT_USERINFO_BY_PARAM = "UserinfoMapper.countByParam";
	
	/**
	 * 单位 
	 */
	public static final String SELECT_UNIT_BY_ID = "UnitMapper.selectByPrimaryKey";
	public static final String SELECT_UNIT_BY_PARAM = "UnitMapper.selectByParam";

	/**
	 * 活动类型
	 */
	public static final String SELECT_TYEPINFO_BY_ID = "TypeinfoMapper.selectByPrimaryKey";
	public static final String SELECT_TYEPINFO_BY_PARAM = "TypeinfoMapper.selectByParam";
	
	/**
	 * 活动信息
	 */
	public static final String SELECT_HDINFO_BY_ID = "HdinfoMapper.selectByPrimaryKey";
	public static final String SELECT_HDINFO_BY_PARAM = "HdinfoMapper.selectByParam";
	public static final String COUNT_HDINFO_BY_PARAM = "HdinfoMapper.countByParam";
	
	/**
	 * 资源
	 */
	public static final String SELECT_DATAINFO_BY_ID = "DatainfoMapper.selectByPrimaryKey";
	public static final String SELECT_DATAINFO_BY_PARAM = "DatainfoMapper.selectByParam";
	public static final String COUNT_DATAINFO_BY_PARAM = "DatainfoMapper.countByParam";
	
	/**
	 * 评论
	 */
	public static final String SELECT_PROPOSAL_BY_ID = "ProposalMapper.selectByPrimaryKey";
	public static final String SELECT_PROPOSAL_BY_PARAM = "ProposalMapper.selectByParam";
	public static final String COUNT_PROPOSAL_BY_PARAM = "ProposalMapper.countByParam";
	
	/**
	 * 签到
	 */
	public static final String SELECT_SIGNIN_BY_ID = "SigninMapper.selectByPrimaryKey";
	public static final String SELECT_SIGNIN_BY_PARAM = "SigninMapper.selectByParam";
	public static final String COUNT_SIGNIN_BY_PARAM = "SigninMapper.countByParam";
	
	/**
	 * 报名
	 */
	public static final String SELECT_SIGNUP_BY_ID = "SignupMapper.selectByPrimaryKey";
	public static final String SELECT_SIGNUP_BY_PARAM = "SignupMapper.selectByParam";
	public static final String COUNT_SIGNUP_BY_PARAM = "SignupMapper.countByParam";
}
