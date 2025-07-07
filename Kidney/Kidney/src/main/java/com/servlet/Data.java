package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Data
 */
@WebServlet("/predict1")
public class Data extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Data() {
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
		int htn = 0, dm = 0, al = 0, appet = 0,  pc = 0;
		double sg = 0.0,hemo=0.0,rc=0.0;
		boolean conditionMet = false;
		try {
		    // Convert strings to integers (with exception handling)
		    sg = Double.parseDouble(sgStr);
		    htn = Integer.parseInt(htnStr);
		    hemo = Double.parseDouble(hemoStr);
		    dm = Integer.parseInt(dmStr);
		    al = Integer.parseInt(alStr);
		    appet = Integer.parseInt(appetStr);
		    rc = Double.parseDouble(rcStr);
		    pc = Integer.parseInt(pcStr);

		   
		    if (sg > 1.005 && sg <=1.030 || hemo > 11.1 && hemo <=17.0 || dm > 90 && dm <= 200 || rc > 4.2 && rc == 6.1) {  
		        conditionMet = true;
		    }
			
		    if (hemo > 11.1 && hemo <=17.0) {  // Example condition for hemo
		       
		        conditionMet = true;
		    }
		    if (dm > 90 && dm <= 200) {  // Example condition for dm
		       
		        conditionMet = true;
		    }
		    if (al > 0 && (al == 5)) {  // Example condition for al
		       // sqlBuilder.append(" AND al = ").append(al);
		        conditionMet = true;
		    }
		    if (appet == 0 ) {  // Example condition for appet
		        //sqlBuilder.append(" AND appet = ").append(appet);
		        conditionMet = false;
		    }
		    if (appet == 1 ) {  // Example condition for appet
		        //sqlBuilder.append(" AND appet = ").append(appet);
		        conditionMet = true;
		    }
		    if (rc > 4.2 && rc == 6.1) {  // Example condition for rc
		        //sqlBuilder.append(" AND rc = ").append(rc);
		        conditionMet = true;
		    }
		    if (pc > 0 && (pc == 5)) {  // Example condition for pc
		       // sqlBuilder.append(" AND pc = ").append(pc);
		        conditionMet = true;
		    }

		    // Convert the StringBuilder to a final SQL string
		    //String sql = sqlBuilder.toString();

		    // Prepare and execute the query
		    Statement stmt = con.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);

		    // If any condition is met, show success page with the message
		    if (conditionMet) {
		        // Redirect to success page and display message
		        //response.sendRedirect("success.jsp");
		        out.println("<h1>Oops! 🙁</h1>");
		        out.println("<p>You DON'T have Chronic Kidney Disease.</p>");
		    } else {
		        // If no conditions were met, show error page with the message
		        response.sendRedirect("error.jsp");
		        out.println("<h1>Congratulation! 🎉</h1>");
		        
		        out.println("<p>You have CHRONIC KIDNEY DISEASE. Please Consult Doctor.</p>");
		    }

		    // Close the resources
		    rs.close();
		    stmt.close();
		    //con.close();

		} catch (Exception e) {
		    // Handle exceptions
		    e.printStackTrace();
		    out.println("Error: " + e.getMessage());
		}
	}

}
