package com.company.service.serviceimp.service;

import com.company.pojo.dao.SocialDynamicDao;
import com.company.pojo.dao.SocicalUserDao;
import com.company.pojo.model.SocialDynamic;
import com.company.pojo.model.SocicalUser;
import com.company.service.db.DataEnum;
import com.company.service.db.DataSelecter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by v-leiyu on 2018/6/5.
 */
@Service
public class SocialFriendService {

	@Resource
	private SocialDynamicDao socialDynamicDao;

	@Resource
	private SocicalUserDao socicalUserDao;


	@DataSelecter(dateType = DataEnum.SalverData)
	public List<SocialDynamic> getSocialDynamics() {
		return socialDynamicDao.selectAll();
	}

	public SocicalUser login(String userName){
		return socicalUserDao.selectByName(userName);
	}
}
