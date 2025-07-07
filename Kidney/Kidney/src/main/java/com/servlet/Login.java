package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.Database;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
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
		String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        HttpSession session=request.getSession();
        session.setAttribute("email", email);

        // Initialize connection and statement
        
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            // Establish connection to the database
            Connection conn=Database.getConnection();
            
            // Create SQL query to check if email and password match
            String sql = "SELECT * FROM employees WHERE email = '"+email+"' AND password = '"+password+"'";
            ps = conn.prepareStatement(sql);
			

            // Execute the query
            rs = ps.executeQuery();

            // If there is a match, login is successful
            if (rs.next()) {
                // Redirect to a success page (or dashboard)
                response.sendRedirect("EnterData.jsp");
            } else {
                // If no match is found, redirect to an error page
                response.sendRedirect("error.html");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.html");
        } 
	}

}
