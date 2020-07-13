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
import DAO.SuggestionDAO;
import VO.Suggestion;

/**
 * Servlet implementation class SuggestionAPI
 */
@WebServlet("/SuggestionAPI")
public class SuggestionAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuggestionAPI() {
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
		SuggestionDAO suggestionDAO = new SuggestionDAO(); 
		try {
			if(request.getParameterMap().containsKey("suggestionId")) {
				String value = request.getParameter("suggestionId");
				int intValue = Integer.parseInt(value);
				Suggestion aux = new Suggestion();
				aux.setId(intValue);
				aux = suggestionDAO.find(aux);
				String jsonReturnedString =  Methods.convertToJson(aux);
				PrintWriter pw = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				pw.print(jsonReturnedString);
				pw.flush();
			}
			else {
				ArrayList<Suggestion> aux = suggestionDAO.findAll();
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
		Suggestion s = new Suggestion();
		try {
			s.setSuggestionDescription(request.getParameter("suggestionDescription"));
			s.setUserId(Integer.parseInt(request.getParameter("userId")));
			
			SuggestionDAO suggestionDAO = new SuggestionDAO();
			suggestionDAO.insert(s);
			
			response.getWriter().append("Suggestion criado com sucesso!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Suggestion s = new Suggestion();
		try {
			s.setId(Integer.parseInt(request.getParameter("suggestionId")));
			s.setSuggestionDescription(request.getParameter("suggestionDescription"));
			s.setUserId(Integer.parseInt(request.getParameter("userId")));
			
			SuggestionDAO suggestionDAO = new SuggestionDAO();
			suggestionDAO.update(s);

			response.getWriter().append("Suggestion atualizado com sucesso!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Suggestion s = new Suggestion();

		try {
			s.setId(Integer.parseInt(request.getParameter("suggestionId")));
			
			SuggestionDAO suggestionDAO = new SuggestionDAO();
			suggestionDAO.update(s);
			response.getWriter().append("Suggestion deletado com sucesso!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
