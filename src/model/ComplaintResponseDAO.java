package model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Projections;

public class ComplaintResponseDAO {
		public Session getSession() {
			AnnotationConfiguration con = new AnnotationConfiguration();
			con.configure("hibernate.cfg.xml");
			Session session = con.buildSessionFactory().openSession();
			return session;
		}
		
	public void addComplaintResponse(ComplaintResponse response) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		Query q = session.createQuery("SELECT r FROM ComplaintResponse r WHERE r.complainId=:id");
		q.setInteger("id", response.getComplainId());
		List result = q.list();
		System.out.println(result.size());
		ComplaintResponse res=null;
		if(result.size()>0) {
			for(Object x:result) {
				res=(ComplaintResponse)x;
				res.setStatus(response.getStatus());
				res.setAction(response.getAction());
			}
			
		}
		else
			session.persist(response);
		transaction.commit();
		session.close();
	}
	
	public ComplaintResponse getResponseByComplaintId(int id) {
		Session session = getSession();
		ComplaintResponse response = (ComplaintResponse) session.get(ComplaintResponse.class, id);
		session.close();
		return response;
	}
	
	public int getComplaintResponseCount() {
		Session session = getSession();
		int n = (int)session.createCriteria("ComplaintResponse").setProjection(Projections.rowCount()).uniqueResult();
		session.close();
		return n;
	}
	public ComplaintResponse getComplaintResponseByComplainId(int complainId) {
		Session session = getSession();
		Query q = session.createQuery("SELECT r FROM ComplaintResponse r WHERE r.complainId=:c");
		q.setInteger("c", complainId);
		List result = q.list();
		ComplaintResponse res=null;
		for(Object x:result) {
			res=(ComplaintResponse)x;
		}
		return res;
	}
}

