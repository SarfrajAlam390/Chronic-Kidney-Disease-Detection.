<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Registration</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
  * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  }

  body {
    background: linear-gradient(135deg, #16a085, #2980b9);
    color: #fff;
    min-height: 100vh;
  }

  nav {
    background-color: rgba(0, 0, 0, 0.4);
    padding: 15px 40px;
    display: flex;
    justify-content: space-between;
    align-items: center;
  }

  nav .logo {
    font-size: 1.6rem;
    font-weight: bold;
    color: white;
  }

  nav ul {
    list-style: none;
    display: flex;
    gap: 20px;
  }

  nav ul li a {
    text-decoration: none;
    color: white;
    font-weight: 500;
    transition: color 0.3s ease;
  }

  nav ul li a:hover {
    color: #f1c40f;
  }

  .container {
    background: rgba(255, 255, 255, 0.1);
    padding: 40px;
    max-width: 500px;
    margin: 60px auto;
    border-radius: 15px;
    box-shadow: 0 0 10px rgba(0,0,0,0.3);
  }

  h2 {
    text-align: center;
    margin-bottom: 30px;
    font-size: 2rem;
    color: #fff;
  }

  .registration-form label {
    display: block;
    margin-top: 15px;
    margin-bottom: 5px;
    font-weight: 500;
  }

  .registration-form input {
    width: 100%;
    padding: 10px;
    border: none;
    border-radius: 8px;
    margin-bottom: 10px;
  }

  .registration-form button {
    width: 100%;
    background-color: #f39c12;
    color: white;
    padding: 12px;
    border: none;
    border-radius: 25px;
    font-size: 1rem;
    font-weight: bold;
    margin-top: 20px;
    transition: background 0.3s ease;
  }

  .registration-form button:hover {
    background-color: #e67e22;
    cursor: pointer;
  }

  footer {
    text-align: center;
    margin-top: 40px;
    font-size: 0.9rem;
    opacity: 0.6;
    color: white;
  }
</style>
</head>
<body>

  <!-- Navigation Bar -->
  <nav>
    <div class="logo">ProjectPredict</div>
    <ul>
      <li><a href="index.html">Home</a></li>
      <!-- <li><a href="Admin.jsp">Admin</a></li> -->
      <li><a href="login.html">Login</a></li>
    </ul>
  </nav>

  <!-- Registration Form -->
  <div class="container">
    <h2>Employee Registration</h2>
    <form action="EmployeeRegister" method="POST" class="registration-form">
      <label for="name">Full Name</label>
      <input type="text" id="name" name="name" placeholder="Enter your full name" required>

      <label for="email">Email Address</label>
      <input type="email" id="email" name="email" placeholder="Enter your email" required>

      <label for="phone">Contact Number</label>
      <input type="tel" id="phone" name="phone" placeholder="Enter your phone number" required>

      <label for="password">Password</label>
      <input type="password" id="password" name="password" placeholder="Enter your password" required>

      <label for="confirm-password">Confirm Password</label>
      <input type="password" id="confirm-password" name="confirm-password" placeholder="Confirm your password" required>

      <button type="submit">Register</button>
    </form>
  </div>

  <footer>
    &copy; 2025 ProjectPredict Inc. All rights reserved.
  </footer>

</body>
</html>
