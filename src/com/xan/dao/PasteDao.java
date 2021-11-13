package com.xan.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.xan.domain.Paste;

public class PasteDao extends HibernateDaoSupport {

	public void addPaste(Paste paste) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.save(paste);
		
	}

	public List<Paste> findAllPaste() {

		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String hql = "from com.xan.domain.Paste";
		Query query = session.createQuery(hql);
		List<Paste> list = query.list();
		
		return list;
	}

	public Integer findAllPasteNum() {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String sql = "select count(*) from paste";
		NativeQuery<BigInteger> query = session.createSQLQuery(sql);
		BigInteger result = query.uniqueResult();
		return result.intValue();
	}

	public List<Paste> getPastePageList(Integer startIndex, Integer pageSize) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String sql = "select * from paste limit ?,?";
		NativeQuery query = session.createSQLQuery(sql);
		query.addEntity(Paste.class);
		query.setParameter(1, startIndex);
		query.setParameter(2, pageSize);
		List list = query.list();
		return list;
	}

	public List<Paste> getGlanceoverPageList() {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String sql = "select * from paste order by glanceover desc limit 0,8";
		NativeQuery query = session.createSQLQuery(sql);
		query.addEntity(Paste.class);
		List list = query.list();
		
		return list;
	}

	public List<Paste> getAnsnumPageList() {
		
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String sql = "select * from paste order by ansnum desc limit 0,8";
		NativeQuery query = session.createSQLQuery(sql);
		query.addEntity(Paste.class);
		List list = query.list();
		
		return list;
	}

	public Paste findPasteById(String pasteid) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String sql = "select * from paste where id = ?";
		NativeQuery query = session.createSQLQuery(sql);
		query.addEntity(Paste.class);
		query.setParameter(1, pasteid);
		Paste result = (Paste) query.uniqueResult();
		return result;
	}

	public void addPasteGlanceover(String pasteid) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String sql = "update paste set glanceover = glanceover+1 where id = ?";
		NativeQuery query = session.createSQLQuery(sql);
		query.setParameter(1, pasteid);
		query.executeUpdate();
		
	}

	public void solvePasteByIdAndAnswerid(String pasteid, String answerid) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String sql = "update paste set solve = 1 , answerid = ? where id = ?";
		NativeQuery query = session.createSQLQuery(sql);
		query.setParameter(1, answerid);
		query.setParameter(2, pasteid);
		query.executeUpdate();
		
	}

}
