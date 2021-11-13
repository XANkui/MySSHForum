package com.xan.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xan.domain.Answer;
import com.xan.domain.Paste;
import com.xan.domain.User;
import com.xan.service.AnswerService;
import com.xan.service.PasteService;

public class AnswerAction extends ActionSupport implements ModelDriven<Answer> {
	
	private Answer answer = new Answer();
	private AnswerService answerService;
	private String pasteid;
	private PasteService pasteService;
	private String answerid;
	
	@Override
	public Answer getModel() {
		// TODO Auto-generated method stub
		return answer;
	}
	
	
	
	public AnswerService getAnswerService() {
		return answerService;
	}



	public void setAnswerService(AnswerService answerService) {
		this.answerService = answerService;
	}



	public String getPasteid() {
		return pasteid;
	}



	public void setPasteid(String pasteid) {
		this.pasteid = pasteid;
	}

	public PasteService getPasteService() {
		return pasteService;
	}



	public void setPasteService(PasteService pasteService) {
		this.pasteService = pasteService;
	}

	public String getAnswerid() {
		return answerid;
	}


	public void setAnswerid(String answerid) {
		this.answerid = answerid;
	}


	public String deleteAnswer() throws Exception {
		Paste paste = pasteService.findPasteById(pasteid);
		answerService.deleteAnswer(answerid,paste);
		ActionContext.getContext().put("pasteid", pasteid); // 这个好似可以不需要，因为删除的里面有 pasteid
		return "toDetail";
	}
	
	public String addAnswer() throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		
		if(user ==null) {
			
			ActionContext.getContext().put("message", "只有登录才能回复帖子");
			return "error";
		}
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String anstime = format.format(date);
		answer.setAnstime(anstime);
		
		answer.setAgree(0);
		answer.setSolve(0);
		answer.setUser(user);
		
		System.out.println("pasteid : "+pasteid);
		System.out.println("answer.getContent : "+answer.getContent());
		Paste paste = pasteService.findPasteById(pasteid);
		
		answer.setPaste(paste);
		
		answerService.addAnswer(answer,paste);
		
		return "toDetail";
	}



	
}
