package com.company.web.shiro.realm;

import com.company.web.shiro.model.ShiroUser;
import com.company.web.shiro.service.UserService;
import com.company.web.utils.FieldUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;


import javax.annotation.Resource;
import javax.security.auth.login.AccountLockedException;

/**
 * Created by v-leiyu on 2017/9/7.
 */
public class UserRrealm extends AuthorizingRealm {
	@Resource UserService userService;

	@Override protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		String username = (String)principalCollection.getPrimaryPrincipal();
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		info.setRoles(FieldUtil.getFieldSetFromObjs("role", userService.selectRolesByUserName(username).toArray()));
		info.setStringPermissions(FieldUtil.getFieldSetFromObjs("permission", userService.selectPermissionByIds(username).toArray()));
		return info;
	}

	@Override protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
			throws AuthenticationException {
		String username = (String)token.getPrincipal();
		ShiroUser shiroUser = userService.selectUserByUserName(username);
		if (shiroUser==null)
			throw new UnknownAccountException();
		if (1==shiroUser.getLocked()){
			try {
				throw new AccountLockedException();
			}
			catch (AccountLockedException e) {
				e.printStackTrace();
			}
		}
		return new SimpleAuthenticationInfo(shiroUser.getUsername(),shiroUser.getPassword(),
				ByteSource.Util.bytes(shiroUser.getCredentialsSalt()),getName());

	}
}
