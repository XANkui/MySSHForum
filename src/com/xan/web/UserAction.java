package com.xan.web;

import java.util.Random;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xan.domain.User;
import com.xan.service.UserService;
import com.xan.utils.MailUtils;

public class UserAction extends ActionSupport implements ModelDriven<User>{

	public User user = new User();
	
	private UserService userService;
	private String userCode;
	
	
	public String logout() throws Exception {
		
		ActionContext.getContext().getSession().remove("user");
		return "login";
	}
	
	public String login() throws Exception {
		System.out.println("login user :" +user.toString());
		int retCode = userService.checkUser(user);
		
		if(retCode==0) {
			
			ActionContext.getContext().getSession().put("user", userService.findUserByUser(user));
			
			return "toIndex";
		}else if(retCode==1) {
			ActionContext.getContext().put("message", "用户不存在");
			return "login";
		}else if(retCode==2) {
			ActionContext.getContext().put("message", "密码错误");
			return "login";
		}else if(retCode==3) {
			ActionContext.getContext().put("message", "用户未激活");
			return "login";
		}
		
		return "error";
	}
	
	public String active() throws Exception{
	
		System.out.println("active userCode :" +userCode);
		userService.activeUser(userCode);
		return "login";
	}
	
	public String checkUsername() throws Exception {
		boolean success = userService.findUserByUsername(user.getUsername());
	
		ServletActionContext.getResponse().getWriter().write("{\"success\":"+success+"}");
		
		return null;
	}
	
	public String register() throws Exception {

		System.out.println(user.toString());
		if(userService.findUserByUsername(user.getUsername())==false) {
			System.out.println("一次点击多次触发");
			return "login";
		}
		// User 没有的数据，手动封装
		user.setState(0);
		user.setCode(UUID.randomUUID().toString());
		
		//随机设置头像
		Random r = new Random();
		user.setImage("/images/"+r.nextInt(21)+".gif");
		
		
		user.setLevel(1);
		user.setCoin(1000);
		
		// 判断是否添加成功
		userService.addUser(user);
		System.out.println("发送激活邮件");
		MailUtils.sendMail(user.getEmail(), "Forum Register 激活", "注册成功，请点击下面链接激活：<a href='http://localhost:8081/SSH_Forum/UserAction_active?userCode="+user.getCode()+"'>点击激活</a>");
		
		return "toRegisterSuccess";

	}
	
	

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

}
