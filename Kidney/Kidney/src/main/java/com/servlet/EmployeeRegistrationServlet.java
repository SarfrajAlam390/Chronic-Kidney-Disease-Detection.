package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmployeeRegistrationServlet
 */
@WebServlet("/EmployeeRegister")
public class EmployeeRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/datastorage";
    private String jdbcUsername = "root";
   private  String jdbcPassword = "root";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeRegistrationServlet() {
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
		String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
       
        String password = request.getParameter("password");
        HttpSession session=request.getSession();
        session.setAttribute("name", name);
        // Initialize connection and statement
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // Establish connection to the database
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

            // Create SQL query to insert employee data
            String sql = "INSERT INTO employees (name, email, phone,  password) VALUES (?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
           
            ps.setString(4, password);

            // Execute the query
            int result = ps.executeUpdate();

            // If data inserted successfully, redirect to success page
            if (result > 0) {
                response.sendRedirect("login.html");
            } else {
                response.sendRedirect("error.html");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.html");
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }}

}
