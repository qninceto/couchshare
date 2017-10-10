package ittalents.couchshare.controler.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ittalents.couchshare.model.DAO.RequestDAO;
import ittalents.couchshare.model.POJO.Request;
import ittalents.couchshare.model.exceptions.PostException;
import ittalents.couchshare.model.exceptions.RequestException;
import ittalents.couchshare.model.exceptions.UserException;

/**
 * Servlet implementation class myservlet
 */
@WebServlet("/myservlet")
public class myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public myservlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		RequestDAO dao=new RequestDAO();
		List<Request> list;
		response.setContentType("text/html");
		try {
			list = dao.getListOfRequestsReceivedByUser(2);

			for(Request r: list) {
				writer.print("<h1 style=\"background-color:green; color:blue; text-align:center;\"> REQUEST </h1>");
				writer.println("<p>To: "+r.getReceiver() + " </p>");
				writer.println("<p>From: "+r.getAuthor() + " </p>");
				writer.println("<h2 style=\"color:red\"> Request content : ");
				writer.println("<p>Message: "+r.getContent() + " </p>");
				writer.println("<p>Number of travelers: "+r.getNumberOfTravellers() + " </p>");
				writer.println("<p>Date of Arrival: "+r.getStartDate() + " </p>");
				writer.println("<p>Date of Leaving: "+r.getEndDate() + " </p>");
				writer.println("<p>Status: "+r.getAcceptedStatus() + " </p>");
				writer.println("<br/><hr/><br/>");
				
			}
		} catch (RequestException | PostException | UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
