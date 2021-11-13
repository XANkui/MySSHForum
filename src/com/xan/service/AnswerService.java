package com.xan.service;

import java.rmi.Remote;
import java.util.List;

import com.xan.dao.AnswerDao;
import com.xan.dao.PasteDao;
import com.xan.domain.Answer;
import com.xan.domain.Paste;

public class AnswerService {

	private AnswerDao answerDao;
	private PasteDao pasteDao;
	public AnswerDao getAnswerDao() {
		return answerDao;
	}

	public void setAnswerDao(AnswerDao answerDao) {
		this.answerDao = answerDao;
	}
	
	public PasteDao getPasteDao() {
		return pasteDao;
	}

	public void setPasteDao(PasteDao pasteDao) {
		this.pasteDao = pasteDao;
	}

	public void addAnswer(Answer answer,Paste paste) {
		paste.setAnsnum(paste.getAnsnum()+1);
		answerDao.addAnswer(answer);
		
	}

	public List<Answer> findAllAnswerByPasteid(String pasteid) {

		Paste paste = pasteDao.findPasteById(pasteid);
		List<Answer> answerList = answerDao.findAllAnswerByPasteid(pasteid);;

		if(paste.getSolve()==1) {
			System.out.println("paste.toString() £º " + paste.toString());
			Answer answer = answerDao.findAnswerByAnswerid(paste.getAnswerid());
			answerList.remove(answer);
			System.out.println(answerList.size());
			answerList.add(0,answer);
			System.out.println(answerList.size());
		}

		return answerList;
	}

	public void deleteAnswer(String answerid,Paste paste) {
		paste.setAnsnum(paste.getAnsnum()-1);
		answerDao.deleteAnswer(answerid);
		
	}

	public Answer findAnswerByAnswerid(String answerid) {
		Answer answer = answerDao.findAnswerByAnswerid(answerid);
		return answer;
	}

	public void addAnswerAgreeByAnswerid(String answerid) {
		Answer answer = answerDao.findAnswerByAnswerid(answerid);
		answer.setAgree(answer.getAgree()+1);
		// update answer set agree = agree + 1;
	}

	public void deleteAnswerAgreeByAnswerid(String answerid) {
		Answer answer = answerDao.findAnswerByAnswerid(answerid);
		answer.setAgree(answer.getAgree()-1);
	}

	

}
