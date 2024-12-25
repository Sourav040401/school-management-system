package app_web.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import app_web.model.DAOServices;


@WebServlet("/login")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public loginController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		DAOServices service=new DAOServices();
		service.connectDB();
		boolean status=service.verifyLogin(email,password);
		if(status) {
			HttpSession session= request.getSession(true);
			session.setAttribute("email",email);
			RequestDispatcher rd= request.getRequestDispatcher("WEB-INF/views/student_registration.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("error","invalid email or password");
			RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			
		}
	}

}
