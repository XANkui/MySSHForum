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
			ActionContext.getContext().put("message", "�û�������");
			return "login";
		}else if(retCode==2) {
			ActionContext.getContext().put("message", "�������");
			return "login";
		}else if(retCode==3) {
			ActionContext.getContext().put("message", "�û�δ����");
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
			System.out.println("һ�ε����δ���");
			return "login";
		}
		// User û�е����ݣ��ֶ���װ
		user.setState(0);
		user.setCode(UUID.randomUUID().toString());
		
		//�������ͷ��
		Random r = new Random();
		user.setImage("/images/"+r.nextInt(21)+".gif");
		
		
		user.setLevel(1);
		user.setCoin(1000);
		
		// �ж��Ƿ���ӳɹ�
		userService.addUser(user);
		System.out.println("���ͼ����ʼ�");
		MailUtils.sendMail(user.getEmail(), "Forum Register ����", "ע��ɹ��������������Ӽ��<a href='http://localhost:8081/SSH_Forum/UserAction_active?userCode="+user.getCode()+"'>�������</a>");
		
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
