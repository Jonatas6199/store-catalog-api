package API;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ContactDAO;
import VO.Contact;

/**
 * Servlet implementation class ContactAPI
 */
@WebServlet("/ContactAPI")
public class ContactAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactAPI() {
        super();
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
		Contact c = new Contact();
		try {
			c.setEmail(request.getParameter("contactEmail"));
			c.setNumber(request.getParameter("contactNumber"));
			c.setFacebook(request.getParameter("contactFaceBook"));
			c.setInstagram(request.getParameter("contactInstagram"));
			c.setTwitter(request.getParameter("contactTwitter"));
			c.setyoutube(request.getParameter("contactYoutube"));
			
			ContactDAO contactDAO = new ContactDAO();
			contactDAO.insert(c);
			response.getWriter().append("Contact criado com sucesso!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contact c = new Contact();
		try {
			c.setId(Integer.parseInt(request.getParameter("contactId")));
			c.setEmail(request.getParameter("contactEmail"));
			c.setNumber(request.getParameter("contactNumber"));
			c.setFacebook(request.getParameter("contactFaceBook"));
			c.setInstagram(request.getParameter("contactInstagram"));
			c.setTwitter(request.getParameter("contactTwitter"));
			c.setyoutube(request.getParameter("contactYoutube"));
			
			ContactDAO contactDAO = new ContactDAO();
			contactDAO.update(c);
			response.getWriter().append("Contact atualizado com sucesso!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contact c = new Contact();

		try {
			c.setId(Integer.parseInt(request.getParameter("contactId")));
			ContactDAO contactDAO = new ContactDAO();
			contactDAO.delete(c);
			response.getWriter().append("Contact deletado com sucesso!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
