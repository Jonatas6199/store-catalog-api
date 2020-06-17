package API;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.Methods;
import DAO.CatalogUserDAO;
import VO.CatalogUser;

/**
 * Servlet implementation class CatalogUserAPI
 */
@WebServlet("/CatalogUserAPI")
public class CatalogUserAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatalogUserAPI() {
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
		CatalogUserDAO catalogUserDAO = new CatalogUserDAO(); 
		try {
			if(request.getParameterMap().containsKey("userId")) {
				String value = request.getParameter("userId");
				int intValue = Integer.parseInt(value);
				CatalogUser aux = new CatalogUser();
				aux.setId(intValue);
				aux = catalogUserDAO.find(aux);
				String jsonReturnedString =  Methods.convertToJson(aux);
				PrintWriter pw = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				pw.print(jsonReturnedString);
				pw.flush();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CatalogUser cu = new CatalogUser();
		try {
			cu.setUserEmail(request.getParameter("userEmail"));
			cu.setUserPassword(request.getParameter("userPassword"));
			cu.setUserName(request.getParameter("userName"));
			cu.setIsAdmin(Integer.parseInt(request.getParameter("isAdmin")));
			
			CatalogUserDAO catalogUserDAO = new CatalogUserDAO();
			catalogUserDAO.insert(cu);
			response.getWriter().append("CatalogUser criado com sucesso!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CatalogUser cu = new CatalogUser();
		try {
			cu.setId(Integer.parseInt(request.getParameter("userId")));
			cu.setUserEmail(request.getParameter("userEmail"));
			cu.setUserPassword(request.getParameter("userPassword"));
			cu.setUserName(request.getParameter("userName"));
			cu.setIsAdmin(Integer.parseInt(request.getParameter("isAdmin")));
			
			CatalogUserDAO catalogUserDAO = new CatalogUserDAO();
			catalogUserDAO.update(cu);
			response.getWriter().append("Catalog atualizado com sucesso!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CatalogUser cu = new CatalogUser();

		try {
			cu.setId(Integer.parseInt(request.getParameter("userId")));
			CatalogUserDAO catalogUserDAO = new CatalogUserDAO();
			catalogUserDAO.delete(cu);
			response.getWriter().append("CatalogUser deletado com sucesso!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
