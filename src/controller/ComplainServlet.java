package controller;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.anti.ragging.ComplainIdGenerator;
import com.anti.ragging.MailAcknowledgement;

import model.Complain;
import model.ComplainDAO;
import model.UserDetailDAO;
import model.UserLogin;

/**
 * Servlet implementation class ComplainServlet
 */
@WebServlet("/ComplainServlet")
public class ComplainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String 	ComplainantName = request.getParameter("complaintName");
		String victimName = request.getParameter("victimName");
		String	email = request.getParameter("email");
		String	mobileNumber = request.getParameter("phoneNo");
		String	collegeName = request.getParameter("college");
		String 	yourAddress = request.getParameter("city");
		int	pincode = Integer.parseInt(request.getParameter("pinCode"));
		String 	state = request.getParameter("state");
		Date date = new Date();
		String raggingDetails = request.getParameter("complaint");
	    byte[]	photoProof=new byte[0];
	    HttpSession session = request.getSession(false);
	    UserLogin user = (UserLogin)session.getAttribute("user");
	    int id=new ComplainIdGenerator().generateComplainId();
	    Complain complain=new Complain(id,ComplainantName,victimName,email,mobileNumber,collegeName,yourAddress,pincode,state,date,raggingDetails,photoProof,user.getUserDetail().getId());
	    String fname=user.getUserDetail().getFirstName();
	   ComplainDAO cdao = new ComplainDAO();
	   cdao.addComplain(complain);
	    String to=user.getUserDetail().getEmail();
	    String message="hi"+" "+fname+" "+"you have added a complain which has a complain Id as"+" "+id+" "+"you can check status of complain with thid id";
	    MailAcknowledgement.sendMail(to, message);
	    response.sendRedirect("student_dashboard2.jsp");
	}

}
