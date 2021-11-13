package com.xan.domain;

import java.util.HashSet;
import java.util.Set;

public class Paste {
	private String id;
	private String title;
	private String content;
	private Integer offer;
	private Integer ansnum;
	private String createtime;
	private Integer glanceover;
	private String answerid;
	
	// ÊÇ·ñ½áÌù
	private Integer solve;
	private Integer isdelete;
	
	private Set<User> userAnswerSet = new HashSet<User>();
	
	private User user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getOffer() {
		return offer;
	}

	public void setOffer(Integer offer) {
		this.offer = offer;
	}

	public Integer getAnsnum() {
		return ansnum;
	}

	public void setAnsnum(Integer ansnum) {
		this.ansnum = ansnum;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public Integer getGlanceover() {
		return glanceover;
	}

	public void setGlanceover(Integer glanceover) {
		this.glanceover = glanceover;
	}

	public String getAnswerid() {
		return answerid;
	}

	public void setAnswerid(String answerid) {
		this.answerid = answerid;
	}

	public Integer getSolve() {
		return solve;
	}

	public void setSolve(Integer solve) {
		this.solve = solve;
	}

	public Integer getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

	public Set<User> getUserAnswerSet() {
		return userAnswerSet;
	}

	public void setUserAnswerSet(Set<User> userAnswerSet) {
		this.userAnswerSet = userAnswerSet;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Paste [id=" + id + ", title=" + title + ", content=" + content + ", offer=" + offer + ", ansnum="
				+ ansnum + ", createtime=" + createtime + ", glanceover=" + glanceover + ", answerid=" + answerid
				+ ", solve=" + solve + ", isdelete=" + isdelete + ", userAnswerSet=" + userAnswerSet + ", user=" + user
				+ "]";
	}
	
	
	
	
	
	
}
