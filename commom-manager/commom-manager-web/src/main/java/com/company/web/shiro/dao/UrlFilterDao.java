package com.company.web.shiro.dao;

import com.company.web.shiro.model.UrlFilter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlFilterDao {
    int deleteByPrimaryKey(Long id);

    int insert(UrlFilter record);

    int insertSelective(UrlFilter record);

    UrlFilter selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UrlFilter record);

    int updateByPrimaryKey(UrlFilter record);

    List<UrlFilter> selectAll();
}
