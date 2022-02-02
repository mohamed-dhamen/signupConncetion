package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.LoginConnection;
import com.beans.User;
import com.mysql.jdbc.log.Log;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				User user=new User();
				String nom=request.getParameter("nom");
				String prenom=request.getParameter("prenom");
				String email=request.getParameter("email");
				String pwd=request.getParameter("pwd");
				user.setName(prenom);
				user.setLasteName(nom);
				user.setEmail(email);
				user.setPwd(pwd);
				LoginConnection loginconnection=new LoginConnection();
				loginconnection.insUser(user);
				request.setAttribute("user",user);
				request.getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
			
	}

}
