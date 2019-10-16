<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>

<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Lato:300,400,500' rel='stylesheet' type='text/css'>
    <link href='my.css' rel='stylesheet' type='text/css'>
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">Sign In</h5>
            <form class="form-signin"id="loginform" method="post" action="UserAuth" role="form" onsubmit="return submitUserForm();">
              <input type="hidden" name="action" value="login">
              <div class="form-label-group">
                <input type="email" id="inputEmail" class="form-control" name="name" placeholder="Please enter your Email address" required autofocus data-error="This field is required.">
                <label for="inputEmail">Email address</label>
              </div>

              <div class="form-label-group">
                <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Enter your password here" required data-error="This field is required too.">
                <label for="inputPassword">Password</label>
              </div>
				<div class="g-reCAPTCHA" data-sitekey="6Lf707wUAAAAAN93UQDTz5iZe4yJuNdz9279l3Gj"></div>
				<div id="g-recaptcha-error"></div> 
              <button id="btn-validate" class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Sign in</button>
              <hr class="my-4">
              
      <br/>
              </form>
			  <form  action="reg.jsp" method="post">
			  <input type="hidden" name="action" value="reg">
				    <input class="card-signin btn btn-lg btn-primary btn-block text-uppercase" type="submit" value="Sign Up" />
			  </form>
			  <script src='https://www.google.com/recaptcha/api.js'></script>
				<script>
				function submitUserForm() {
				    var response = grecaptcha.getResponse();
				    if(response.length == 0) {
				        document.getElementById('g-recaptcha-error').innerHTML = '<span class="alert alert-danger">reCaptcha is required.</span>';
				        return false;
				    }
				    return true;
				}
				 
				function verifyCaptcha() {
				    document.getElementById('g-recaptcha-error').innerHTML = '';
				}
				</script>
             
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
       
</html>