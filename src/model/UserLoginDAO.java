package model;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
public class UserLoginDAO {

	public Session getSession() {
		AnnotationConfiguration con = new AnnotationConfiguration();
		con.configure("hibernate.cfg.xml");
		Session session = con.buildSessionFactory().openSession();
		return session;
	}
	public void addUserLogin(UserLogin userLogin) {
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		session.persist(userLogin);
		trans.commit();
		System.out.println("done");
		session.close();
	}
	public UserLogin findUserLoginByUserName(String username) {
		Session session = getSession();
		Query q = session.createQuery("SELECT userLogin FROM UserLogin userLogin WHERE userLogin.userName=:u");
		q.setString("u",username);
		UserLogin u=null;
		for(Object x:q.list()) {
			 u=(UserLogin)x;
		}
		return u;
	}
	public UserLogin authenticateUser(UserLogin userLogin) {
		Session session = getSession();
		Query q = session.createQuery("SELECT user FROM UserLogin user WHERE user.username=:u and user.password=:p");
		q.setString("u", userLogin.getUsername());
		q.setString("p", userLogin.getPassword());
		List result = q.list();
		UserLogin user=null;
		for(Object x:result) {
			user=(UserLogin) x;
		}
        return user;
			}
	public String findPasswordByEmailId(String email) {
		Session session = getSession();
		Query q = session.createQuery("SELECT u FROM UserLogin u WHERE u.username=:e");
		q.setString("e", email);
		List result = q.list();
		String pass=null;
		for(Object x:result) {
			UserLogin u=(UserLogin)x;
			pass=u.getPassword();
		}
		return pass;
	}
	public void changePasswordById(int id,String password) {
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		UserLogin user=(UserLogin) session.get(UserLogin.class, id);
		user.setPassword(password);
		session.persist(user);
		trans.commit();
		session.close();
	}
}
