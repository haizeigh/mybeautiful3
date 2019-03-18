package com.company.fcade;

import com.company.pojo.model.SocialDynamic;
import com.company.pojo.model.SocicalUser;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by v-leiyu on 2017/12/1.
 */

public interface SocialFriendsInte {

 List<SocialDynamic> findAllSocialDynamic();

  void testDubbo();

 SocicalUser login(String userName);
}
