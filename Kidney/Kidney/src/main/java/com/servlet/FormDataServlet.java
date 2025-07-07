package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormDataServlet
 */
@WebServlet("/FormDataServlet")
public class FormDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FormDataServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
response.setContentType("text/html");
        
        // Get form data from the request
        String sgStr = request.getParameter("sg");
        String htnStr = request.getParameter("htn");
        String hemoStr = request.getParameter("hemo");
        String dmStr = request.getParameter("dm");
        String alStr = request.getParameter("al");
        String appetStr = request.getParameter("appet");
        String rcStr = request.getParameter("rc");
        String pcStr = request.getParameter("pc");

        // Initialize a writer to send a response back to the browser
        PrintWriter out = response.getWriter();
        
        // Convert String values to integers (with validation)
        int  htn = 0, hemo = 0, dm = 0, al = 0, appet = 0, rc = 0, pc = 0;
        double sg=0.0;

        try {
            // Convert strings to integers (with exception handling)
            sg = Double.parseDouble(sgStr);
            htn = Integer.parseInt(htnStr);
            hemo = Integer.parseInt(hemoStr);
            dm = Integer.parseInt(dmStr);
            al = Integer.parseInt(alStr);
            appet = Integer.parseInt(appetStr);
            rc = Integer.parseInt(rcStr);
            pc = Integer.parseInt(pcStr);
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
            String sql="select * from users ";
            
            
        } catch (NumberFormatException e) {
            // Handle invalid input, like non-numeric characters
            out.println("<html><body>");
            out.println("<h2>Error: Invalid number format in one of the fields.</h2>");
            out.println("</body></html>");
            return; // Stop further processing if input is invalid
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Process the data (you can perform any calculation or validation here)
        // For simplicity, we are just echoing back the received values

        out.println("<html><body>");
        out.println("<h2>Form Data Received</h2>");
        out.println("<p><b>Specific Gravity:</b> " + sg + "</p>");
        out.println("<p><b>Hyper Tension:</b> " + htn + "</p>");
        out.println("<p><b>Hemoglobin:</b> " + hemo + "</p>");
        out.println("<p><b>Diabetes Mellitus:</b> " + dm + "</p>");
        out.println("<p><b>Albumin:</b> " + al + "</p>");
        out.println("<p><b>Appetite:</b> " + appet + "</p>");
        out.println("<p><b>Red Blood Cell Count:</b> " + rc + "</p>");
        out.println("<p><b>Pus Cell:</b> " + pc + "</p>");
        out.println("</body></html>");
    }


}
