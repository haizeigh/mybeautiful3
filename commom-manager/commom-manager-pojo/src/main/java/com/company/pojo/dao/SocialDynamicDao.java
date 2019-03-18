package com.company.pojo.dao;

import com.company.pojo.model.SocialDynamic;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocialDynamicDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SocialDynamic record);

    int insertSelective(SocialDynamic record);

    SocialDynamic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SocialDynamic record);

    int updateByPrimaryKey(SocialDynamic record);

    List<SocialDynamic> selectAll();
}
