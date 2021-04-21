package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Just a comment for the video purposes
		PrintWriter out=response.getWriter();
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        String sqlhostname = System.getProperty("sqlhostname");
		String serverport = System.getProperty("sqlserverport");
		String database = System.getProperty("sqldatabasename");
		String sqlusername = System.getProperty("sqlusername");
		String sqlpassword = System.getProperty("sqlpassword");
		String url = "jdbc:mysql://"+sqlhostname+":"+serverport+"/"+database;
	 
		try{
			String destPage = "index.jsp";
		    Class.forName("com.mysql.jdbc.Driver");
		    Connection connection = DriverManager.getConnection(url, sqlusername, sqlpassword);
		    Statement st= connection.createStatement();
		    ResultSet rs=st.executeQuery("select * from logins where username='"+username+"' and password='"+password+"'");
		    
		    while(rs.next())
		    {
			    String fullname = rs.getString("fullname");
			    if(rs.getString("password").equals(password)&&rs.getString("username").equals(username))
			    {
			    
				    HttpSession session = request.getSession();
			        session.setAttribute("fullname", fullname);
			        destPage = "home.jsp";
			    }
			    else{
			    	HttpSession session = request.getSession();
			    	String message = "Invalid username and/or password";
			        session.setAttribute("message", message);
			        destPage = "index.jsp";
			        
			    }
			    
		    }
		    
		    RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
	        dispatcher.forward(request, response);
	    }
	    catch (Exception e) {
	    e.printStackTrace();
	    }
		
	}

}
