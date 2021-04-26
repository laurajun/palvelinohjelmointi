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
import data.Claim;

/**
 * Servlet implementation class ListClaims
 */
@WebServlet("/ListClaims")
public class ListClaims extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListClaims() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void printOptionList(PrintWriter out, ArrayList<Claim> list) {
		out.println("<table class='tabledb' border=1>");
		out.println("<tr><td><b>ID</b></td><td>Väittämä</td><td>Toiminnot</td></tr>");
		for (Claim g:list) {
			out.println("<tr><td><a href=\"/ShowClaim?id="+g.getId()+"\">"+g.getId()+"</a></td><td>"+g.getClaim()+"</td><td><a href=\"/PaivitaVaittama?id="+g.getId()+"\">Muokkaa</a>   <a href=\"/PoistaVaittama?id="+g.getId()+"\">Poista</a></td></tr>");
		}
		out.println("</table>");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		RequestDispatcher rd=request.getRequestDispatcher("htmlstart.html");
		rd.include(request,  response);
		try {
			Dao dao = new Dao();
			ArrayList<Claim> list=dao.listAllClaims();
			printOptionList(out, list);
			dao.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rd=request.getRequestDispatcher("htmlend.html");
		rd.include(request,  response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
