package com.company.web.shiro.service;

import com.company.web.shiro.dao.ShiroMerchantResourceDao;
import com.company.web.shiro.model.ShiroMerchantResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by v-leiyu on 2017/9/11.
 */
@Service
public class ResourceService {
	@Autowired
	ShiroMerchantResourceDao resourceDao;

	public List<ShiroMerchantResource> selectAll() {
		return resourceDao.selectAll();
	}

	public Boolean deleteUserById(Long id) {

		return  resourceDao.deleteByPrimaryKey(id);
	}

	public LinkedList<ShiroMerchantResource> selectResourceByParentId(long parentId) {
		return resourceDao.selectResourceByParentId(parentId);
	}

	public ShiroMerchantResource selectMerchantResourceById(Long id) {
		return resourceDao.selectByPrimaryKey(id);
	}

	public Boolean updateMerchantResourceById(ShiroMerchantResource merchantResource) {
		return resourceDao.updateByPrimaryKey(merchantResource);
	}

	public Boolean createMerchantResouce(ShiroMerchantResource merchantResource) {
		return resourceDao.insert(merchantResource);
	}

	public Long getMaxIdOfTeamByParentId(Long parentId) {
		return resourceDao.getMaxIdOfTeamByParentId(parentId);
	}

}
