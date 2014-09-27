<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"  import="java.sql.*" errorPage=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Cadastro de Usuario</title>
</head>

<body>
<jsp:include page="../decorators/header.jsp"></jsp:include>

${mensagem}
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<!--form action="gravarUsuario" method="post" id="gravarUsuario"-->
				<div class="page-header">
					<h1>
						Dados Pessoais <small>Service Desk Interativo</small>
					</h1>
				</div>
				<fieldset  id="dadosPessoais">
					<div class="row">
					  <div class="col-md-4">
					  	<label>Matrícula</label>
						<input type="text" class="form-control" placeholder="Matrícula" name="matricula" id="matricula"/>
					  </div>
					  <div class="col-md-4">
					  	<label>Nome</label>
						<input type="text" class="form-control" placeholder="Nome" name="nome" id="nome"/>
					  </div>
					  <div class="col-md-4">
					  	<label>Sobrenome</label>
						<input type="text" class="form-control" placeholder="Sobrenome" name="sobrenome" id="sobrenome"/>
					  </div>
					</div>
					<div class="row">
						<div class="col-md-3">
							<label>CPF</label>
							<input type="text" class="form-control" placeholder="CPF" name="cpf" id="cpf"/>
						</div>
						<div class="col-md-3">
							<label>Telefone</label>
							<input type="text" class="form-control" placeholder="Telefone" name="telefone" id="telefone"/>
						</div>
						<div class="col-md-3">
							<label>Perfil</label>
							<select class="form-control" name="perfil" id="perfil">
								<option>Aluno</option>
							   	<option>Monitor</option>
							   	<option>Professor</option>
							</select>
						</div>
						<div class="col-md-3">
							<label>Nascimento</label>
							<input type="date" class="form-control" placeholder="Nascimento" id="nascimento"/>
						</div>
					</div>
				</fieldset>
				<br/>
				<fieldset id="dadosDeAcesso">
					<legend>Dados de Acesso</legend>
					<div class="row">
						<div class="col-md-6">
							<label>Email</label>
							<input type="email" class="form-control" placeholder="Email" name="email" id="email"/>
						</div>
						<div class="col-md-6">
							<label>Confirmação Email</label>
							<input type="email" class="form-control" placeholder="Confirmação de Email" id="email2"/>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<label>Senha</label>
							<input type="password" class="form-control" placeholder="Senha" name="senha" id="senha"/>
						</div>
						<div class="col-md-6">
							<label>Confirmação Senha</label>
							<input type="password" class="form-control" placeholder="Confirmação de Senha" id="senha2"/>
						</div>
					</div>
					<br/>
					<button onclick="cadastrarUsuario()" class="btn btn-primary">Cadastrar</button>
				</fieldset>
			<!-- /form-->
		</div>
	</div>
</div>
<jsp:include page="../decorators/footer.jsp"></jsp:include>
</body>
</html>
