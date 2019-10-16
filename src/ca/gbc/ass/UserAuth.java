package ca.gbc.ass;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class UserAuth
 */
@WebServlet("/UserAuth")
public class UserAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserAuth() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	
	 /*** @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//check session below
		String action = request.getParameter("action");
		String username = request.getParameter("name");
		String pswd = request.getParameter("password");
		String address = request.getParameter("address");
		String fn = request.getParameter("firstname");
		String ln = request.getParameter("lastname");
		//DataManager dm=new DataManager();
		System.out.println(action+"!");
		if(action.equals("logout")) 
			{
			System.out.println("Log out!");
			request.getSession().invalidate();
			PrintWriter out = response.getWriter();
			out.print("<h1 class=\"alert alert-danger\" role=\"alert\">You have already successfully logged out now!</h1>\r\n");
			request.getRequestDispatcher("login.jsp").include(request, response);
			}
		else if(action.equals("reg")) 
		{
			

			try 
			{
				String result=DataManager.regCheck(fn,ln,username,address,pswd);
				if(result!="good") {
				PrintWriter out = response.getWriter();
				out.print("<h1 class=\"alert alert-primary\" role=\"alert\">"+result+"</h1>\r\n");
				request.getRequestDispatcher("reg.jsp").include(request, response);
			}
				else if(DataManager.userNameCheck(username,pswd).equals("empty")) 
			{
				if(DataManager.clientReg(fn,ln,username,address,pswd).equals("success")) 
				{
					DataManager.sendFromGMail(username);
					PrintWriter out = response.getWriter();
					out.print("<h1 class=\"alert alert-primary\" role=\"alert\">You are registered,Please log in!</h1>\r\n");
					request.getRequestDispatcher("login.jsp").include(request, response);
					System.out.println("user created!!");
				}
			}else {
				PrintWriter out = response.getWriter();
				out.print("<h1 class=\"alert alert-primary\" role=\"alert\">User is already registered!Please log in!</h1>\r\n");
				request.getRequestDispatcher("login.jsp").include(request, response);
				System.out.println("user already exists, please log in!!");
			}
			}
			catch(Exception e){e.printStackTrace();}}
			else  if
			(action.equals("login"))
			{


			try {
				String role=DataManager.userNameCheck(username,pswd);
				if(role.compareTo("empty")==0) {response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("<h1 class=\"alert alert-danger\" role=\"alert\">Account not found!</h1>\r\n");
					request.getRequestDispatcher("login.jsp").include(request, response);
				}else if(role.compareTo("wrongpswd")==0) {
					PrintWriter out = response.getWriter();
					out.print("<h1 class=\"alert alert-danger\" role=\"alert\">Incorrect Password!</h1>\r\n");
					request.getRequestDispatcher("login.jsp").include(request, response);
					
				}else if(role.compareTo("admin")==0) {
					SessionCookieCoordinator.updateSession(request,username,pswd);
					request.getRequestDispatcher("adminhome.jsp").include(request, response);
					
				}else if(role.compareTo("client")==0) {
					SessionCookieCoordinator.updateSession(request,username,pswd);
					request.getRequestDispatcher("clientmain.jsp").include(request, response);	
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		
}
}