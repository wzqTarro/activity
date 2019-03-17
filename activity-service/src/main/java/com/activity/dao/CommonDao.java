package com.activity.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.activity.constant.PageRecord;

@Repository
public class CommonDao{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public <T> List<T> queryListByObject(String statement, Object parameter) {
		return sqlSessionTemplate.selectList(statement, parameter);
	}

	public <T> PageRecord<T> queryPageByObject(String countStatement, String listStatement, Object parameter,
			int pageNum, int pageSize) {
		PageRecord<T> page = new PageRecord<>();
		page.setList(sqlSessionTemplate.selectList(listStatement, parameter));
		page.setPageTotal(sqlSessionTemplate.selectOne(countStatement, parameter));
		page.setPageNum((pageNum - 1) * pageSize);
		page.setPageSize(pageSize);
		return page;
	}

	public int queryCountByObject(String statement, Object parameter) {
		return sqlSessionTemplate.selectOne(statement, parameter);
	}

	public int insert(String statement, Object parameter) {
		return sqlSessionTemplate.insert(statement, parameter);
	}

	public int update(String statement, Object parameter) {
		return sqlSessionTemplate.update(statement, parameter);
	}

	public int delete(String statement, Object parameter) {
		return sqlSessionTemplate.delete(statement, parameter);
	}

	public Object queryObjectByParameter(String statement, Object parameter) {
		return sqlSessionTemplate.selectOne(statement, parameter);
	}
}
