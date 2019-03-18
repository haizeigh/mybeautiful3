package com.company.pojo.dao;

import com.company.pojo.model.SocialFriendship;

public interface SocialFriendshipDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SocialFriendship record);

    int insertSelective(SocialFriendship record);

    SocialFriendship selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SocialFriendship record);

    int updateByPrimaryKey(SocialFriendship record);
}
