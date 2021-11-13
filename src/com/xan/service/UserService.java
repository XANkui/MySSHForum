package com.xan.service;

import java.util.List;

import com.xan.dao.UserDao;
import com.xan.domain.User;
import com.xan.utils.PageBean;

public class UserService {

	private UserDao userDao;
	
	public void addUser(User user) {
		userDao.addUser(user);
		
	}
	
	public boolean findUserByUsername(String username) {
		Long count = userDao.findUserByUsername(username);
		return count==0?true:false;
	}
	
	public User findUserByUser(User user) {
		
		return userDao.findUserByUser(user);
	}

	public int checkUser(User user) {
		User retUser = userDao.findUserByUser(user);
		if(retUser==null) {
			return 1; // �û�������
		}
		
		if(user.getPassword().equals(retUser.getPassword())) {
			
			if(retUser.getState()==0) { // δ����
				
				return 3;
				
			}else {		// ���Ե�¼
				return 0;
			}
		}else { // �������
			return 2;
		}

	}

	public void activeUser(String userCode) {
		// TODO Auto-generated method stub
		userDao.activeUser(userCode);
	}
	
	
	public UserDao getUserDao() {
		return userDao;
	}
	
	

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public PageBean getUserPageBean(Integer currentPage) {
		Integer totalPageBean = userDao.findAllUserNum();
		PageBean userPageBean = new PageBean(8,currentPage,totalPageBean);
		List<User> list = userDao.getUserPageBean();
		userPageBean.setList(list);
		return userPageBean;
	}


}
