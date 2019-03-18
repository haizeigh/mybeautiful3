
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" session="false"%>
<%--<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <style type="text/css">
.size{
  padding-left: 0px;
  padding-right:10px;
  font-size: 120%;
}
  </style>
</head>
<body>
<ul class="nav navbar-nav " role="navigation" >
  <li id="l1" ><a class="size" href="${ctx}/index">朋友信息</a></li>
  <li id="l2"><a href="${ctx}/quartz/list" class="size">定时任务</a></li>


  <%--<li class="dropdown">
    <a  class="dropdown-toggle" data-toggle="dropdown">其他<strong
            class="caret"></strong></a>
    <ul class="dropdown-menu">
      <li id=""><a href="${ctx}/statement">支付流水管理</a></li>
      <li class="divider"></li>
      <shiro:hasPermission name="merchant:create">
        <li><a href="${ctx}/merchant/edit">添加商户信息</a></li>
      </shiro:hasPermission>
    </ul>
  </li>--%>
</ul>
<ul class="nav navbar-nav navbar-right">

  <li style="background-color: rgba(197,189,196,0.24)"><a href="${ctx}/logout" >注销</a></li>
</ul>
</body>
</html>
