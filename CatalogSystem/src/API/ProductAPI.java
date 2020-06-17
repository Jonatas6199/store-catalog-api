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
import DAO.ProductDAO;
import VO.Product;

/**
 * Servlet implementation class ProductAPI
 */
@WebServlet("/ProductAPI")
public class ProductAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductAPI() {
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
		ProductDAO productDAO = new ProductDAO(); 
		try {
			if(request.getParameterMap().containsKey("productId")) {
				String value = request.getParameter("productId");
				int intValue = Integer.parseInt(value);
				Product aux = new Product();
				aux.setId(intValue);
				aux = productDAO.find(aux);
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
		Product p = new Product();
		try {
			p.setName(request.getParameter("productName"));
			p.setDescription(request.getParameter("productDescription"));
			p.setPrice(Double.parseDouble(request.getParameter("productPrice")));
			p.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
			
			System.out.println("---> " + request.getParameter("categoryId"));
			
			ProductDAO productDAO = new ProductDAO();
			productDAO.insert(p);
			response.getWriter().append("Product criado com sucesso!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product p = new Product();
		try {
			p.setId(Integer.parseInt(request.getParameter("productId")));
			p.setName(request.getParameter("productName"));
			p.setDescription(request.getParameter("productDescription"));
			p.setPrice(Double.parseDouble(request.getParameter("productPrice")));
			p.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
			
			ProductDAO productDAO = new ProductDAO();
			productDAO.update(p);
			response.getWriter().append("Product atualizado com sucesso!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product p = new Product();

		try {
			p.setId(Integer.parseInt(request.getParameter("productId")));
			ProductDAO productDAO = new ProductDAO();
			productDAO.delete(p);
			response.getWriter().append("Product deletado com sucesso!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
