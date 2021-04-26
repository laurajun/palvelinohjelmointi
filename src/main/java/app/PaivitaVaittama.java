package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
    	
    	for (Claim g:list) {
    		out.println("<div class=\"action\">\r\n"
    				+ "        <h2>Muokkaa väittämää</h2>\r\n"
    				+ "        <form action=\"PaivitaVaittama\" method=\"post\">\r\n"
    				+ "     \r\n"
    				+ "        \r\n"
    				+ "        <table class=\"tabledb\">\r\n"
    				+ "            <caption>\r\n"
    				+ "                <h3>Muokkaa väittämää</h3>\r\n"
    				+ "            </caption>            \r\n");
    		
    				out.println("<input type=\"hidden\" name=\"id\" value=+g.getId()+\" /> ");
    				                       
    								<tr>\r\n"
    				+ "                <th>ID: </th>\r\n"
    				+ "                <td>\r\n"
    				+ "                    <input type=\"text\" name=\"id\" size=\"3\"\r\n"
    				+ "                            value=\"<c:out value='${request.getParameter(\"id\")}' />\"\r\n"
    				+ "                        />\r\n"
    				+ "                </td>\r\n"
    				+ "            </tr>\r\n"
    				+ "            <tr>\r\n"
    				+ "                <th>Väittämä: </th>\r\n"
    				+ "                <td>\r\n"
    				+ "                    <input type=\"text\" name=\"vaittama\" size=\"300\"\r\n"
    				+ "                            value=\"<c:out value='${vaittamat.vaittama}' />\"\r\n"
    				+ "                    />\r\n"
    				+ "                </td>\r\n"
    				+ "            </tr>\r\n"
    				+ "            \r\n"
    				+ "            <tr>\r\n"
    				+ "                <td colspan=\"2\" align=\"center\">\r\n"
    				+ "                    <input type=\"submit\" value=\"Tallenna\" />\r\n"
    				+ "                </td>\r\n"
    				+ "            </tr>\r\n"
    				+ "          \r\n"
    				+ "        </table>\r\n"
    				+ "        \r\n"
    				+ "    </div>");
//			out.println("<tr><td>"+g.getId()+"</td><td>"+g.getClaim()+"</td>");
		}
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String vaittama=request.getParameter("vaittama");
        int id=Integer.parseInt(request.getParameter("id"));			
		Dao dao = new Dao();
		dao.PaivitaVaittama(vaittama, id);
		dao.close();
		String destPage = "/ListClaims";
		response.sendRedirect(destPage);
		
		PrintWriter out=response.getWriter();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}

}
