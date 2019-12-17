<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    	               "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Bienvenido</title>
</head>
<body>
<form action="login" method="POST">
<div class="login-reg-panel">
		<div class="login-info-box">
			<h2>Estas registrado?</h2>
			<label id="label-register" for="log-reg-show">Login</label>
			<input type="radio" name="active-log-panel" id="log-reg-show"  checked="checked">
		</div>
							
		<div class="register-info-box">
			<h2>Don't have an account?</h2>
			<p>Lorem ipsum dolor sit amet</p>
			<label id="label-login" for="log-login-show">Register</label>
			<input type="radio" name="active-log-panel" id="log-login-show">
		</div>
							
		<div class="white-panel">r
			<div class="login-show">
				<h2>LOGIN</h2>
				
				<input type="text" placeholder="Email" name="user">
				<input type="password" placeholder="Password" name="password">
				<button type="submit" class="login-reg-panel"  value="Ingresar" >Ingresar</button>
    			 <button type="Reset" class="login-reg-panel"  value="Limpiar" >Limpiar</button>
		
			</div>
			
		</div>
	</div>
		</form>
</body>
</html> 
