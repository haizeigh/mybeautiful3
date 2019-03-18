package com.company.web.shiro.model;

import org.apache.commons.lang.math.NumberUtils;

import java.util.ArrayList;
import java.util.List;

public class ShiroRole {
    private Long id;

    private String role;

    private String description;

    private String resourceIds="1";

    private Integer available;

    private List<Long> AllResourceIds;

    public List<Long> getAllResourceIds() {
        return AllResourceIds;
    }

    public void setAllResourceIds(List<Long> allResourceIds) {
        AllResourceIds = allResourceIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds == null ? null : resourceIds.trim();
        this.AllResourceIds=new ArrayList<>();
        if (this.resourceIds!=null){
            String[] split = this.resourceIds.split(",");
            for (String s : split) {
                s = s.trim();
                AllResourceIds.add(NumberUtils.toLong(s,0));
            }
        }
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }
}
