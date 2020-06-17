package API;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductImageDAO;
import VO.ProductImage;

/**
 * Servlet implementation class ProductImageAPI
 */
@WebServlet("/ProductImageAPI")
public class ProductImageAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductImageAPI() {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductImage pi = new ProductImage();
		try {
			pi.setImagePath(request.getParameter("imagePath"));
			pi.setProductId(Integer.parseInt(request.getParameter("productId")));
			
			ProductImageDAO productImageDAO = new ProductImageDAO();
			productImageDAO.insert(pi);
			
			response.getWriter().append("ProductImage criado com sucesso!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductImage pi = new ProductImage();
		try {
			pi.setId(Integer.parseInt(request.getParameter("imageId")));
			pi.setImagePath(request.getParameter("imagePath"));
			pi.setProductId(Integer.parseInt(request.getParameter("productId")));
			
			ProductImageDAO productImageDAO = new ProductImageDAO();
			productImageDAO.update(pi);

			response.getWriter().append("ProductImage atualizado com sucesso!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductImage pi = new ProductImage();

		try {
			pi.setId(Integer.parseInt(request.getParameter("imageId")));
			ProductImageDAO productImageDAO = new ProductImageDAO();
			productImageDAO.delete(pi);
			response.getWriter().append("ProductImage deletado com sucesso!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
