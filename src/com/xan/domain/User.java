package com.xan.domain;

import java.util.HashSet;
import java.util.Set;

public class User {
	
	private String id;
	private String username;
	private String password;
	private String name;
	private String email;
	private String telephone;
	private Integer state;
	private String code;
	private String image;
	private Integer level;
	private Integer coin;

	private Set<Paste> pasteSet = new HashSet<Paste>();
	private Set<Paste> ansPasteSet = new HashSet<Paste>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getCoin() {
		return coin;
	}
	public void setCoin(Integer coin) {
		this.coin = coin;
	}
	
	public Set<Paste> getPasteSet() {
		return pasteSet;
	}
	
	public void setPasteSet(Set<Paste> pasteSet) {
		this.pasteSet = pasteSet;
	}

	public Set<Paste> getAnsPasteSet() {
		return ansPasteSet;
	}
	public void setAnsPasteSet(Set<Paste> ansPasteSet) {
		this.ansPasteSet = ansPasteSet;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", email="
				+ email + ", telephone=" + telephone + ", state=" + state + ", code=" + code + ", image=" + image
				+ ", level=" + level + ", coin=" + coin + "]";
	}
	
	
	
	
	
}
