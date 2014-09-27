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
	
	<div class="modal fade" id="create_update_status" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">
						Status
					</h4>
				</div>
				<div class="modal-body">
					<div class="col-md-12 column">
						<div class="form-group">
							 <label>Descrição</label><input type="text" class="form-control" placeholder="Descrição" />
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
				Status <small>Listagem de Status</small>
			</h1>
		</div>
		<button type="button" class="btn btn-primary" href="#create_update_status" data-toggle="modal">Novo</button>
		<br/><br/>
		<table class="table table-hover"> 
			<tr>
			  <th style="width: 33%">codStatus</th>
			  <th style="width: 33%">descStatus</th>
			  <th style="width: 33%">Controle</th>
			</tr>
			<c:forEach var="status" items="${lista}">
				<tr>
					<td>${status.idStatus}</td>
					<td>${status.descStatus}</td>
					<td>
						<button type="button" class="btn btn-default" href="#create_update_status" data-toggle="modal">Alterar</button>
						<button type="button" class="btn btn-danger">Excluir</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
<jsp:include page="../decorators/footer.jsp"></jsp:include>
</body>
</html>