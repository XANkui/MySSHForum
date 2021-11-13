package com.xan.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xan.domain.Answer;
import com.xan.domain.Paste;
import com.xan.domain.User;
import com.xan.service.AnswerService;
import com.xan.service.PasteService;
import com.xan.service.PraiseService;
import com.xan.utils.PageBean;

public class PasteAction extends ActionSupport implements ModelDriven<Paste> {
	
	private Paste paste = new Paste();
	private PasteService pasteService;
	private String pasteid;
	private AnswerService answerService;
	 private PraiseService praiseService;

	public String solvePaste() throws Exception {
		pasteService.solvePasteByIdAndAnswerid(pasteid,paste.getAnswerid());
		ActionContext.getContext().put("pasteid",pasteid);
		return "toDetail";
	}
	
	public String getDetail() throws Exception {
		
		// 热度帖子
		PageBean glanceoverPageBean = pasteService.getGlanceoverPageBean(null);
		ActionContext.getContext().put("glanceoverPageBean", glanceoverPageBean);
		
		// 热议帖子
		PageBean ansnumPageBean = pasteService.getAnsnumPageBean(null);
		ActionContext.getContext().put("ansnumPageBean", ansnumPageBean);
		
		// 指定帖子具体内容
		Paste paste = pasteService.findPasteById(pasteid);
		ActionContext.getContext().put("paste", paste);
		
		// 获取该帖子的所有回复
		List<Answer> answerList = answerService.findAllAnswerByPasteid(pasteid);
		ActionContext.getContext().put("answerList", answerList);
		
		// 判断用户是否点赞
		User user = (User) ActionContext.getContext().getSession().get("user");
		for(Answer answer : answerList) {
			if(user!=null) {
				boolean isHas = praiseService.findPraiseByUseridAndAnswerid(user.getId(),answer.getId());
				answer.setLoginUserIsAgree(isHas?1:0); // 1 点赞过；0 没有点赞过
			}else {
				answer.setLoginUserIsAgree(0);
			}
		}
		
		
		return "detail";
	}
	
	public String addPaste() throws Exception {
		
		User user = (User) ActionContext.getContext().getSession().get("user");
		
		if(user == null) {
			
			ActionContext.getContext().put("message", "只有登录才能发帖");
			return "toLogin";
		}
		System.out.println("addPaste user :" +user.getUsername());
		paste.setAnsnum(0);
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String createtime = format.format(date);
		paste.setCreatetime(createtime);
		paste.setGlanceover(0);
		paste.setSolve(0);
		
		paste.setUser(user);
		
		System.out.println("addPaste " +paste.toString());
		pasteService.addPaste(paste);
		
		return "toIndex";
	}

	@Override
	public Paste getModel() {
		
		return paste;
	}

	public PasteService getPasteService() {
		return pasteService;
	}

	public void setPasteService(PasteService pasteService) {
		this.pasteService = pasteService;
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
