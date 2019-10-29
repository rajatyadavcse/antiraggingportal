package model;

import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Projections;

public class ComplainDAO {
	public Session getSession() {
		AnnotationConfiguration con = new AnnotationConfiguration();
		con.configure("hibernate.cfg.xml");
		Session session = con.buildSessionFactory().openSession();
		return session;
	}
	
	public void addComplain(Complain complain) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		session.persist(complain);
		transaction.commit();
		session.close();
	}
	
	public Complain getComplainById(int id) {
		Session session = getSession();
		Complain comp = (Complain) session.get(Complain.class, id);
		session.close();
		return comp;
	}
	
	public List getAllComplains() {
		Session session = getSession();
		Query q = session.createQuery("FROM Complain");
		List result = q.list();
		session.close();
		return result;	
	}
	public int getComplainsCount() {
		Session session = getSession();
		int n = (int)session.createCriteria("Complain").setProjection(Projections.rowCount()).uniqueResult();
		session.close();
		return n;
	}
	public Complain  findComplainStatusByComplainId(int complainId) {
		Session session = getSession();
		 Complain result = (Complain)session.get(Complain.class, complainId);
		 return result;
	}
	/*public void updateComplainByComplainId(int id,UserDetail u) {
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		Complain complain=(Complain) session.load(Complain.class, id);
		complain.setUserDetail(u);
		trans.commit();
		System.out.println("done");
		
	}*/
}

