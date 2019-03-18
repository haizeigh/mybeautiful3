<%--
  Created by IntelliJ IDEA.
  User: v-leiyu
  Date: 2017/11/30
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html  lang="zh">
<head>
    <meta charset="utf-8">
    <title>好友网</title>


    <link type="text/css" href="${ctx}/static/css/global.css" >
    <link type="text/css" href="${ctx}/static/css/boxy,jquery.fancybox-1.3.4.css" >
    <link type="text/css" href="${ctx}/static/css/aboutus.css" >
    <link type="text/css" href="${ctx}/static/css/reg.css" >
    <link type="text/css" href="${ctx}/static/css/huidong.css" >

    <script type="text/javascript">
        var userjson = '';
        var c_cityinfo = '';
    </script>

</head>
<body>
<div class="header">
    <div class="headWrap">
        <div class="headTop fn-clear">
            <h1 class="logo">
                <a href="index.htm" title="好友网" style="float: left;" >好友网</a>
            </h1>
            <h2 class="slogan" title="在旅途中相遇">在旅途中相遇</h2>

            <div class="loginInfo">
                <ul class="not_login">
                    <!-- 未登录
                        <li style="float:right"><a href="../login/register.htm" class="btn_reg">注册</a></li>
                        <li  style="float:right"><a href="../login/login.htm"  id="top-nav-login" class="btn_login">登录</a></li>                    -->
                    <li style="float:right"><a href="#">注销</a></li>
                    <li style="float:right"><a href="#">好友申请（0）</a>&nbsp;&nbsp;&nbsp;</li>
                    <li style="float:right"><a href="#">站内信（0）</a>&nbsp;&nbsp;&nbsp;</li>
                    <li style="float:right"><a href="#">chen10301002</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
                </ul>
            </div>
        </div>
        <ul class="dropdown">
            <li>
                <a href="../index.htm" >首页</a>
            </li>
            <li>
                <a href="../memory/memory.htm">旅游记忆</a>
            </li>
            <li>
                <a href="../traveller/traveller.htm">结伴游</a>
            </li>
            <li>
                <a href="../strategy/strategy.htm">景点攻略</a>
            </li>
        </ul>

        <div class="navSearch">
            <form action="../memory/memory_search.htm" method="get" id="searchForm" target="_blank">
                <input name="k" type="text" class="top-search-input" id="searchKey" value="搜索旅游记忆" maxlength="50" autocomplete="off"/>
                <input name="" type="submit" value="搜索" class="search_btn">
            </form>
            <div id="keyword_tip_content"></div>
        </div>
    </div>
</div>
<!--top end-->

<div id="container" class="fn-clear">
    <div class="bottom">
        <div class="bottom_t"></div>
        <div class="bottom_c h650">

            <div class="bottom_c_r">
                <h2 style="width:680px; height:40px; line-height:41px; background:#83bb4a url(${ctx}/static/images/reg-title-bg.png) repeat-x;
						color:#fefefe; text-indent:25px; font-size:20px; font-family:\9ED1\4F53; font-weight:400;">好友动态</h2>
                <ul id="comment-list" class="comment-list">
                    <li class="fn-clear">
                        <div class="cont fn-clear">
                            <textarea class="talkBox" id="comment_box" style="float:left"></textarea>
                            <input type="submit" class="sendBtn" value="发表动态">
                        </div>
                        <div>&nbsp;</div>
                    </li>

                    <li class="fn-clear">
                        <div >
                            <p>
                                <a class="comment_user" href="../memory/memory_detail.htm"><img width="75" height="75" alt="i闲逛" src="${ctx}/static/images/default.jpg">
                                    &nbsp;&nbsp;&nbsp;&nbsp;闲逛</a>
                                <label style="float:right">发表于 2013-03-15 16:51:22&nbsp;&nbsp;&nbsp;&nbsp;<a class="comment_user" href="#">评论</a></label>
                            </p>
                            <div class="comment_box">
                                <div class="comment_cnt">
                                    苏州，中国华东地区的特大城市之一，首批历史文化名城，中国十大重点风景旅游城市之一。
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="fn-clear">
                        <div >
                            <p>
                                <a class="comment_user" href="../memory/memory_detail.htm"><img width="75" height="75" alt="i闲逛" src="${ctx}/static/images/default.jpg">
                                    &nbsp;&nbsp;&nbsp;&nbsp;闲逛</a>
                                <label style="float:right">发表于 2013-03-15 16:51:22&nbsp;&nbsp;&nbsp;&nbsp;<a class="comment_user" href="#">评论</a></label>
                            </p>
                            <div class="comment_box">
                                <div class="comment_cnt">
                                    苏州，中国华东地区的特大城市之一，首批历史文化名城，中国十大重点风景旅游城市之一。
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="fn-clear">
                        <div >
                            <p>
                                <a class="comment_user" href="../memory/memory_detail.htm"><img width="75" height="75" alt="i闲逛" src="${ctx}/static/images/default.jpg">
                                    &nbsp;&nbsp;&nbsp;&nbsp;闲逛</a>
                                <label style="float:right">发表于 2013-03-15 16:51:22&nbsp;&nbsp;&nbsp;&nbsp;<a class="comment_user" href="#">评论</a></label>
                            </p>
                            <div class="comment_box">
                                <div class="comment_cnt">
                                    苏州，中国华东地区的特大城市之一，首批历史文化名城，中国十大重点风景旅游城市之一。
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="fn-clear">
                        <div >
                            <p>
                                <a class="comment_user" href="../memory/memory_detail.htm"><img width="75" height="75" alt="i闲逛" src="${ctx}/static/images/default.jpg">
                                    &nbsp;&nbsp;&nbsp;&nbsp;闲逛</a>
                                <label style="float:right">发表于 2013-03-15 16:51:22&nbsp;&nbsp;&nbsp;&nbsp;<a class="comment_user" href="#">评论</a></label>
                            </p>
                            <div class="comment_box">
                                <div class="comment_cnt">
                                    苏州，中国华东地区的特大城市之一，首批历史文化名城，中国十大重点风景旅游城市之一。
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
                <!--分页-->
                <div class="no-pages cf">
                    <strong>1</strong> <a href="?page=2&#comment">2</a>  <a href="?page=3&#comment">3</a> <a href="?page=4&#comment">4</a><a href="?page=2&#comment" class="pageBtn">下一页 &gt;&gt;</a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- 底部footer 开始-->

<div class="footer " >
    <div class="footerWrap fn-clear">
        <ul class="about_roadqu ">
            <li><a href="#">关于驴友</a>|</li>
            <li><a href="#">联系我们</a>|</li>
            <li><a href="#">用户公约</a>|</li>
            <li><a href="#">意见反馈</a>|</li>
            <li><a href="#">帮助中心</a>|</li>
            <li><a href="#">友情链接</a></li>
        </ul>
        <div class="foot">
            <p><span>版权所有软件1001班
			<a href="#" >陈文平</a><a href="#" > 胡剑彬</a><a href="#" >林清华</a><a href="#" >汤怡青</a><a href="#" >袁泽</a><a href="#" >周晓丽</a>
			</span></p>
            <div class="sns">
                <span>关注我们： </span><a href="#" class="login_sina">新浪微博 </a><a href="#" class="login_qq">腾讯微博</a>
                <a href="#" title="360绿色网站"><img src="http://trust.360.cn/img.php?sn=5229&id=5" border="0" /></a>
                <!-- WPA Button Begin -->
                <!-- WPA Button END -->
            </div>
        </div>
    </div>
</div>
<!-- footer end -->

</body>
</html>
