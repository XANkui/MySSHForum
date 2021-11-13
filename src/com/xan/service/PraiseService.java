package com.xan.service;

import com.xan.dao.PraiseDao;
import com.xan.domain.Praise;

public class PraiseService {

	private PraiseDao praiseDao;
	
	
	
	public PraiseDao getPraiseDao() {
		return praiseDao;
	}



	public void setPraiseDao(PraiseDao praiseDao) {
		this.praiseDao = praiseDao;
	}



	public void addPraise(Praise praise) {
		praiseDao.addPraise(praise);
		
	}



	public boolean findPraiseByUseridAndAnswerid(String userid, String answerid) {
		Praise praise = praiseDao.findPraiseByUseridAndAnswerid( userid,  answerid);
		return praise!=null?true:false;
	}



	public void deletePraise(Praise praise) {
		// TODO Auto-generated method stub
		praiseDao.deletePraise(praise);
	}

}
