package com.company.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.company.fcade.QuartzJobServiceFcade;
import com.company.pojo.model.JobEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by v-leiyu on 2017/12/29.
 */
@Controller
@RequestMapping("/quartz")
public class QuartzController {

	//Resource能默认通过类型关联bean   autowired默认是bean的名字关联  使用这种dubbo的模式，使用Resource较好
	@Resource
	private  QuartzJobServiceFcade quartzJobService;
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("/list")
	public  String home(HttpServletRequest request,Model model){
		List<JobEntity> jobEntityList = quartzJobService.selectJobAllList();
		model.addAttribute("jobInfos",jobEntityList);
		return  "quartz/listjob";
	}

	/**
	 * 暂停任务
	 */
	@RequestMapping("/pauseJob")
	@ResponseBody
	public  String pauseJob(String jobName,String jobGroupName){

		JSONObject jsonObject=new JSONObject();
		if (StringUtils.isEmpty(jobName) || StringUtils.isEmpty(jobGroupName)){
			jsonObject.put("status","wrong");
		}else {
			String result = quartzJobService.pauseJob(jobName, jobGroupName);
			if ("success".equals(result)){
				jsonObject.put("status","success");
			}else {
				jsonObject.put("status","wrong");
			}
		}
		return  jsonObject.toJSONString();
	}

	/**
	 * 暂停任务
	 */
	@RequestMapping("/resumeJob")
	@ResponseBody
	public  String reviveJob(String jobName,String jobGroupName){

		JSONObject jsonObject=new JSONObject();
		if (StringUtils.isEmpty(jobName) || StringUtils.isEmpty(jobGroupName)){
			jsonObject.put("status","wrong");
		}else {
			String result = quartzJobService.reviveJob(jobName, jobGroupName);
			if ("success".equals(result)){
				jsonObject.put("status","success");
			}else {
				jsonObject.put("status","wrong");
			}
		}
		return  jsonObject.toJSONString();
	}

	/**
	 * 删除任务
	 */
	@RequestMapping("/deleteJob")
	@ResponseBody
	public  String deleteJob(String jobName,String jobGroupName, String triggerName,String triggerGroupName){

		JSONObject jsonObject=new JSONObject();
		if (StringUtils.isEmpty(jobName) || StringUtils.isEmpty(jobGroupName)){
			jsonObject.put("status","wrong");
		}else {
			String result = quartzJobService.deleteJob(jobName, jobGroupName,triggerName, triggerGroupName);
			if ("success".equals(result)){
				jsonObject.put("status","success");
			}else {
				jsonObject.put("status","wrong");
			}
		}
		return  jsonObject.toJSONString();
	}

	/**
	 * 转跳到增加任务页面
	 */
	@RequestMapping("/toAdd")
	public  String toAddJob(Model model){
		model.addAttribute("action","add");
		return  "quartz/addjob";
	}

	/**
	 * 增加任务
	 */
	@RequestMapping(value = "/add",method = RequestMethod.POST )
	public  String addJob(JobEntity jobEntity,HttpServletRequest request){
		String result=quartzJobService.addJob(jobEntity);
		if ("success".equals(result)){
			request.setAttribute("message", "添加任务成功!");
		}else {
			request.setAttribute("message", "添加任务失败!");
		}
		request.setAttribute("opName", "添加任务!");
		return "quartz/message";
	}

	/**
	 * 转跳的修改页面
	 */
	@RequestMapping(value = "/toEdit" )
	public  String toEditJob(String jobName,String jobGroupName,Model model){
		JobEntity jobEntity =quartzJobService.selectAnJob( jobName, jobGroupName);
		model.addAttribute("jobEntity",jobEntity);
		model.addAttribute("action","Edit");
		return  "quartz/addjob";
	}

	/**
	 * 修改任务
	 */
	@RequestMapping(value = "/Edit" )
	public  String EditJob(JobEntity jobEntity,HttpServletRequest request){
		boolean result = quartzJobService.modifyJobTime(jobEntity);
		if(result){
			request.setAttribute("message", "修改任务成功!");
		}else{
			request.setAttribute("message", "修改任务失败!");
		}
		request.setAttribute("opName", "更新任务!");
		return "quartz/message";
	}






}
