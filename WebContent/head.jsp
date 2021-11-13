<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="res/layui/css/layui.css">
<link rel="stylesheet" href="res/css/global.css">
<link rel="stylesheet" type="text/css" href="css/index.css">
<script src="res/layui/layui.js"></script>
<style>
</style>
</head>
<body>
	<div class="dvhead">
		<div class="dvlogo">
			<a href="default.jsp" target="_parent" >学无涯论坛</a>
		</div>
		<div class="dvsearch" style="color:red;">提出你的问题，找到你的同学</div>
		<div class="nav-user" style="top: -2px; right: 100px">


			<!-- 描述：登录后的样子 -->
			<s:if test="#session.user!=null">
				<a class="avatar" href="">
				<!--  <img src="res/images/avatar/11.jpg">  -->	
				<img src="${pageContext.request.contextPath }/<s:property value="#session.user.image"/>">
					
					<cite>
						<s:property value="#session.user.username" />
					</cite>
				</a>
				<div class="nav">
					<!-- target="_parent" 这个 head 是嵌入页面，所以跳转需要 target="_parent" 才可在发生页面切换的时候整个页面跳转-->
					<a href="${pageContext.request.contextPath }/UserAction_logout" target="_parent">
						<i class="iconfont icon-tuichu" style="top: 0; font-size: 22px;"></i>
						退出
					</a>
				</div>
			</s:if>




			<!-- 描述：未登录的样子 -->
			<s:if test="#session.user==null">
				<a class="iconfont icon-touxiang layui-hide-xs" style="margin-top: 4px; display: inline-block;"> </a>
				<div class="nav" style="font-size: 14px; color: white; margin-top: -5px; margin-left: 1px;" />
				<a href="login.jsp" target="_parent">登录</a>
				<a href="register.jsp" target="_parent">注册</a>
			</s:if>
		</div>
	</div>

</body>
</html>