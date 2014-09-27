<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"  import="java.sql.*" errorPage=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
	<link href="/SDI-Spring/resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="/SDI-Spring/resources/css/style.css" rel="stylesheet">
	<script type="text/javascript" src="/SDI-Spring/resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="/SDI-Spring/resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/SDI-Spring/resources/js/scripts.js"></script>
</head>
<body>
<br/>
<!-- 
<img src="<c:url value='/resources/img/monitor.png'/>"/>
 -->
 
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<nav class="navbar navbar-default  navbar-fixed-top" role="navigation">
				<div class="navbar-header">
					 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only"></span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="/projeto2.1">SDI - Service Desk Interativo</a>
				</div>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav navbar-right">
						
						<li class="dropdown">
							 <a href="#" class="dropdown-toggle" data-toggle="dropdown">Conf.Gerais<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									<a href="<c:url value='/perfil/listar'/>">Perfil</a>
								</li>
								<li>
									<a href="<c:url value='/categoria/listar'/>">Categoria</a>
								</li>
								<li>
									<a href="<c:url value='/prioridade/listar'/>">Prioridade</a>
								</li>
								<li>
									<a href="<c:url value='/status/listar'/>">Status</a>
								</li>
								<li>
									<a href="<c:url value='/tipo/listar'/>">Tipo</a>
								</li>
								<li>
									<a href="<c:url value='/departamento/listar'/>">Departamento</a>
								</li>
							</ul>
						</li>
						
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">Login<strong class="caret"></strong></a>
							<ul class="dropdown-menu" style="width: 200px;height: 150px;">
								<li>
									<div class="form-group">
									<center>
										<input type="text" class="form-control" placeholder="Login" id="login" style="width:80%;"/>
									</center>
									</div>
								</li>
								<li>
									<div class="form-group">
									<center>
										<input type="password" class="form-control" placeholder="Password" id="senha" style="width:80%;">
									</center>
									</div>
								</li>
								<li>
									<div class="form-group">
									<center>
										<button onclick="#" class="btn btn-primary">Logar</button>
										<button onclick="#" class="btn btn-default" data-toggle="dropdown">Close</button>
									</center>
									</div>
								</li>
							</ul>
						</li>
					</ul>
				</div>
				
			</nav>
		</div>
	</div>
</div>
<br/><br/>
 <div class="container">
	<div class="row clearfix">
		<div class="col-md-6 column">
			<img src="<c:url value='/resources/img/icon_chamados.png'/>" class="img-thumbnail" width="15%"/>
			<a href="<c:url value='/usuario/listar'/>"/>
				<img src="<c:url value='/resources/img/icon_usuarios.png'/>" class="img-thumbnail" width="15%"/>
			</a>
			<img src="<c:url value='/resources/img/icon_administracao.png'/>" class="img-thumbnail" width="15%"/>
			<img src="<c:url value='/resources/img/icon_logout.png'/>" class="img-thumbnail" width="15%"/>
		</div>
	</div>
</div>
<!-- 
<a href="usuario/listar">Listar Usuarios</a>
 -->
</body>
</html>