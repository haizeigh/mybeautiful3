<%--
  Created by IntelliJ IDEA.
  User: v-leiyu
  Date: 2017/12/4
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>

    <%--<link type="text/css" href="${ctx}/static/css/global.css" >
    <link type="text/css" href="${ctx}/static/css/boxy,jquery.fancybox-1.3.4.css" >
    <link type="text/css" href="${ctx}/static/css/aboutus.css" >
    <link type="text/css" href="${ctx}/static/css/reg.css" >
    <link type="text/css" href="${ctx}/static/css/huidong.css" >--%>
    <script type="text/javascript">

        function del(id) {
            var res=confirm("是否删除");
            /* 发送信息到新的Delete_Staff_Servlet处理 */
            if(res){
                /* 模拟表单提交数据的模式进行数据转移?stu_id=的 表示key值是stu_id,后面的+stu_id表示value是stu_id*/
                /* window.location.href="Delete_Staff_Servlet?stu_id="+stu_id; */
                location.href="delete.do?&id="+id;
                /* location.href="Delete_Staff_Servlet" */
            }
        }
        function upd(id) {
            /* 转到Update_Staff_Servlet处理stu_id */
            var res=confirm("是否更新");
            if(res){
                location.href="checkUpdate.do?id="+id;
            }

        }


    </script>
</head>
<body>
<jsp:include page="/WEB-INF/appendix/cusHead.jsp"/>
<table border="2px black solid" cellpadding="5px"  cellspacing="0" style="text-align: center" align="center">
    <c:forEach items="${list }"   var="t" varStatus="status" begin="0"  step="1">

        <tr  style="<c:if test="${status.index%2==0}">background-color: silver</c:if>">
            <td>${t.id }</td>
            <td>${t.username }</td>
            <td>${t.content }</td>
            <td>${t.picture }</td>
            <td>${t.multiMedia }</td>
            <td>${t.time }</td>
            <td>${t.commented }</td>

            <td>
                <!-- 增加按钮 -->
                <input type="button" id="del" name="del" value="删除" onclick="del('${t.id }')" />&nbsp;&nbsp;
                <input type="button" id="upd" name="upd" value="更新" onclick="upd('${t.id}')" /></td>

        </tr>
    </c:forEach>
</table>
<a href="add.jsp">增加</a>

</body>
</html>
