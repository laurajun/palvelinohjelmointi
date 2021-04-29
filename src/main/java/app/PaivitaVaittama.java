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
 * Servlet implementation class PaivitaVaittama
 */
@WebServlet("/PaivitaVaittama")
public class PaivitaVaittama extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaivitaVaittama() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void MuokkaaVaittamaa(PrintWriter out, ArrayList<Claim> list){
    	
    	out.println("<div class=\"action\">\r\n"
    			+ "        <h2>Muokkaa väittämää</h2>\r\n"
    			+ "        <form action=\"PaivitaVaittama\" method=\"post\">\r\n"
    			+ "     \r\n"
    			+ "        \r\n"
    			+ "        <table class=\"tabledb\">\r\n");
    	
    	for (Claim g:list) {
    		
    				// out.println("<input type=\"hidden\" name=\"id\" value= /> ");
    //		<input type="hidden" name="id" value="<c:out value='${request.getParameter("id")}' />" />
    				out.println("<label for=\"vaittama\">Väittämä:</label>" + "<input type=\"hidden\" name=\"id\" value=\""+g.getId()+"\" />" + "<input type=\"text\" name=\"vaittama\" size=\"300\"\r\n"
    						+ "                            value=\""+g.getClaim()+"\" />");
    				         
		}
    	
    	out.println("<tr>\r\n"
    			+ "                <td colspan=\"2\" align=\"center\">\r\n"
    			+ "                    <input type=\"submit\" value=\"Tallenna\" />\r\n </form>" 
    			+ "                </td>\r\n"
    			+ "            </tr>\r\n"
    			+ "          \r\n"
    			+ "        </table>\r\n"
    			+ "        \r\n"
    			+ "    </div>");
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
        int id=Integer.parseInt(request.getParameter("id"));	
        PrintWriter out=response.getWriter();
        RequestDispatcher rd=request.getRequestDispatcher("htmlstart.html");
        rd.include(request,  response);
		Dao dao = new Dao();
		ArrayList<Claim> list=dao.ShowSingleClaim(id);
		MuokkaaVaittamaa(out, list);
		dao.close();
		
		rd=request.getRequestDispatcher("htmlend.html");
		rd.include(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		int id=Integer.parseInt(request.getParameter("id"));	
		String vaittama=request.getParameter("vaittama");
		
		Dao dao = new Dao();
		dao.PaivitaVaittama(vaittama, id);
		dao.close();
		String destPage = "/ListClaims";
		response.sendRedirect(destPage);
	}

}
