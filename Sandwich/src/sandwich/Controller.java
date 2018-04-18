package sandwich;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import db.SandwichRepository;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SandwichRepository sandwichRepository;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
    }
    
	@Override
	public void init() throws ServletException{
		super.init();
		
		ServletContext context = getServletContext();
		Properties properties = new Properties();
		Enumeration<String> parameterNames = context.getInitParameterNames();
		while(parameterNames.hasMoreElements()){
			String propertyName = parameterNames.nextElement();
			properties.setProperty(propertyName, context.getInitParameter(propertyName));
		}
        sandwichRepository = new SandwichRepository(properties);
	}
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		sandwichRepository.reduce();
//		int sandwich = sandwichRepository.getSandwich();
//		String js = this.toJSON(sandwich);
//		response.getWriter().write(js);
		Sandwich sandwich = sandwichRepository.get("kaas-hesp");
//		int i = sandwichRepository.get("Veggie");
		String json = this.toJSON(sandwich);
		response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public String toJSON (int sandwich) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String s = Integer.toString(sandwich);
		return mapper.writeValueAsString(s);
	}
	
	public String toJSON (Sandwich sandwich) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
//		String s = Integer.toString(sandwich);
		return mapper.writeValueAsString(mapper);
	}

}
