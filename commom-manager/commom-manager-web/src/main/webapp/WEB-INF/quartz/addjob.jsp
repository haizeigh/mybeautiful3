<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>新增任务</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body style="background: beige; margin: 300px 600px 200px;" >
  <form action="${pageContext.request.contextPath }/quartz/${action}" method="post">
  <span>新增Trigger</span>
	<hr/>
   <table id="table_report" class="table table-striped table-bordered table-hover">
   <tr>
       cronExpr:
   		<td>cron</td><td><input type="text" name="cronExpr" value="${jobEntity.cronExpr}"/></td>
   </tr>
   <tr>
       jobClass:
   		<td>clazz</td><td><input type="text" name="jobClass" value="${jobEntity.jobClass}"/></td>
   </tr>
   <tr>
       jobName:
   		<td>jobName</td><td><input type="text" name="jobName" value="${jobEntity.jobName}"/></td>
   </tr>
   <tr>
       jobGroup:
   		<td>jobGroupName</td><td><input type="text" name="jobGroup" value="${jobEntity.jobGroup}"/></td>
   </tr>
   <tr>
       triggerName：
  		 <td>triggerName</td><td><input type="text" name="triggerName" value="${jobEntity.triggerName}"/></td>
   </tr>
   <tr>
       triggerGroup：
  		 <td>triggerGroupName</td><td><input type="text" name="triggerGroup" value="${jobEntity.triggerGroup}"/></td>
   </tr>
   <tr>
   	<td></td>
   	<td>
   		<button type="submit" style="border: 0;background-color: #428bca;">提交</button>
   		<button class="cancel" style="border: 0;background-color: #fff;">返回</button>
   	</td>
    </tr>
</table>
  </form>
  </body>
</html>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.8.1.min.js"></script>
<script>
$(document).ready(function() {
	$(".cancel").click(function(){
		history.go(-1) ;
	});
});
</script>

