package com.activity.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.activity.bean.Unit;
import com.activity.dao.dbSql.DeleteId;
import com.activity.dao.dbSql.InsertId;
import com.activity.dao.dbSql.QueryId;
import com.activity.dao.dbSql.UpdateId;
import com.activity.service.CommonService;
import com.activity.service.IUnitService;
import com.activity.service.result.ListResult;
import com.activity.util.ResultUtil;

/**
 * 单位管理
 *                       
 * @Filename UnitServiceImpl.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author wangziqin
 *
 * @Email 
 *       
 * @History
 * <li>Author: wangziqin</li>
 * <li>Date: 2019年2月28日</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 *
 */
@Service
public class UnitServiceImpl extends CommonService implements IUnitService{

	@Override
	public ListResult<Unit> getUnitByPid(Integer pid) {
		ListResult<Unit> result = new ListResult<>();
		Map<String, Object> param = new HashMap<>(1);
		if (pid != null) {
			param.put("pid", pid);
		}
		List<Unit> list = queryListByObject(QueryId.SELECT_UNIT_BY_PARAM, param);
		result.setList(list);
		return result;
	}

	@Override
	public ResultUtil addUnit(Unit unit) {
		ResultUtil result = new ResultUtil();
		if (unit == null) {
			result.error("单位信息不能为空");
		}
		insert(InsertId.INSERT_UNIT, unit);
		return result;
	}

	@Override
	public ResultUtil editUnit(Unit unit) {
		ResultUtil result = new ResultUtil();
		if (unit != null) {
			Integer id = unit.getId();
			if (id == null || new Integer(0).compareTo(id) == 0) {
				result.error("id不能为空");
			}
			update(UpdateId.UPDATE_UNIT, unit);
		}
		return result;
	}

	@Override
	public ResultUtil delUnit(Integer id) {
		ResultUtil result = new ResultUtil();
		if (id == null || new Integer(0).compareTo(id) == 0) {
			result.error("id不能为空");
		}
		Map<String, Object> param = new HashMap<String, Object>(1);
		List<Unit> list = queryListByObject(QueryId.SELECT_UNIT_BY_PARAM, param);
		if (!CollectionUtils.isEmpty(list)) {
			result.error("请先删除下级单位");
			return result;
		}
		delete(DeleteId.DELETE_UNIT_BY_ID, id);
		return result;
	}

}
