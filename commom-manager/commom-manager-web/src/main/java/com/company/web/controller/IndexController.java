package com.company.web.controller;

import com.company.fcade.SocialFriendsInte;
import com.company.pojo.model.SocialDynamic;
import com.company.pojo.model.SocicalUser;
import com.company.web.model.Response;
import com.company.web.service.engine.PayEngine;
import com.company.web.service.engine.PayRule;
import com.company.web.service.helper.IPUtils;
import com.company.web.utils.Constants;
import com.company.web.utils.WebResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;

/**
 * Created by v-leiyu on 2017/12/1.
 */
@Controller
public class IndexController {

	@Resource
	private SocialFriendsInte socialFriends;

	private static Logger logger= LoggerFactory.getLogger(IndexController.class);
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("/index")
	public  String home(HttpServletRequest request,Model model){
		List<SocialDynamic> allSocialDynamic = null;
		logger.debug("测试debug日志");
		logger.info("测试info日志");
		logger.warn("测试warn日志");
		logger.error("测试error日志");
		try {
			allSocialDynamic = socialFriends.findAllSocialDynamic();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("list",allSocialDynamic);
		String contextPath = request.getContextPath();
		String servletPath = request.getServletPath();
		System.out.println(contextPath);
		System.out.println(servletPath);
		String realPath = request.getSession().getServletContext().getRealPath("./");
		System.out.println(realPath);
		System.out.println(1);
		return  "social_page/state_friend";
	}


	@RequestMapping("/test/resource")
	public  String resource(HttpServletRequest request,Model model){
		String url1 = Constants.getProperty("testUrl");
		System.out.println("配置文件值"+url1);
		return "redirect:/";

	}


	@RequestMapping("/login1")
	public String login1(String userName,String pwd,HttpServletRequest request){
		/*SocicalUser socicalUser = socialFriends.login(userName);
		if (socicalUser!=null && pwd.equals(socicalUser.getPassword())){
			System.out.println(userName+"登录成功");
			request.getSession().setAttribute("name",userName);
		}*/
		request.getSession().setAttribute(userName,pwd);
		InetAddress localHostLANAddress = null;
		try {
			localHostLANAddress = IPUtils.getLocalHostLANAddress();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("ip",localHostLANAddress.getHostAddress());
		return  "social_page/login";
	}

	@RequestMapping("/login2")
	public String login2(String userName,String pwd,HttpServletRequest request){
		return login1(userName,pwd,request);
	}


	@RequestMapping("/pay")
	@ResponseBody
	public  String   pay(HttpServletRequest request,HttpServletResponse response){
		String payway = request.getParameter("payway");
		PayRule payRule = PayEngine.getPayRule(payway);
		payRule.pay(new HashMap());
//		WebResponse.notifyReturn(response,"<xml>测试直接写入response</xml>");
		return  "<xml>success</xml>";
	}

	@RequestMapping("/test")
	@ResponseBody
	public  String test(HttpServletRequest request,Model model){
		return  "SUCCESS";
	}

	@RequestMapping("/")
	public  String index(HttpServletRequest request,Model model){
//		return  "redirect:/index";
		return  "social_page/login";
	}

	//测试内容协商机制
	@RequestMapping("/simple")
	public  String simple(HttpServletRequest request,ModelMap model){
		Response response=new Response();
		response.setCode("00");
		response.setMsg("测试");
		model.addAttribute("Response",response);
		return  "Response";
	}

	//测试内容协商机制
	@RequestMapping("/simple2")
	public  String simple2(HttpServletRequest request,Model model){
		Response response=new Response();
		response.setCode("00");
		response.setMsg("测试");
		return  "Response";
//		return  response;
	}

	//测试dubbo重试时间
	@RequestMapping("/dubbo")
	public  String dubbo(HttpServletRequest request,Model model){
		System.out.println("这是消费端调用dubbo服务");
		socialFriends.testDubbo();
		return  "Response";
//		return  response;
	}
}
