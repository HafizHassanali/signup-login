package fyp;

import java.awt.Window;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.Servlet.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login implements Servlet {
	
	private static final String CONTENTTYPE = "text/html; charset=UTF-8";
	private String username=null;
	private String Password=null;
	private Connection conn = null;

    /**
     * Default constructor. 
     */
    public Login() {
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
			 //response.setContentType(CONTENTTYPE);
			 PrintWriter out = response.getWriter();
			 username = request.getParameter("uname");
			 Password=request.getParameter("psw");
			 
			 boolean rs1=checkpassword(username,Password);
			 RequestDispatcher rs=null;
			 
//			 out.println("<html>");
//			 out.print("<body>");
//			 
			 if(rs1==true && username.matches(username) ){
				 out.write("<p id='errMsg' style='color: White; font-size: larger;'>congratulation!"+username+"</p>");
		            rs=request.getRequestDispatcher("/uploadfile.jsp");
		            rs.include(request, response);
		            
				}else
					if(username == null||Password == null || "".equals(username)){				
					out.write("<p id='errMsg' style='color: red; font-size: larger;'>Please Enter Both Username & Password... !</p>");
		             rs = request.getRequestDispatcher("/Login.jsp");
		             rs.include(request, response);
					}
					else {
			            out.write("<html><body><div><form><p id='errMsg' style='color: red; font-size: larger; align:center;margin-bottom:10px;'>You are not an authorised user! Please check with administrator!</p>");
			            rs = request.getRequestDispatcher("/Login.jsp");
			            rs.include(request, response);
			        }
			    out.write("</form></div></body></html>");
		        out.close();
	}

	private boolean checkpassword(String username, String password) {
		// TODO Auto-generated method stub
		String correctpassword=null;
		 
		String sql="SELECT  `Password` FROM `registration` WHERE UserName='"+username+"'";
		try{
			try {
			Class.forName("com.mysql.jdbc.Driver");
			conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/Signup","root","");
		    conn.setAutoCommit(true);
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.getMessage();
			System.out.println("connection failed"+e.toString());
		} 
	        Statement ps = conn.createStatement();
			ps.executeQuery(sql);
			ResultSet rs= ps.getResultSet();
			
			if(rs.next()){
				correctpassword = rs.getString(1);
				System.out.println(correctpassword);
			}
			ps.close();
			if(correctpassword.equals(password) ){
				return true;
			}else{
				System.out.println("error");
				return false;
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("exception in verify password()="+e.toString());
			return false;
		}
	}
}
