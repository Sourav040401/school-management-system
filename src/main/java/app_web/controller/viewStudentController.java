package app_web.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;

import app_web.model.DAOServices;


@WebServlet("/listStudent")
public class viewStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public viewStudentController() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession(false);
		if(session.getAttribute("email")!=null) 
		{
		DAOServices service= new DAOServices();
		service.connectDB();
		ResultSet result=service.getAllStudents();
		request.setAttribute("result", result);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/list_registration.jsp");
		rd.forward(request, response);
		}
		else {
			RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
	    	 rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
