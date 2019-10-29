package model;
import java.util.TreeSet;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

public class FeedBackDAO {
		public Session getSession() {
			AnnotationConfiguration con = new AnnotationConfiguration();
			con.configure("hibernate.cfg.xml");
			Session session = con.buildSessionFactory().openSession();
			return session;
		}
		
		public void addFeedback(Feedback feedback) {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			session.persist(feedback);
			transaction.commit();
			session.close();
		}
		
		public Feedback getFeedbackById(int id) {
			Session session = getSession();
			Feedback feed = (Feedback) session.get(Feedback.class, id);
			session.close();
			return feed;
		}
		
		public void getAllFeedback() {
			Session session = getSession();
			Query q = session.createQuery("FROM Feedback");
 			session.close();
		}
}
