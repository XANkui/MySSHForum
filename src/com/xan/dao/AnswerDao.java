package com.xan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.xan.domain.Answer;

public class AnswerDao extends HibernateDaoSupport {

	public void addAnswer(Answer answer) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.save(answer);
	}

	public List<Answer> findAllAnswerByPasteid(String pasteid) {

		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String sql = "select * from answer where pasteid = ?";
		NativeQuery<Answer> query = session.createSQLQuery(sql);
		query.addEntity(Answer.class);
		query.setParameter(1, pasteid);
		List<Answer> answerList = query.list();
		
		return answerList;
	}

	public void deleteAnswer(String answerid) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String sql = "delete from answer where id = ?";
		NativeQuery query = session.createSQLQuery(sql);
		query.setParameter(1, answerid);
		query.executeUpdate();
		
		// É¾³ý·½·¨¶þ
		//session.delete(answerid,Answer.class);
		
	}

	public Answer findAnswerByAnswerid(String answerid) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String sql = "select * from answer where id = ?";
		NativeQuery query = session.createSQLQuery(sql);
		query.addEntity(Answer.class);
		query.setParameter(1, answerid);
		Answer answer = (Answer) query.uniqueResult();
		return answer;
	}

}
