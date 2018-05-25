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

import utilities.Temperature;

import utilities.Database;

import java.util.ArrayList;

import org.json.JSONObject;

@WebServlet("/relatorio")
public class DataServlet extends HttpServlet
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
		ArrayList<JSONObject> array;
		
		HttpSession session = request.getSession();
		
		try
		{
			array = Database.getRegisters();
			
			session.setAttribute("relatorio", array);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
		finally {
			ServletContext context = this.getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/relatorio.jsp");
			dispatcher.forward(request, response);
		}
	}
}

