package com.company.web.shiro.model;

import org.apache.commons.lang.math.NumberUtils;

import java.util.ArrayList;
import java.util.List;

public class ShiroUser {
    private Long id;

    private String username;

    private String password;

    private String salt;

    private String roleIds;

    private Integer locked=0;

    private List<Long> allRoles;

    public List<Long> getAllRoles() {
        return allRoles;
    }

    public void setAllRoles(List<Long> allRoles) {
        this.allRoles = allRoles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds == null ? null : roleIds.trim();
        this.allRoles=new ArrayList<>();
        if (this.roleIds!=null){
            String[] split = this.roleIds.split(",");
            for (String s : split) {
                s = s.trim();
                allRoles.add(NumberUtils.toLong(s,0));
            }
        }
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

	public String getCredentialsSalt() {
        return username+salt;
	}
}
