package com.activity.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.activity.constant.PageRecord;
import com.activity.dao.CommonDao;

public class CommonService{
	
	@Autowired
	private CommonDao dao;
	
	
	public <T> List<T> queryListByObject(String statement, Object param) {
		return dao.queryListByObject(statement, param);
	}
	
	public <T> PageRecord<T> queryPageByObject(String countStatement, String listStatement, Map<String, Object> param,
			Integer pageNum, Integer pageSize){
		if (pageNum != null && pageSize != null && pageNum > 0 && pageSize > 0) {
			param.put("pageNum", (pageNum - 1) * pageSize);
			param.put("pageSize", pageSize);
		}
		PageRecord<T> page = new PageRecord<>();
		page.setList(dao.queryListByObject(listStatement, param));
		page.setPageTotal(dao.queryCountByObject(countStatement, param));
		return page;
	}
	
	public int queryCountByObject(String statement, Object param) {
		return dao.queryCountByObject(statement, param);
	}
	
	public int insert(String statement, Object param) {
		return dao.insert(statement, param);
	}
	
	public int update(String statement, Object param) {
		return dao.update(statement, param);
	}
	
	public int delete(String statement, Object param) {
		return dao.delete(statement, param);
	}

	public Object queryObjectByParameter(String statement, Object param) {
		return dao.queryObjectByParameter(statement, param);
	}
}
