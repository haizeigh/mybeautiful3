package com.company.pojo.dao;

import com.company.pojo.model.SocicalUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SocicalUserDao {
    int deleteByPrimaryKey(Long id);

    int insert(SocicalUser record);

    int insertSelective(SocicalUser record);

    SocicalUser selectByPrimaryKey(Long id);

    SocicalUser selectByName(String name);

    int updateByPrimaryKeySelective(SocicalUser record);

    int updateByPrimaryKey(SocicalUser record);
}
