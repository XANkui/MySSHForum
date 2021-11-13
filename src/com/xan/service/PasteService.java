package com.xan.service;

import java.util.List;

import com.xan.dao.AnswerDao;
import com.xan.dao.PasteDao;
import com.xan.domain.Answer;
import com.xan.domain.Paste;
import com.xan.domain.User;
import com.xan.utils.PageBean;


public class PasteService {
	private PasteDao pasteDao;
	private AnswerDao answerDao;

	public PasteDao getPasteDao() {
		return pasteDao;
	}

	public void setPasteDao(PasteDao pasteDao) {
		this.pasteDao = pasteDao;
	}
	
	public void addPaste(Paste paste) {
		// TODO Auto-generated method stub
		pasteDao.addPaste(paste);
	}


	public AnswerDao getAnswerDao() {
		return answerDao;
	}

	public void setAnswerDao(AnswerDao answerDao) {
		this.answerDao = answerDao;
	}

	public List<Paste> findAllPaste() {
		// TODO Auto-generated method stub
		return pasteDao.findAllPaste();
	}

	public PageBean getPasteOageBean(Integer currentPage) {
		Integer totalCount = pasteDao.findAllPasteNum();
		PageBean pageBean = new PageBean(8,currentPage, totalCount);
		List<Paste> list = pasteDao.getPastePageList(pageBean.getStartIndex(),pageBean.getPageSize());
		pageBean.setList(list); 
		return pageBean;
	}

	public PageBean getGlanceoverPageBean(Integer currentPage) {
		Integer totalCount = pasteDao.findAllPasteNum();
		PageBean glanceoverPageBean = new PageBean(currentPage,totalCount,8);
		List<Paste> list = pasteDao.getGlanceoverPageList();
		glanceoverPageBean.setList(list);
		
		return glanceoverPageBean;
	}

	public PageBean getAnsnumPageBean(Integer currentPage) {
		Integer totalCount = pasteDao.findAllPasteNum();
		PageBean ansnumPageBean = new PageBean(currentPage,totalCount,8);
		List<Paste> list = pasteDao.getAnsnumPageList();
		ansnumPageBean.setList(list);
		return ansnumPageBean;
	}

	public Paste findPasteById(String pasteid) {
		
		// 帖子浏览数 + 1
		//pasteDao.addPasteGlanceover(pasteid); // 帖子浏览数 + 1 方法一 
		Paste paste =pasteDao.findPasteById(pasteid);
		paste.setGlanceover(paste.getGlanceover()+1); // 帖子浏览数 + 1 方法二
		return paste;
	}

	public void solvePasteByIdAndAnswerid(String pasteid, String answerid) {
		// 给回复的人加金币
		Paste paste = pasteDao.findPasteById(pasteid);
		// 通过 Answer 查找  userid
		Answer answer = answerDao.findAnswerByAnswerid(answerid);
		pasteDao.solvePasteByIdAndAnswerid( pasteid,  answerid);
		// 给采纳的用户添加对应金币数（同时帖子主可能需要减去金币）
		User user = answer.getUser();
		user.setCoin(user.getCoin()+paste.getOffer());
		User pasteUser = paste.getUser();
		pasteUser.setCoin(pasteUser.getCoin()-paste.getOffer());
	}
	
}
