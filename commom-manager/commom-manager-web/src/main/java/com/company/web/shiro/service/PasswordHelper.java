package com.company.web.shiro.service;

import com.company.web.shiro.model.ShiroUser;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * Created by v-leiyu on 2017/9/13.
 */
public class PasswordHelper {

	public  static ShiroUser encryptPassword(ShiroUser user){
		if (user.getSalt()==null || "".equals(user.getSalt())){
			SecureRandomNumberGenerator generator=new SecureRandomNumberGenerator();
			String salt = generator.nextBytes().toHex();
			user.setSalt(salt);
		}
		SimpleHash simpleHash=new SimpleHash("md5",user.getPassword(),user.getUsername()+user.getSalt(),2);
		user.setPassword(simpleHash.toString());
		return  user;
	}
}
