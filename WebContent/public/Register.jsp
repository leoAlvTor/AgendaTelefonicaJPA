<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Registrate</title>
	<link rel="stylesheet" href="/public/CSS/style.css">
	<link rel="stylesheet" href="/public/CSS/Index.css">

</head>
<body style="display: flex; align-items: center; justify-content: center;" onmousemove="quitarErrores()">
	<script type="">
		function quitarErrores() {
			error1 = document.getElementById('error1');
			error2 = document.getElementById('error2');
			if(error1 != null && error2 != null){
				setTimeout(new function () {
					error1.style["display"] = "none";
					error2.style["display"] = "none";
				}, 5000);
			}
		}
	</script>

	<c:set var="p1" value="${requestScope['error']}"></c:set>
            	<c:if test="${p1 != null }">
            		<div class="isa_error" id="error1">
   						<i class="fa fa-times-circle"></i>
						<div class="form-group">
   							<p class="error"><strong>Error:</strong> ${p1.error} </p><br/>
						</div>
					</div><br><br>
            		<div class="isa_info" id="error2">
   						<i class="fa fa-info-circle"></i>
						<div class="form-group">
   							<p class="error"><strong>Causa del error:</strong> ${p1.causa} </p><br/>
						</div>
					</div>

            </c:if>
	<section class="signup" style="position: absolute; top: 50%; -ms-transform: translateY(-50%); transform: translateY(-50%);">
		<div class="container">
			<div class="signup-content">
				<div class="signup-form">
					<h2 class="form-title">Registrate</h2>
					<form method="POST" class="register-form" id="register-form" action="/ServletRegister">
						<div class="form-group">
							<label for="cedula"><i class="zmdi zmdi-account material-icons-name"></i></label>
							<input type="text" name="cedula" id="cedula" placeholder="Cedula"/>
						</div>
						<div class="form-group">
							<label for="nombre"><i class="zmdi zmdi-email"></i></label>
							<input type="text" name="nombre" id="nombre" placeholder="Nombres"/>
						</div>
						<div class="form-group">
							<label for="apellido"><i class="zmdi zmdi-email"></i></label>
							<input type="text" name="apellido" id="apellido" placeholder="Apellidos"/>
						</div>
						<div class="form-group">
							<label for="correo"><i class="zmdi zmdi-lock"></i></label>
							<input type="text" name="correo" id="correo" placeholder="Correo"/>
						</div>
						<div class="form-group">
							<label for="password"><i class="zmdi zmdi-lock-outline"></i></label>
							<input type="password" name="password" id="password" placeholder="Password"/>
						</div>
						<div class="form-group form-button">
							<button class="form-submit" type="submit" value="registrarme">Registrate</button>
						</div>
					</form>
				</div>
				<div class="signup-image">
					<figure><img src="/public/Images/register.jpg" alt="sing up image"/></figure>
					<a href="/public/Index.html" class="signup-image-link">Ya tienes cuenta? Inicia Sesion</a>
				</div>
			</div>
		</div>
	</section>
<script src="vendor/jquery/jquery.min.js"></script>
</body>
</html>

		