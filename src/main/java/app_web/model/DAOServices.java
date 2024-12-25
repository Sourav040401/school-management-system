package app_web.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOServices {
private Connection con;
private Statement stat;

public void connectDB() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
				e.printStackTrace();
	}
	try {
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/app_web","root","040401");
		
		stat=con.createStatement();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
public boolean verifyLogin(String email,String password) {
	    try {
	    	
		ResultSet result=stat.executeQuery("select * from  login where email='"+email+"'and password='"+password+"'");
		return result.next();
		
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	
	    return false;
} 
public void closeconnectDB() {
	try {
		con.close();
	} catch (Exception e) {
				e.printStackTrace();
	}
}
public void addStudent(String name,String email,String mobile) {
	try {
		stat.executeUpdate("insert into student values('"+name+"','"+email+"','"+mobile+"')");
		}
	catch(Exception e) {
		e.printStackTrace();
	}
}
public ResultSet getAllStudents() {
	try {
		ResultSet result=stat.executeQuery("select * from student ");
		return result;
		}
	catch(Exception e) {
		e.printStackTrace();
	}
	return null;
}
public void deleteStudentInfo(String email) {
	try {
		stat.executeUpdate("delete from student where email='"+email+"' ");
	
		}
	catch(Exception e) {
		e.printStackTrace();
	}
	
}
public void updateStudent(String email, String mobile) {
	
	try {
		stat.executeUpdate("update student set mobile='"+mobile+"' where email='"+email+"' ");
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
}
