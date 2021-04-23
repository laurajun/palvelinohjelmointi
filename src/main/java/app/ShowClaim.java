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
import data.Vaihtoehto;

/**
 * Servlet implementation class ShowClaim
 */
@WebServlet("/ShowClaim")
public class ShowClaim extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowClaim() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void printClaim(PrintWriter out, ArrayList<Claim> list, ArrayList<Vaihtoehto> optionlist) {
		out.println("<table class='tabledb' border=1>");
		out.println("<tr><td><b>ID</b></td><td>Väittämä</td><td>Vaihtoehto 1</td><td>Vaihtoehto 2</td><td>Vaihtoehto 3</td><td>Vaihtoehto 4</td><td>Vaihtoehto 5</td></tr>");
		for (Claim g:list) {
			out.println("<tr><td>"+g.getId()+"</td><td>"+g.getClaim()+"</td>");
		}
		for (Vaihtoehto v:optionlist ) {
			out.println("<td>"+v.getVaihtoehto()+"</td>");
		}
		out.println("</tr>");
		out.println("</table>");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		PrintWriter out=response.getWriter();
		RequestDispatcher rd=request.getRequestDispatcher("htmlstart.html");
		rd.include(request,  response);
		try {
			Dao dao = new Dao();
			ArrayList<Claim> list=dao.ShowSingleClaim(id);
			ArrayList<Vaihtoehto> optionlist=dao.readAllOption();
			printClaim(out, list, optionlist);
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
