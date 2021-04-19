package app;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;

import data.Vaihtoehto;


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
    
	public void printOptionList(PrintWriter out, ArrayList<Vaihtoehto> list) {
		out.println("<ul>");
		for (Vaihtoehto g:list) {
			out.println("<li>"+g);
		}
		out.println("</ul>");
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
			//Connection conn=null;

	

			try {
				Dao dao = new Dao();
				dao.openDataBase();
				ArrayList<Vaihtoehto> list=dao.readAllOption();
				printOptionList(out, list);
				dao.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


	
  }

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
