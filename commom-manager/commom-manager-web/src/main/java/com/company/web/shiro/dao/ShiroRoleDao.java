package com.company.web.shiro.dao;


import com.company.web.shiro.model.ShiroRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShiroRoleDao {
    Boolean deleteByPrimaryKey(Long id);

    Boolean insert(ShiroRole record);

    int insertSelective(ShiroRole record);

    ShiroRole selectByPrimaryKey(Long id);

    List<ShiroRole> selectByManyKey(List<Long> keyList);

    int updateByPrimaryKeySelective(ShiroRole record);

    Boolean updateByPrimaryKey(ShiroRole record);

	List<ShiroRole> selectAll();
}
