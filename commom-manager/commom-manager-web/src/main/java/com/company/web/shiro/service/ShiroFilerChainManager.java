package com.company.web.shiro.service;


import com.company.web.shiro.model.UrlFilter;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.NamedFilterList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class ShiroFilerChainManager {

    {
        System.out.println("测试bean初始化");
    }
   /* @Autowired
    private DefaultFilterChainManager filterChainManager;

    private Map<String, NamedFilterList> defaultFilterChains;
    private Logger log= LoggerFactory.getLogger(ShiroFilerChainManager.class);

    @PostConstruct
    public void init() {
        defaultFilterChains = new LinkedHashMap<>(filterChainManager.getFilterChains());
    }

    public void initFilterChains(List<UrlFilter> urlFiltersOriginal) {
        List<UrlFilter> urlFilters=new ArrayList<>();
        //分解多个url合并的情况
        for (UrlFilter urlFilter :urlFiltersOriginal){
            //url是包含“，”的多个url的合并
            if (urlFilter.getUrl().contains(",")){
                String[] split = urlFilter.getUrl().split(",");
                for (String url:split){
                    try {
                        //克隆新的UrlFilter放入集合
                        UrlFilter UrlFilterClone= (UrlFilter)urlFilter.clone();
                        UrlFilterClone.setUrl(url);
                        urlFilters.add(UrlFilterClone);
                    }
                    catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                        log.info("Clone UrlFilter failed, original urlFilter-->"+urlFilter);
                    }
                }

            }
            //url是简单的单个url
            urlFilters.add(urlFilter);
        }
        //存储最后一个拦截器链
        String lastKey=null;
        NamedFilterList lastFilters =null;
        //1、首先删除以前老的filter chain并注册默认的
        filterChainManager.getFilterChains().clear();
        if(defaultFilterChains != null) {
            Iterator<String> iterator = defaultFilterChains.keySet().iterator();
            while (iterator.hasNext()){
                lastKey = iterator.next();
            }
            lastFilters = defaultFilterChains.get(lastKey);
            defaultFilterChains.remove(lastKey);
            filterChainManager.getFilterChains().putAll(defaultFilterChains);
        }

        //2、循环URL Filter 注册filter chain
        for (UrlFilter urlFilter : urlFilters) {
            String url = urlFilter.getUrl();
            //注册roles filter
            if (!StringUtils.isEmpty(urlFilter.getRoles())) {
                filterChainManager.addToChain(url, "roles", urlFilter.getRoles());
            }
            //注册perms filter
            if (!StringUtils.isEmpty(urlFilter.getPermissions())) {
                filterChainManager.addToChain(url, "perms", urlFilter.getPermissions());
            }
        }
        //加入最后一个拦截器链,再次存储
        if (lastKey!=null){
            defaultFilterChains.put(lastKey,lastFilters);
            filterChainManager.getFilterChains().put(lastKey,lastFilters);
        }

    }*/

}
