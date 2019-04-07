package fyp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup implements Servlet {

    /**
     * Default constructor. 
     */
    public Signup() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			String Name=request.getParameter("Full Name");
			String Address=request.getParameter("Address");
			String phone = request.getParameter("Phone");
			String Email=request.getParameter("email");
			String username = request.getParameter("uname");
			String Password=request.getParameter("psw");
			String repeatpassword=request.getParameter("psw-repeat");
			String sql="INSERT INTO `registration`(`Name`, `Address`, `Phone`, `Email`, `UserName`, `Password`) VALUES(?,?,?,?,?,?)";
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/Signup","root","");
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1,Name);
			ps.setString(2,Address);
			ps.setString(3, phone);
			ps.setString(4,Email);
			ps.setString(5,username);
			ps.setString(6,Password);
			ps.executeUpdate();
			PrintWriter out = response.getWriter();
			RequestDispatcher rs= request.getRequestDispatcher("Login.jsp");
			out.write("<p id='errMsg' style='color: Black; font-size: larger;align-text:center'>congratulation!plz login for further....</p>");
            rs=request.getRequestDispatcher("Login.jsp");
            rs.include(request, response);
		
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
