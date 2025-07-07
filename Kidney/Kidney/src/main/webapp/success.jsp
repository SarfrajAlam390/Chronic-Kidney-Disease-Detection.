<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Registration Success</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style>
    * {
      box-sizing: border-box;
      margin: 0;
      padding: 0;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    body {
      background: linear-gradient(to right, #8e2de2, #4a00e0);
      height: 100vh;
      display: flex;
      justify-content: center;
      align-items: center;
      color: white;
      overflow: hidden;
    }

    .card {
      background: rgba(255, 255, 255, 0.1);
      border-radius: 20px;
      padding: 40px 60px;
      text-align: center;
      box-shadow: 0 8px 25px rgba(0,0,0,0.3);
      animation: fadeIn 1.2s ease-in-out forwards;
      transform: translateY(50px);
      opacity: 0;
    }

    .card h3 {
      font-size: 1.8rem;
      margin-bottom: 20px;
    }

    .card a {
      display: inline-block;
      margin-top: 25px;
      padding: 12px 30px;
      background-color: #ff7675;
      color: white;
      text-decoration: none;
      border-radius: 30px;
      font-weight: bold;
      transition: background 0.3s ease;
    }

    .card a:hover {
      background-color: #d63031;
    }

    @keyframes fadeIn {
      0% {
        transform: translateY(50px);
        opacity: 0;
      }
      100% {
        transform: translateY(0);
        opacity: 1;
      }
    }

    .glow {
      text-shadow: 0 0 10px #ffffff88, 0 0 20px #ffffff55;
    }
  </style>
</head>
<body>

<a href="index.html">Logout</a>

  <%
    String rid = (String)session.getAttribute("name");
  %>

  <div class="card">
    <h3 class="glow">Hey <%= rid %>, You Have Successfully Registered! </h3>
    <a href="login.html">Proceed to Login</a>
  </div>

</body>
</html>
