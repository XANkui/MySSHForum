package com.xan.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xan.domain.Answer;
import com.xan.domain.Praise;
import com.xan.domain.User;
import com.xan.service.AnswerService;
import com.xan.service.PraiseService;
import com.xan.vo.PraisePrimaryKey;

public class PraiseAction extends ActionSupport {
	
	private String answerid;
	private String pasteid;
	private AnswerService answerService;
	private PraiseService praiseService;
	
	public String deleteAgree() throws Exception {
		
		// 登录才会触发取消点赞功能，所以一定是登录 user!=null
		User user = (User) ActionContext.getContext().getSession().get("user");
		
		Answer answer = answerService.findAnswerByAnswerid(answerid);
		// 声明联合主键
		PraisePrimaryKey ppk = new PraisePrimaryKey();
		// 赋值对象
		ppk.setAnswer(answer);
		ppk.setUser(user);
		
		// 创建 赞 类
		Praise praise = new Praise();
		// 将联合主键放入对象中
		praise.setPraisePrimaryKey(ppk);
		
		praiseService.deletePraise(praise);
		// 增加点赞数
		answerService.deleteAnswerAgreeByAnswerid(answerid);
		
		ActionContext.getContext().put("pasteid", pasteid); 
		return "toDetail";
	}
	
	public String addAgree() throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(user==null) {
			
			ActionContext.getContext().put("message", "没有登录不能点赞，请登录");
			return "toLogin";
		}
		System.out.println("user.getId : "+user.getId());
		System.out.println("answerid : "+answerid);
		
		Answer answer = answerService.findAnswerByAnswerid(answerid);
		// 声明联合主键
		PraisePrimaryKey ppk = new PraisePrimaryKey();
		// 赋值对象
		ppk.setAnswer(answer);
		ppk.setUser(user);
		
		// 创建 赞 类
		Praise praise = new Praise();
		// 将联合主键放入对象中
		praise.setPraisePrimaryKey(ppk);
		
		praiseService.addPraise(praise);
		// 增加点赞数
		answerService.addAnswerAgreeByAnswerid(answerid);
	
		ActionContext.getContext().put("pasteid", pasteid);
		return "toDetail";
	}

	public String getAnswerid() {
		return answerid;
	}

	public void setAnswerid(String answerid) {
		this.answerid = answerid;
	}

	public String getPasteid() {
		return pasteid;
	}

	public void setPasteid(String pasteid) {
		this.pasteid = pasteid;
	}

	public AnswerService getAnswerService() {
		return answerService;
	}

	public void setAnswerService(AnswerService answerService) {
		this.answerService = answerService;
	}

	public PraiseService getPraiseService() {
		return praiseService;
	}

	public void setPraiseService(PraiseService praiseService) {
		this.praiseService = praiseService;
	}
	
}
