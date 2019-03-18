package com.company.web.shiro.service;

import com.company.web.shiro.dao.ShiroRoleDao;
import com.company.web.shiro.model.ShiroRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by v-leiyu on 2017/9/11.
 */
@Service
public class RoleService {
	@Autowired ShiroRoleDao roleDao;

	public List<ShiroRole> selectAll() {
		return roleDao.selectAll();
	}

	public Boolean deleteUserById(Long id) {

		return  roleDao.deleteByPrimaryKey(id);
	}

	public ShiroRole selectRoleById(Long id) {
		return  roleDao.selectByPrimaryKey(id);
		
	}

	public Boolean updateRoleById(ShiroRole role) {
		return  roleDao.updateByPrimaryKey(role);
	}

	public Boolean createRole(ShiroRole role) {
		return  roleDao.insert(role);
	}
}
