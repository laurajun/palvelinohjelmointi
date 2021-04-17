package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ListOptions
 */
@WebServlet("/ListOptions")
public class ListOptions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListOptions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		/*
		 * With a RequestDispatcher object is the htmlstart.html file included to this servlet
		 */
		RequestDispatcher rd=request.getRequestDispatcher("htmlstart.html");
		rd.include(request,  response);;
		
		/* 
		 * Connection is the object to keep the connection to the database
		 */
		Connection conn=null;
		try {
			/* 
			 * As not using the database connection pool, can the connection be caught like this
			 * At first, this loads MySQL driver to the container
			 * and secondly getting connection to the mysql server and database gamedb at the localhost
			 * Port number is 3306 by default
			 */
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String hostname = System.getProperty("sqlshostname");
			String serverport = System.getProperty("sqlserverport");
			String database = System.getProperty("sqldatabasename");
			String username = System.getProperty("sqlusername");
			String password = System.getProperty("sqlpassword");
			conn=java.sql.DriverManager.getConnection("jdbc:mysql://"+hostname+":"+serverport+"/"+database,username,password);
			
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from vaihtoehdot");
			out.println("<ol>");
			/*
			 * Looping through all the rows and printing the values of the columns breed and weight
			 * All the data in the columns can be read as String (getString). If there is a need to
			 * read integers or floats, can getInt or getFloat be used. And there are quite many 
			 * different functions to retrieve data.
			 */
			while (rs.next()){
				out.println("<li>"+rs.getString("id")+" ("+rs.getString("vaihtoehto")+")");
			}	  
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		out.println("<a href='./addgame.html'>Back to form</a>");

		/*
		 * With a RequestDispatcher object is the htmlend.html file included to this servlet
		 */
		rd=request.getRequestDispatcher("htmlend.html");
		rd.include(request,  response);;
  }

  /**
   * 
   * @param conn Connection to the database
   * @param stmt Object to execute the sql commands
   * @param breed breed of the game
   * @param weight weight of the game
   * @return number of inserted rows
   * @throws SQLException
   */
	private int saveTheGame(Connection conn, Statement stmt, String breed, String weight) throws SQLException {
		// TODO Auto-generated method stub
		/*
		 * Executing insert statement
		 * Though the weight column in the database is of type decimal, a String can be inserted
		 */
		int count=stmt.executeUpdate("insert into gametable(breed, weight) values('"+breed+"', "+weight+")");
		return count; //Return the number of inserted rows (here it is 1)
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
