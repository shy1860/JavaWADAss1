<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href='my.css' rel='stylesheet' type='text/css'>

<meta charset="ISO-8859-1">
<title>A Web Page</title>
</head>
<body>
<%
    session=request.getSession(false);
    if(session.getAttribute("userInfo")==null)
    {
    	
        response.sendRedirect("login.jsp");
    }

%> 


<div class="container">
  <span class="mytext1">Hello This is </span>
  <span class="mytext2"> Yu Shi and Kevin Teran Client Content page </span>
</div>



</body>
</html>