<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>A Web Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Lato:300,400,500' rel='stylesheet' type='text/css'>
    <link href='my.css' rel='stylesheet' type='text/css'>

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
        <div class="row">
            <div class="col-sm-6 col-md-4 col-lg-3 mt-4">
                <div class="card">
                    <img class="card-img-top" src="https://picsum.photos/200/150/?random">
                    <div class="card-block">
                        <h5 class="text-bold"><a href="clientcontent1.jsp">Client Content 1</a></h5>
                    </div>
                </div>
            </div>
             <div class="col-sm-6 col-md-4 col-lg-3 mt-4">
                <div class="card">
                    <img class="card-img-top" src="https://picsum.photos/200/150/?random">
                    <div class="card-block">
                        <h5 class="text-bold"><a href="clientcontent1.jsp">Client Content 2</a></h5>
                    </div>
                </div>
            </div>
            <div class="col-sm-6 col-md-4 col-lg-3 mt-4">
                <div class="card">
                    <img class="card-img-top" src="https://picsum.photos/200/150/?random">
                    <div class="card-block">
                        <h5 class="text-bold"><a href="clientcontent1.jsp">Client Content 3</a></h5>
                    </div>
                </div>
            </div>
 		<div class="col-sm-6 col-md-4 col-lg-3 mt-4">
                <div class="card">
                    <img class="card-img-top" src="https://picsum.photos/200/150/?random">
                    <div class="card-block">
                        <h5 class="text-bold"><a href="clientcontent1.jsp">Client Content 4</a></h5>
                    </div>
                </div>
            </div>
        </div>
       
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
			<form class="form-signin"id="loginform"action="UserAuth" method="post">
			<input type="hidden" name="action" value="logout">
			    <input class="btn btn-lg btn-primary btn-block text-uppercase" type="submit" value="Logout" /></form>
			</div></div></div></div>
</div>




</body>
</html>