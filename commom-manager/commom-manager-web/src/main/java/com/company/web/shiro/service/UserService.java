package com.company.web.shiro.service;


import com.company.web.shiro.dao.ShiroMerchantResourceDao;
import com.company.web.shiro.dao.ShiroRoleDao;
import com.company.web.shiro.dao.ShiroUserDao;
import com.company.web.shiro.model.ShiroMerchantResource;
import com.company.web.shiro.model.ShiroRole;
import com.company.web.shiro.model.ShiroUser;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by v-leiyu on 2017/9/7.
 */
@Service
public class UserService {
	@Resource ShiroUserDao userDao;
	@Resource ShiroMerchantResourceDao resourceDao;
	@Resource ShiroRoleDao roleDao;

	public ShiroUser selectUserByUserName(String userName) {
		return userDao.selectByUserName(userName);
	}

	public List<ShiroMerchantResource> selectPermissionByIds(String userName) {
		List<ShiroMerchantResource> resourceList = new ArrayList<>();
		List<ShiroRole> list = selectRolesByUserName(userName);
		if (CollectionUtils.isEmpty(list))
			return Collections.EMPTY_LIST;
		for (ShiroRole role : list) {
			List<ShiroMerchantResource> shiroMerchantResources = resourceDao.selectByManyKey(role.getAllResourceIds());
			resourceList.addAll(shiroMerchantResources);
		}
		return resourceList;
	}

	public List<ShiroRole> selectRolesByUserName(String userName) {
		ShiroUser user = selectUserByUserName(userName);
		if (user == null || CollectionUtils.isEmpty(user.getAllRoles()))
			return Collections.EMPTY_LIST;
		return  roleDao.selectByManyKey(user.getAllRoles());
	}

	public List<ShiroUser> selectAll(){
		return userDao.selectAll();
	}

	public ShiroUser selectUserById(Long id) {
		return userDao.selectByPrimaryKey(id);
	}

	public Boolean updateUserById(ShiroUser user) {
		return userDao.updateByPrimaryKey(user);
	}

	public Boolean createUser(ShiroUser user) {
		return userDao.insert(user);
	}

	public Boolean deleteUserById(Long id) {
		return userDao.deleteByPrimaryKey(id);
	}

	public ShiroUser selectUserByIdAndPwd(ShiroUser user) {
		return userDao.selectUserByIdAndPwd(user);
	}

	public Boolean updateUserByIdNoPwd(ShiroUser user) {
		return userDao.updateUserByIdNoPwd(user);
	}
}
