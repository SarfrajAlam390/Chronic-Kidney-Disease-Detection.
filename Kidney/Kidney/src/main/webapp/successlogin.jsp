<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Login Success</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style>
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      font-family: 'Poppins', sans-serif;
    }

    body {
      height: 100vh;
      background: radial-gradient(circle at center, #2c3e50, #000);
      display: flex;
      justify-content: center;
      align-items: center;
      color: white;
    }

    .card {
      background: rgba(255, 255, 255, 0.05);
      border: 1px solid rgba(255, 255, 255, 0.2);
      padding: 40px 50px;
      border-radius: 20px;
      box-shadow: 0 10px 30px rgba(0,0,0,0.5);
      text-align: center;
      animation: scaleIn 1.1s ease;
    }

    .typing {
      display: inline-block;
      border-right: 2px solid white;
      white-space: nowrap;
      overflow: hidden;
      font-size: 1.5rem;
      width: 0;
      animation: typing 3s steps(40, end) forwards, blink 0.75s step-end infinite;
    }

    a {
      display: inline-block;
      margin-top: 25px;
      padding: 12px 30px;
      background: #16a085;
      color: white;
      text-decoration: none;
      border-radius: 25px;
      font-weight: bold;
      transition: background 0.3s ease;
    }

    a:hover {
      background: #1abc9c;
    }

    @keyframes scaleIn {
      from {
        transform: scale(0.8);
        opacity: 0;
      }
      to {
        transform: scale(1);
        opacity: 1;
      }
    }

    @keyframes typing {
      from { width: 0 }
      to { width: 100% }
    }

    @keyframes blink {
      50% { border-color: transparent }
    }
  </style>
</head>
<body>

<%
  String rid = (String)session.getAttribute("email");
%>

<div class="card">
  <div class="typing">Hey <%= rid %>, You Successfully Logged In </div>
  <br><br>
  <a href="Filldaat.jsp">Verify Now</a>
</div>

</body>
</html>
