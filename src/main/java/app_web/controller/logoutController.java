package app_web.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/logoutController")
public class logoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public logoutController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		RequestDispatcher rd =request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
		HttpSession session=request.getSession(false);
	    session.invalidate();
	}

}
