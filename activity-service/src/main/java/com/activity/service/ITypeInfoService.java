package com.activity.service;

import com.activity.bean.Typeinfo;
import com.activity.service.result.ListResult;
import com.activity.service.result.ObjectResult;
import com.activity.util.ResultUtil;

public interface ITypeInfoService {
	/**
	 * 获取活动类型列表
	 * <p>
	 * 应用领域：
	 * </p>
	 *
	 * @param pid
	 * @return
	 * @author wangziqin by 2019年3月2日 下午5:19:14
	 */
	ListResult<Typeinfo> getTypeInfo(Integer pid);
	
	/**
	 * 
	 * <p>
	 * 应用领域：
	 * </p>
	 *
	 * @param typeInfo
	 * @return
	 * @author wangziqin by 2019年3月2日 下午5:20:14
	 */
	ObjectResult<Typeinfo> addTypeInfo(Typeinfo typeInfo);
	
	ObjectResult<Typeinfo> editTypeInfo(Typeinfo typeInfo);
	
	ResultUtil delTypeInfo(Integer pid);
}
