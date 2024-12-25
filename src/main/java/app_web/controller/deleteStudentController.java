package app_web.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

import app_web.model.DAOServices;


@WebServlet("/deleteStudent")
public class deleteStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public deleteStudentController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String email=request.getParameter("email");
		
		DAOServices service= new DAOServices();
		service.connectDB();
		service.deleteStudentInfo(email);
		
		ResultSet result=service.getAllStudents();
		request.setAttribute("result", result);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/list_registration.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
