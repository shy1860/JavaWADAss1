<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<link href='my.css' rel='stylesheet' type='text/css'>
<script> 
          
            // Function to check Whether both passwords 
            // is same or not. 
            function checkPassword(form) {  var res; 
            var str = 
                document.getElementById("password").value; 
            var fn = 
                document.getElementById("firstname").value; 
            var ln = 
                document.getElementById("lastname").value; 
            password = form.password.value; 
            confpassword = form.confpassword.value; 
            if (!(str.match(/[A-Z]/g) &&  str.match(/[^a-zA-Z\d]/g) && str.length >= 8&& str.length <= 12)) 
            	{ 
            	res = "Password must contain:\nbe 6-12 characters in length \n2.must contain at least 1 uppercase letter\n2.must contain at least 1 special character!";
            	document.getElementById("error").value = res; 
            	return false;
            	}
            else if(!(fn.match(/[A-Z]/g)&&fn.match(/[a-z]/g))){
            	res = "First name should have only letters!";
            	document.getElementById("error").value = res; 
            	return false;
            }
            else if(!(ln.match(/[A-Z]/g)&&ln.match(/[a-z]/g))){
            	res = "Last name should have only letters!";
            	document.getElementById("error").value = res; 
            	return false;
            }
            else if(!(fn.match(/[A-Z]/g)&&fn.match(/[a-z]/g))){
            	res = "First name should have only letters!";
            	document.getElementById("error").value = res; 
            	return false;
            }

            else if(password != confpassword){
            	res = "\nPassword did not match: Please try again...";
            	document.getElementById("error").value = res; 
            	return false;
            }
            else{ 
                    
                   return true; 
                } 
            } 
        </script> 

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<meta charset="ISO-8859-1">
<title>A Web Page</title>
</head>
<body>

<div class="container register">
                <div class="row">
                    <div class="col-md-3 register-left">
                        <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>
                        <h3>Welcome to Registration Page!</h3>

                    </div>
                    <div class="col-md-9 register-right">
                        <form class="form-signin" id="loginform" method="post" action="UserAuth" role="form"onSubmit = "return checkPassword(this)">
                        <input type="hidden" name="action" value="reg">
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                <h3 class="register-heading">Apply as a client</h3>
                                <div class="row register-form">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input id="firstname" type="text" class="form-control" name="firstname" placeholder="First Name *" value="" required="required"/>
                                        </div>
                                        <div class="form-group">
                                            <input id="lastname" type="text" class="form-control" name="lastname" placeholder="Last Name *" value="" required="required"/>
                                        </div>
                                        <div class="form-group">
                                            <input type="password" name="password"class="form-control" placeholder="Password *" value="" required="required"/>
                                        </div>
                                        <div class="form-group">
                                            <input type="password" name="confpassword" class="form-control"  placeholder="Confirm Password *" value=""required="required" />
                                        </div>
                                        
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input id="email" type="text" class="form-control" name="name" placeholder="Your Email *" value="" required="required"/>
                                        </div>
                                        <div class="form-group">
                                            <input type="text"  name="address" class="form-control" placeholder="Your Address *" value="" required="required"/>
                                        </div>
                                        <div id="error"></div>
                                        <input type="submit" class="btnRegister"  value="Register"/>
                                    </div>
                                </div>
                            </div>
                            </div>                     
                        </form>
                 
                        </div>
                    </div>
                </div>
