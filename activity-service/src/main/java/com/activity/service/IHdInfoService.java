package com.activity.service;

import com.activity.bean.Hdinfo;
import com.activity.service.result.ObjectResult;
import com.activity.service.result.PageResult;
import com.activity.util.ResultUtil;

public interface IHdInfoService {
	/**
	 * 查询
	 * <p>
	 * 应用领域：
	 * </p>
	 *
	 * @param typeId
	 * @param jbId
	 * @param title
	 * @param setDate
	 * @param userId
	 * @param unitId
	 * @param state
	 * @return
	 * @author wangziqin by 2019年3月2日 下午6:16:23
	 */
	PageResult<Hdinfo> getHdinfo(Integer typeId, Integer jbId, String title, 
			String setDate, Integer userId, Integer unitId, Short state, Integer pageNum, Integer pageSize);
	ObjectResult<Hdinfo> addHdinfo(Hdinfo hdInfo);
	ObjectResult<Hdinfo> editHdinfo(Hdinfo hdInfo);
	ResultUtil delHdinfo(Integer id);
}
