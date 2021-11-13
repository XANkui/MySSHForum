package com.xan.dao;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.xan.domain.Praise;

public class PraiseDao extends HibernateDaoSupport{

	public void addPraise(Praise praise) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		
		session.save(praise);
	}

	public Praise findPraiseByUseridAndAnswerid(String userid, String answerid) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String sql = "select * from praise where userid = ? and answerid = ?";
		NativeQuery query = session.createSQLQuery(sql);
		query.addEntity(Praise.class);
		query.setParameter(1, userid);
		query.setParameter(2, answerid);
		Praise praise = (Praise) query.uniqueResult();
		return praise;
	}

	public void deletePraise(Praise praise) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.delete(praise);
	}

}
