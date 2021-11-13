package com.xan.domain;

public class Answer {
	
	private String id;
	private String content;
	private String anstime;
	private Integer agree;
	private Integer solve;
	
	private User user;
	private Paste paste;
	
	private Integer loginUserIsAgree; //登录用户是否点赞该回复 该字段为辅助字段，不需要保存到数据库中
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAnstime() {
		return anstime;
	}
	public void setAnstime(String anstime) {
		this.anstime = anstime;
	}
	public Integer getAgree() {
		return agree;
	}
	public void setAgree(Integer agree) {
		this.agree = agree;
	}
	public Integer getSolve() {
		return solve;
	}
	public void setSolve(Integer solve) {
		this.solve = solve;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Paste getPaste() {
		return paste;
	}
	public void setPaste(Paste paste) {
		this.paste = paste;
	}
	
	
	
	public Integer getLoginUserIsAgree() {
		return loginUserIsAgree;
	}
	public void setLoginUserIsAgree(Integer loginUserIsAgree) {
		this.loginUserIsAgree = loginUserIsAgree;
	}
	@Override
	public String toString() {
		return "Answer [id=" + id + ", content=" + content + ", anstime=" + anstime + ", agree=" + agree + ", solve="
				+ solve + ", user=" + user + ", paste=" + paste + "]";
	}
	
	
}
