<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"  import="java.sql.*" errorPage=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>SDI</title>
</head>
<body>
<jsp:include page="../decorators/header.jsp"></jsp:include>
		<div class="modal fade" id="create_update_categoria" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">
						Categoria
					</h4>
				</div>
				<div class="modal-body">
					<div class="col-md-12 column">
						<div class="form-group">
							 <label>Descrição</label><input type="text" class="form-control" placeholder="Descrição" />
						</div>
						<div class="form-group">
							<label>Tipo</label>
							<select class="form-control">
							  <option>1</option>
							  <option>2</option>
							  <option>3</option>
							</select>
						</div>
						<div class="form-group">
							<label>Prioridade</label>
							<select class="form-control">
							  <option>1</option>
							  <option>2</option>
							  <option>3</option>
							  <option>4</option>
							  <option>5</option>
							</select>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					 <button type="button" class="btn btn-default" data-dismiss="modal">Close</button> <button type="button" class="btn btn-primary">Salvar</button>
				</div>
			</div>
		</div>
	</div>
			
	<div class="container">
		
		<div class="page-header">
			<h1>
				Categoria <small>Listagem de Categoria</small>
			</h1>
		</div>
		<button type="button" class="btn btn-primary" href="#create_update_categoria" data-toggle="modal">Novo</button>
		<br/><br/>
		<table class="table table-hover"> 
			<tr>
			  <th style="width: 20%">Código</th>
			  <th style="width: 20%">Descrição</th>
			  <th style="width: 20%">Tipo</th>
			  <th style="width: 20%">Prioridade</th>
			  <th style="width: 20%">Controle</th>
			</tr>
			<c:forEach var="categoria" items="${lista}">
				<tr>
					<td>${categoria.idCategoria}</td>
					<td>${categoria.descCategoria}</td>
					<td>${categoria.tipo.descTipo}</td>
					<td>${categoria.prioridade.descPrioridade}</td>
					<td>
						<button type="button" class="btn btn-default" href="#create_update_categoria" data-toggle="modal">Alterar</button>
						<button type="button" class="btn btn-danger">Excluir</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
<jsp:include page="../decorators/footer.jsp"></jsp:include>
</body>
</html>