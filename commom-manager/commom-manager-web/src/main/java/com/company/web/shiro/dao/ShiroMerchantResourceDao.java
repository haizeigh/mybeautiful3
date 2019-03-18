package com.company.web.shiro.dao;

import com.company.web.shiro.model.ShiroMerchantResource;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public interface ShiroMerchantResourceDao {
    Boolean deleteByPrimaryKey(Long id);

    Boolean insert(ShiroMerchantResource record);

    int insertSelective(ShiroMerchantResource record);

    ShiroMerchantResource selectByPrimaryKey(Long id);

    List<ShiroMerchantResource> selectByManyKey(List<Long> keyList);

    int updateByPrimaryKeySelective(ShiroMerchantResource record);

    Boolean updateByPrimaryKey(ShiroMerchantResource record);

	List<ShiroMerchantResource> selectAll();

	LinkedList<ShiroMerchantResource> selectResourceByParentId(long parentId);

	Long getMaxIdOfTeamByParentId(Long parentId);

}
