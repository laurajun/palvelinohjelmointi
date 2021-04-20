package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resql.PreparedStatement;

/**
 * Servlet implementation class AddClaim
 */
@WebServlet (
		name= "AddClaim",
		urlPatterns = {"/AddClaim"}
)

public class AddClaim extends HttpServlet {
       
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		doGet(request, response);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws IOException, ServletException {
		  response.setContentType("text/html");
		  PrintWriter out=response.getWriter();
  
		  /*
		   * With a RequestDispatcher object is the htmlstart.html file included to this servlet
		   */
		  RequestDispatcher rd=request.getRequestDispatcher("htmlstart.html");
		  rd.include(request,  response);

		  private ResultSet saveTheGame(Connection conn, int id, String vaittama) {
			// TODO Auto-generated method stub
			  String sql="insert into vaittama(id, vaittama) values(?,?)";
				try {
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, id);
					pstmt.setString(2,  vaittama);		
					pstmt.executeUpdate();
					
					ResultSet RS=pstmt.executeQuery("select * from vaittama");
					return RS;
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}

			/*
		 * With a RequestDispatcher object is the htmlend.html file included to this servlet
		 */
		rd=request.getRequestDispatcher("htmlend.html");
		rd.include(request,  response);;

}
