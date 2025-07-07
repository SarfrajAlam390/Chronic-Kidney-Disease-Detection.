package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class New
 */
@WebServlet("/predict")
public class New extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public New() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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

		// Initialize variables
		int htn = 0, dm = 0, al = 0, appet = 0, pc = 0;
		double sg = 0.0, hemo = 0.0, rc = 0.0;

		// Convert strings to appropriate types
		sg = Double.parseDouble(sgStr);
		htn = Integer.parseInt(htnStr);
		hemo = Double.parseDouble(hemoStr);
		dm = Integer.parseInt(dmStr);
		al = Integer.parseInt(alStr);
		appet = Integer.parseInt(appetStr);
		rc = Double.parseDouble(rcStr);
		pc = Integer.parseInt(pcStr);
		try {
			System.out.println("inside try");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datastorage", "root", "root");

			// Construct SQL query dynamically based on conditions
			String sql = "SELECT clasifcation FROM users WHERE sug='" + sg + "' && hemo='" + hemo + "' && rc='" + rc
					+ "'";
			PreparedStatement stmt = con.prepareStatement(sql);
			System.out.println(stmt);
			ResultSet rs=stmt.executeQuery();
			
			if(rs.next()) {
				out.println("<h1>Congratulation!</h1>");
				out.println("<p>You DON'T have Chronic Kidney Disease.</p>");
			}else if(sg > 1.005 && sg <=1.030 || hemo > 11.1 && hemo <=17.0 && rc > 90 || rc <= 200 ){
				System.out.println("from else if");
				out.println("<h1>Congratulation!</h1>");
				out.println("<p>You DON'T have Chronic Kidney Disease.</p>");
			}
			
			
			
			else {
				 out.println("<h1>Oops!</h1>");
				 out.println("<p>You have CHRONIC KIDNEY DISEASE. Please Consult Doctor.</p>");
				System.out.println("byeee");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
