package com.xan.web;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xan.domain.Paste;
import com.xan.service.PasteService;
import com.xan.service.UserService;
import com.xan.utils.PageBean;

public class GetDataAction extends ActionSupport {
	
	private PasteService pasteService;
	private UserService userService;
	private Integer currentPage;
	
	public PasteService getPasteService() {
		return pasteService;
	}

	public void setPasteService(PasteService pasteService) {
		this.pasteService = pasteService;
	}
	
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getPaste() throws Exception {
		PageBean pastePageBean = pasteService.getPasteOageBean(currentPage);
		ActionContext.getContext().put("pastePageBean", pastePageBean);
		
		// �ȶ�����
		PageBean glanceoverPageBean = pasteService.getGlanceoverPageBean(currentPage);
		ActionContext.getContext().put("glanceoverPageBean", glanceoverPageBean);
		
		// ��������
		PageBean ansnumPageBean = pasteService.getAnsnumPageBean(currentPage);
		ActionContext.getContext().put("ansnumPageBean", ansnumPageBean);
		
		// ר�����а�
		PageBean userPageBean = userService.getUserPageBean(currentPage);
		ActionContext.getContext().put("userPageBean", userPageBean);
		
		return "index";
	}
	
	public String getAllPaste() throws Exception {
		List<Paste> pasteList = pasteService.findAllPaste();	
		ActionContext.getContext().put("pasteList", pasteList);
		return "index";
	}
}
