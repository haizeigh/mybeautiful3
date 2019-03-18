package com.company.web.shiro.service;


import com.company.web.shiro.dao.UrlFilterDao;
import com.company.web.shiro.model.UrlFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UrlFilterService  {

    @Autowired
    private UrlFilterDao urlFilterDao;

    @Autowired
    private ShiroFilerChainManager shiroFilerChainManager;


    public UrlFilter createUrlFilter(UrlFilter urlFilter) {
        urlFilterDao.insert(urlFilter);
        initFilterChain();
        return urlFilter;
    }




    public UrlFilter updateUrlFilter(UrlFilter urlFilter) {
        urlFilterDao.updateByPrimaryKey(urlFilter);
        initFilterChain();
        return urlFilter;
    }


    public boolean deleteUrlFilter(Long urlFilterId) {
        int i=urlFilterDao.deleteByPrimaryKey(urlFilterId);
        initFilterChain();
        return i>0;
    }


    public UrlFilter findOne(Long urlFilterId) {
        return urlFilterDao.selectByPrimaryKey(urlFilterId);
    }


    public List<UrlFilter> findAll() {
        return urlFilterDao.selectAll();
    }

    @PostConstruct
    public void initFilterChain() {
//        shiroFilerChainManager.initFilterChains(findAll());
    }

}
