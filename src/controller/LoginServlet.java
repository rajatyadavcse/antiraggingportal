package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserLogin;
import model.UserLoginDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("userName");
		String password=request.getParameter("password");
		UserLogin userLogin = new UserLogin();
		userLogin.setUsername(username);
		userLogin.setPassword(password);
	    UserLogin user=new UserLoginDAO().authenticateUser(userLogin);
	    if(user!=null) {
	    if(user.getUserRole().getRoleType().equals("admin")) {
	    	HttpSession session = request.getSession();
	    	session.setMaxInactiveInterval(10*60);
	    	session.setAttribute("user", user);
	        request.getRequestDispatcher("/admin_dashboard.jsp").forward(request, response);
	    }
	    else if(user.getUserRole().getRoleType().equals("student")) {
	    	HttpSession session = request.getSession();
	    	session.setMaxInactiveInterval(10*60);
	    	session.setAttribute("user",user);
	        request.getRequestDispatcher("/student_dashboard2.jsp").forward(request, response);	    	
	    }
	    else if(user.getUserRole().getRoleType().equals("college_admin")) {
	    	HttpSession session = request.getSession();
	    	session.setMaxInactiveInterval(10*60);
	    	session.setAttribute("user",user);
	        request.getRequestDispatcher("/siteadmin_dashboard.jsp").forward(request, response);	    	
	    }
	    }
	    else
	    {
	     request.setAttribute("loginFail", "username or password is incorrect...");
	     request.getRequestDispatcher("/login.jsp").forward(request, response);
	    }
	
	}
}