package model;

import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

public class UserRoleDAO {
	public Session getSession() {
		AnnotationConfiguration con = new AnnotationConfiguration();
		con.configure("hibernate.cfg.xml");
		Session session = con.buildSessionFactory().openSession();
		return session;
	}
	public void addUserRole(UserRole userRole) {
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		session.save(userRole);
		trans.commit();
		session.close();
	}
}
