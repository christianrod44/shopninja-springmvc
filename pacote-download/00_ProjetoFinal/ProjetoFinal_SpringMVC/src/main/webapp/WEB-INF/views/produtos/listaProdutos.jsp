<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Produtos</title>
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
		<h1 class="text-primary">Lista de Produtos:</h1>
		<div>
			<ul>
				<li><a href=<c:url value="/" />><i class="bi bi-house-door"></i> HOME</a></li>
				<li><a href=<c:url value="/produtos/inicio" />>Voltar</a></li>
			</ul>
		</div>
		<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalinc">Novo Produto</button>
		
		<table class="table table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>NOME</th>
					<th>DESCRIÇÃO</th>
					<th>VALOR</th>
					<th></th>
					<th>ALTERAR / EXCLUIR</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="pr" items="${produtos}">   <!-- esse produto esta denominado no controller -->
					<tr>
						<td>${pr.id}</td>
						<td>${pr.nome}</td>
						<td>${pr.descricao}</td>
						<td>${pr.valor}</td>
						<td></td>
						<td>
<%-- 							<a href=<c:url value="/produtos/alterar/${pr.id}" />>Alterar</a> --%>
							
							<button type="button" class="btn altera"
								data-id="${pr.id}"
								data-nome="${pr.nome}"
								data-descricao="${pr.descricao}"
								data-valor="${pr.valor}"
								data-bs-toggle="modal"
								data-bs-target="#modalupd"><i class="bi bi-pencil-square"></i></button> &nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;
							
							
							<button type="button" class="btn remove"
								data-id="${pr.id}"
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
	        <h4>Tem certeza que deseja remover este produto?</h4>
	      </div>
	      <!-- footer -->
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Não</button>
	        <button type="button" id="btnRemover" class="btn btn-danger" data-bs-dismiss="modal">Remover</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- Modal Alterar -->
	<div class="modal fade" id="modalupd" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	    	<form action=<c:url value="/alteraproduto" /> method="post">
	      <!-- header -->
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Alteração</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      
	      <!-- body -->
	      <div class="modal-body">
			<div class="borda">
				<input type="hidden" id="id" name="id" />
				<div class="md-3">
					<label class="form-label">Nome:</label>
					<input class="form-control" type="text" id="nome" name="nome"  />
				</div>
				
				<div class="md-3">
					<label class="form-label">Descrição:</label>
					<input class="form-control" type="text" id="descricao" name="descricao" />
				</div>
				
				<div class="md-3">
					<label class="form-label">Valor:</label>
					<input class="form-control" type="text" id="valor" name="valor"  />
				</div>	
			</div>
	      </div>
	      
	      <!-- footer -->
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
	        	Cancelar
	        </button>
	        <button type="submit" class="btn btn-primary" data-bs-dismiss="modal">
	        	Alterar Produto
	        </button>
	      </div>
	      </form>
	      
	    </div>
	  </div>
	</div>
	
		<!-- Modal Incluir -->
	<div class="modal fade" id="modalinc" tabindex="-1" 
			aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	    	<form action=<c:url value="/cadproduto" /> method="post">
	      <!-- header -->
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Novo Produto</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      
	      <!-- body -->
	      <div class="modal-body">
			<div class="borda">

				<div class="md-3">
					<label class="form-label">Nome:</label>
					<input class="form-control" type="text" id="nome" name="nome"  />
				</div>
				
				<div class="md-3">
					<label class="form-label">Descrição:</label>
					<input class="form-control" type="text" id="descricao" name="descricao" />
				</div>
				
				<div class="md-3">
					<label class="form-label">Valor:</label>	
					<input class="form-control" type="text" id="valor" name="valor"  />
				</div>	
			</div>
	      </div>
	      
	      <!-- footer -->
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
	        	Cancelar
	        </button>
	        <button type="submit" class="btn btn-primary" data-bs-dismiss="modal">
	        	Incluir
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
			
			$('.altera').click(function() {
				$('#id').val($(this).attr('data-id'));
				$('#nome').val($(this).attr('data-nome'));
				$('#descricao').val($(this).attr('data-descricao'));
				$('#valor').val($(this).attr('data-valor'));
			});
			
			$('#btnRemover').click(function() {
				let url = "http://localhost:8080/ProjetoFinal_SpringMVC/produtos/remover/" + id;
				$(location).attr('href', url);
			});
			
			
		});
	
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