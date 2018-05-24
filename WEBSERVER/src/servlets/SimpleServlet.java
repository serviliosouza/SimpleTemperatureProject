package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;
import javax.servlet.RequestDispatcher;


import utilities.SimpleMqttOperator;

import org.json.JSONObject;

/**
 * Simple Servlet Implementation
 */
@WebServlet("/temperatura")
public class SimpleServlet extends HttpServlet
{
	/**
	 * Serial version ID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Server a HTTP get request.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		JSONObject obj;
		
		HttpSession session = request.getSession();
		
		try
		{
			obj = new JSONObject();
			
			obj.put("sensor1", "a");
			obj.put("sensor2", "b");
			obj.put("sensor3", "c");
			
			session.setAttribute("sensors", obj);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
		finally {
			ServletContext context = this.getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}
	}
}

