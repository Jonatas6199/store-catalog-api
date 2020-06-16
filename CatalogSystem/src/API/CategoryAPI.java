package API;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	private int fazAi(String a) {
		try {
			return Integer.parseInt(a);
		} catch(Exception e) {
			return 1;
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Category c = new Category();
		try {
			c.setId(fazAi(request.getParameter("ID")));
			CategoryDAO categoryDAO = new CategoryDAO();
		} catch(Exception e) {
			e.printStackTrace();
		}
		// request.getParameter("ID")
		
		// Json jsonCategories = CategoryController.selectCategory();
		// response.Bla(jsonCategories);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Category c = new Category();
		try {
			c.setName(request.getParameter("NAME"));
			CategoryDAO categoryDAO = new CategoryDAO();
			categoryDAO.insert(c);
			response.getWriter().append("Category criado com sucesso!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// BufferedReader x = request.getReader();
		// var test = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		// System.out.println(test);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Category c = new Category();
		try {
			c.setId(Integer.parseInt(request.getParameter("ID")));
			c.setName(request.getParameter("NAME"));
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
			c.setId(Integer.parseInt(request.getParameter("ID")));
			CategoryDAO categoryDAO = new CategoryDAO();
			categoryDAO.delete(c);
			response.getWriter().append("Category deletado com sucesso!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
