package com.company.web.shiro.dao;


import com.company.web.shiro.model.ShiroUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShiroUserDao {
    Boolean deleteByPrimaryKey(Long id);

    Boolean insert(ShiroUser record);

    int insertSelective(ShiroUser record);

    ShiroUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShiroUser record);

    Boolean updateByPrimaryKey(ShiroUser record);

    ShiroUser selectByUserName(String userName);

    List<ShiroUser> selectAll();

    ShiroUser selectUserByIdAndPwd(ShiroUser user);

    Boolean updateUserByIdNoPwd(ShiroUser user);
}
