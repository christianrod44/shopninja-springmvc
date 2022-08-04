<!DOCTYPE html>
<%@page contentType="text/html" import="java.util.Date, java.text.*"
pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Vendas</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.2/font/bootstrap-icons.css">
<style>
	#interface{
	    width: 1000px;
	    background-color: #dcdcdc;
	    margin: 10px auto 0px auto;
	    box-shadow: 10px 10px 10px rgba(0,0,0,.5);
	    padding: 10px 10px 10px 10px;
	    position: relative;
	}
	.borda {
		max-width: 400px;
		margin: auto;
		background-color: #dcdcdc;
		box-shadow: 0px 0px 10px rgba(0,0,0,.5);
		color: #606060;
	    text-shadow: 1px 1px 1px rgba(0,0,0,.6);
	    padding: 10px 10px 10px 10px;
	}
	ul{
    	display: block;
	}
	ul{
	    list-style: none;
	    text-transform: uppercase;
	    top: 10px;
	    left: 300px;
	}
	#gamb2{
		background-color: #666666;
	}
	#gamb{
		background-color: #dddddd;
	}
 	li{ 
 	    display: inline-block; 
 	    background-color: #dddddd; 
 	    padding: 5px; 
 	    margin: 2px; 
 	    transition: background-color 1s; 
 	} 
 	li:hover{ 
 	    background-color: #606060; 
 	}
	a{
	    color: #000000;
	    text-decoration: none;
	}
	a:hover{
	    color: #ffffff;
	    text-decoration: underline;
	}
	h5 {
		font-size: 18pt;
		color: #606060;
	    text-shadow: 1px 1px 1px rgba(0,0,0,.6);
	}
	#rodape {
		clear: both;
		border-top: 1px solid #606060;
	}

    #rodape p {
		text-align: center;
	}
</style>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div id="interface">
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<div class="container">
		<h1 class="text-primary">Vendas Realizadas:</h1>
		<div>
			<ul>
				<li><a href=<c:url value="/" />><i class="bi bi-house-door"></i> HOME</a></li>
				<li><a href=<c:url value="/venda/inicio" />>Voltar</a></li>
			</ul>
		</div>
		<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalinc">Nova Venda	</button>
		
		<table class="table table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>DATA DA VENDA</th>
					<th>TOTAL</th>
					<th></th>
					<th>EXCLUIR</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vn" items="${venda}">
					<tr>
						<td>${vn.id}</td>
						<td>${vn.dataatual}</td>
						<td>${vn.total}</td>
						<td></td>
						<td>
								
							<button type="button" class="btn remove"
								data-id="${vn.id}"
								data-bs-toggle="modal"
								data-bs-target="#modal"><i class="bi bi-trash3-fill"></i></button>
						</td>
					</tr>
				</c:forEach>
					
				
			</tbody>
			
		</table>
		
		
	</div>
		
	<!-- Modal Remover-->
	<div class="modal fade" id="modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	    <!-- header -->
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Confirmar Exclusão</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <!-- body -->
	      <div class="modal-body">
	        <h4>Tem certeza que deseja remover esta venda?</h4>
	      </div>
	      <!-- footer -->
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Não</button>
	        <button type="button" id="btnRemover" class="btn btn-danger" data-bs-dismiss="modal">Remover</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- Modal Incluir -->
	<div class="modal fade" id="modalinc" tabindex="-1" 
			aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	    	<form action=<c:url value="/cadvenda" /> method="post" oninput="calc_total();">
	      <!-- header -->
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Nova Venda</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      
	      <!-- body -->
	      <div class="modal-body">
			<div class="borda">

				<div class="md-3">
				
					
					<label class="form-label">DATA:</label>
					<input class="form-control" type="date" id="dataVenda" name="dataVenda" />
				</div>
				

				
				
				<div class="md-3">
					<label class="form-label">Valor e Produto:</label>
 					<select class="form-select" name="cmbProduto" id="produto">
	 					<option id="gamb2" value="0">Valor e Item</option>
						<c:forEach var="pr" items="${produtos}" >
							<option selected value="${pr.id}">${pr.valor}</option>
							<option id="gamb" >${pr.nome}</option>
						</c:forEach>
 					</select>
 					
 					<label for="cQtd" >Quantidade: </label>
					<input type="number" id="cQtd" name="qtd1" min="1" max="5" value="1" />
 					
 				<div class="md-3">
					<label class="form-label">Cliente:</label>
					<select class="form-select" name="cmbCliente" id="cliente">
					<option value="0">Selecione...</option>
						<c:forEach var="cl" items="${clientes}">
							<option value="${cl.id}">${cl}</option>
						</c:forEach>
					</select>
				</div>
 					
				</div>
				
				<div class="md-3">
					<label class="form-label">Total:</label>
					<input class="form-control" type="text" id="total" name="tTotal" placeholder="Total a Pagar" readonly />
				</div>		
			</div>
	      </div>
	      
	      <!-- footer -->
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
	        	Cancelar
	        </button>
	        <button type="submit" class="btn btn-primary" data-bs-dismiss="modal">
	        	Finalizar
	        </button>
	      </div>
	      </form>
	      
	    </div>
	  </div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function(){
			let id;

			$('.remove').click(function(){
				id = $(this).attr('data-id');
			});
			
			$('#btnRemover').click(function() {
				let url = "http://localhost:8080/ProjetoFinal_SpringMVC/venda/remover/" + id;
				$(location).attr('href', url);
			});
		});
		
        function calc_total() {
	
            var qtd = parseInt(document.getElementById('cQtd').value);
            
            var e = document.getElementById("produto");
            var x = e.options[e.selectedIndex].text;
            
            
            tot = qtd * x;
            tot2 = tot;
            document.getElementById('total').value = tot2;
        }
        

	</script>
		<footer id="rodape">
			<p>Copyright 2022 - by Christian Souza</p>
			<p>
				<a href="https://www.facebook.com/christian.rod.927" target="_blank">Facebook</a>
				| <a href="https://www.instagram.com/christianrod44/"
					target="_blank">Instagram</a>
			</p>
		</footer>
	</div>
</body>
</html>