<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body style="background: beige; margin: 300px 600px 200px;" >
  <form action="login1" method="post">
  <span>输入参数</span>
	<hr/>
   <table id="table_report" class="table table-striped table-bordered table-hover">
   <tr>
       userName:
   		<td>cron</td><td><input type="text" name="userName" value=""/></td>
   </tr>
   <tr>
       pwd:
   		<td>clazz</td><td><input type="text" name="pwd" value=""/></td>
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
  <span>__________________________________________________________________________</span><br/>

  <c:forEach items="${sessionScope}" var="att">
    <span>${att.key}</span>&nbsp;&nbsp;
    <span>${att.value}</span>&nbsp;&nbsp;
      <br/>
  </c:forEach>

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

