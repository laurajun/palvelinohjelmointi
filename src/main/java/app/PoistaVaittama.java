package app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;

/**
 * Servlet implementation class PoistaVaittama
 */
@WebServlet("/PoistaVaittama")
public class PoistaVaittama extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PoistaVaittama() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
								
				int sid=Integer.parseInt(request.getParameter("id"));
				
				Dao dao = new Dao();
				dao.PoistaVaittama(sid);
				dao.close();
				String siirrySivulle = "/ListClaims";
				response.sendRedirect(siirrySivulle);
	}

	/**
	 * @param sid 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response, String sid) throws ServletException, IOException {
			
		doGet(request, response);
	}

}
