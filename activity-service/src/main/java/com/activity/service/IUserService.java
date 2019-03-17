package com.activity.service;

import com.activity.bean.Userinfo;
import com.activity.service.result.ObjectResult;
import com.activity.service.result.PageResult;
import com.activity.util.ResultUtil;

public interface IUserService {
	
	Userinfo getCurrentLoginInfo();

	/**
	 * 获取用户信息
	 * <p>
	 * 应用领域：
	 * </p>
	 *
	 * @param username
	 * @param nicheng
	 * @param zh
	 * @param dwid
	 * @return
	 * @author wangziqin by 2019年2月28日 下午4:10:49
	 */
	PageResult<Userinfo> getUser(String username, String nicheng, String zh, String password, String dwid, Integer pageNum, Integer pageSize);
	
	/**
	 * 添加用户
	 * <p>
	 * 应用领域：
	 * </p>
	 *
	 * @param user
	 * @return
	 * @author wangziqin by 2019年2月28日 下午4:11:19
	 */
	ResultUtil addUser(Userinfo userinfo);
	
	/**
	 * 编辑用户
	 * <p>
	 * 应用领域：
	 * </p>
	 *
	 * @param userinfo
	 * @return
	 * @author wangziqin by 2019年2月28日 下午4:12:57
	 */
	ResultUtil editUser(Userinfo userinfo);
	
	/**
	 * 保存用户信息
	 * <p>
	 * 应用领域：
	 * </p>
	 *
	 * @param userinfo
	 * @return
	 * @author wangziqin by 2019年3月1日 下午5:23:49
	 */
	ObjectResult<Userinfo> saveUser(Userinfo userinfo);
	
	/**
	 * 删除用户
	 * <p>
	 * 应用领域：
	 * </p>
	 *
	 * @param id
	 * @return
	 * @author wangziqin by 2019年2月28日 下午4:14:11
	 */
	ResultUtil delUser(Integer id);
}
