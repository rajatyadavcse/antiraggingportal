package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Complain;
import model.ComplainDAO;

/**
 * Servlet implementation class GetAllComplains
 */
@WebServlet("/GetAllComplains")
public class GetAllComplains extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllComplains() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ComplainDAO cdao=new ComplainDAO();
		response.setContentType("text/html");
		List complains = cdao.getAllComplains();
		PrintWriter out = response.getWriter();
		out.print("<table bgcolor=grey width=100%><tr><th>");
		out.print("Compalain Id"+"</th>");
		out.print("<th>Compalainant Name"+"</th>");
		out.print("<th>Date Of Complain"+"</th></tr>");
		int temp=1;
		for(Object complain:complains) {
			Complain c = (Complain)complain;
			if(temp++%2==0)
				out.print("<tr bgcolor=silver>");
			else
				out.print("<tr bgcolor=white>");
			out.print("<td>");
			out.print(c.getId()+"</td>");
			out.print("<td>"+c.getcomplainantName()+"</td>");
			out.print("<td>"+c.getRegisteredOn()+"</td>");
			out.print("<td><a href=#>"+"Response"+"</a></td><tr> ");
		}
		out.print("</table>");
	}

}
