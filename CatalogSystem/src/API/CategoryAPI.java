package API;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.Methods;
import DAO.CategoryDAO;
import VO.Category;

@WebServlet("/CategoryAPI")
public class CategoryAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CategoryAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryDAO categoryDAO = new CategoryDAO(); 
		try {
			if(request.getParameterMap().containsKey("categoryId")) {
				String value = request.getParameter("categoryId");
				int intValue = Integer.parseInt(value);
				Category aux = new Category();
				aux.setId(intValue);
				aux = categoryDAO.find(aux);
				String jsonReturnedString =  Methods.convertToJson(aux);
				PrintWriter pw = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				pw.print(jsonReturnedString);
				pw.flush();
			}
			else {
				ArrayList<Category> aux = categoryDAO.findAll();
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Category c = new Category();
		try {
			c.setName(request.getParameter("categoryName"));
			CategoryDAO categoryDAO = new CategoryDAO();
			categoryDAO.insert(c);
			response.getWriter().append("Category criado com sucesso!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Category c = new Category();
		try {
			c.setId(Integer.parseInt(request.getParameter("categoryId")));
			c.setName(request.getParameter("categoryName"));
			CategoryDAO categoryDAO = new CategoryDAO();
			categoryDAO.update(c);
			response.getWriter().append("Category atualizado com sucesso!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Category c = new Category();

		try {
			c.setId(Integer.parseInt(request.getParameter("categoryId")));
			CategoryDAO categoryDAO = new CategoryDAO();
			categoryDAO.delete(c);
			response.getWriter().append("Category deletado com sucesso!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
