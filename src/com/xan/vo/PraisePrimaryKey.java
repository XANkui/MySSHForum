package com.xan.vo;

import java.io.Serializable;

import com.xan.domain.Answer;
import com.xan.domain.User;
 
// ��������Ҫ�̳�  Serializable �ӿ�
public class PraisePrimaryKey implements Serializable{
	
	private User user;
	private Answer answer;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Answer getAnswer() {
		return answer;
	}
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	
	
}
