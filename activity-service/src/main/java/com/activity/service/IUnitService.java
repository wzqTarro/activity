package com.activity.service;

import com.activity.bean.Unit;
import com.activity.service.result.ListResult;
import com.activity.util.ResultUtil;

public interface IUnitService {
	/**
	 * 根据id获取单位列表
	 * <p>
	 * 应用领域：
	 * </p>
	 *
	 * @param id
	 * @return
	 * @author wangziqin by 2019年2月28日 下午8:52:15
	 */
	ListResult<Unit> getUnitByPid(Integer pid);
	/**
	 * 添加单位
	 * <p>
	 * 应用领域：
	 * </p>
	 *
	 * @param unit
	 * @return
	 * @author wangziqin by 2019年2月28日 下午8:53:16
	 */
	ResultUtil addUnit(Unit unit);
	/**
	 * 编辑单位
	 * <p>
	 * 应用领域：
	 * </p>
	 *
	 * @param unit
	 * @return
	 * @author wangziqin by 2019年2月28日 下午8:53:31
	 */
	ResultUtil editUnit(Unit unit);
	/**
	 * 删除单位
	 * <p>
	 * 应用领域：
	 * </p>
	 *
	 * @param id
	 * @return
	 * @author wangziqin by 2019年2月28日 下午8:53:42
	 */
	ResultUtil delUnit(Integer id);
}
