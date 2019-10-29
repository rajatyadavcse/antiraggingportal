package com.anti.ragging;

import org.hibernate.Query;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

public class ComplainIdGenerator {
	public Session getSession() {
		AnnotationConfiguration con = new AnnotationConfiguration();
		con.configure("hibernate.cfg.xml");
		Session session = con.buildSessionFactory().openSession();
		return session;
	}
	public int randomIdGenerator() {
		int n = (int) (100000 + Math.random() * 900000);
		return n;
	}
	public boolean checkRandomId(int n) {
		Session session = getSession();
		Query q = session.createQuery("SELECT c FROM Complain c WHERE c.id=:id");
		q.setInteger("id", n);
		int m=q.list().size();
		session.close();
		if(m>0)
			return false;
		else 
			return true;
		
	}
	public int generateComplainId() {
		int n=randomIdGenerator();
		if(checkRandomId(n))
			return n;
		else
			generateComplainId();
		return n;
	}
}
