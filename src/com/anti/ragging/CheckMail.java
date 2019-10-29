package com.anti.ragging;

import org.hibernate.Query;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

public class CheckMail {
	public Session getSession() {
		AnnotationConfiguration con = new AnnotationConfiguration();
		con.configure("hibernate.cfg.xml");
		Session session = con.buildSessionFactory().openSession();
		return session;
	}
	public boolean checkMailAndPhoneNumber(String email,String number) {
		Session session = getSession();
		boolean b=false;
		Query q = session.createQuery("SELECT u FROM UserDetail u where u.email=:email");
		q.setString("email", email);
		Query q1 = session.createQuery("SELECT u FROM UserDetail u where u.phoneNumber=:number");
		q1.setString("number", number);
		int m=q.list().size();
		int n=q.list().size();
		System.out.println(n);
		System.out.println(m);
		if(n>0 || m>0) {
			session.close();
			return true;
		}
		else {
			session.close();
		    return b;
	}
	}
}
