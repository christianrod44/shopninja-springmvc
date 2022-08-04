<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Clientes</title>
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
		<h1 class="text-primary">Lista de Clientes</h1>
		<div>
			<ul>
				<li><a href=<c:url value="/" />><i class="bi bi-house-door"></i> HOME</a></li>
			</ul>
		</div>
		<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalinc">Novo Cliente</button>
		
		<table class="table table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>NOME</th>
					<th>CPF</th>
					<th>CEP</th>
					<th></th>
					<th>ALTERAR / DADOS / EXCLUIR</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cl" items="${clientes}">   <!-- esse cliente esta denominado no controller -->
					<tr>
						<td>${cl.id}</td>
						<td>${cl.nome}</td>
						<td>${cl.cpf}</td>
						<td>${cl.cep}</td>
						<td></td>
						<td>
<%-- 							<a href=<c:url value="/cliente/alterar/${cl.id}" />>Alterar</a> --%>
							
							<button type="button" class="btn altera"
								data-id="${cl.id}"
								data-nome="${cl.nome}"
								data-cpf="${cl.cpf}"
								data-cep="${cl.cep}"
								data-logradouro="${cl.logradouro}"
								data-numero="${cl.numero}"
								data-bairro="${cl.bairro}"
								data-cidade="${cl.cidade}"
								data-uf="${cl.uf}"
								data-bs-toggle="modal"
								data-bs-target="#modalupd"><i class="bi bi-pencil-square"></i></button> &nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp; 
							
							<button type="button" class="btn busca"
								data-id="${cl.id}"
								data-nome="${cl.nome}"
								data-cpf="${cl.cpf}"
								data-cep="${cl.cep}"
								data-logradouro="${cl.logradouro}"
								data-numero="${cl.numero}"
								data-bairro="${cl.bairro}"
								data-cidade="${cl.cidade}"
								data-uf="${cl.uf}"
								data-bs-toggle="modal"
								data-bs-target="#modalvw"><i class="bi bi-person-fill"></i></button> &nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp; 
							
							<button type="button" class="btn remove"
								data-id="${cl.id}"
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
	        <h4>Tem certeza que deseja remover este cliente?</h4>
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
	    	<form action=<c:url value="/alteracliente" /> method="post">
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
					<input class="form-control" type="text" id="nome" name="nome" />
				</div>
				
				<div class="md-3">
					<label class="form-label">CPF:</label>
					<input class="form-control" type="text" id="cpf" name="cpf" />
				</div>
					
				<div class="md-3">
					<label class="form-label">CEP(sem hífen):</label>
					<input class="form-control" type="text" id="acep" name="cep"  />
				</div>
				<div class="md-3">
					<label class="form-label">Logradouro:</label>
					<input class="form-control" type="text" id="alogradouro" name="logradouro"  />
				</div>
				<div class="md-3">
					<label class="form-label">Número:</label>
					<input class="form-control" type="text" id="numero" name="numero"  />
				</div>
				<div class="md-3">
					<label class="form-label">Bairro:</label>
					<input class="form-control" type="text" id="abairro" name="bairro"  />
				</div>
				<div class="md-3">
					<label class="form-label">Cidade:</label>
					<input class="form-control" type="text" id="acidade" name="cidade"  />
				</div>
				<div class="md-3">
					<label class="form-label">UF:</label>
					<input class="form-control" type="text" id="auf" name="uf"  />
				</div>
			</div>
	      </div>
	      
	      <!-- footer -->
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
	        	Cancelar
	        </button>
	        <button type="submit" class="btn btn-primary" data-bs-dismiss="modal">
	        	Alterar Cliente
	        </button>
	      </div>
	      </form>
	      
	    </div>
	  </div>
	</div>
	
	<!-- Modal Buscar (gambiarra) -->
	<div class="modal fade" id="modalvw" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	    	<form action=<c:url value="/alteracliente" /> method="post">
	      <!-- header -->
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Dados</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      
	      <!-- body -->
	      <div class="modal-body">
			<div class="borda">
				<input type="hidden" id="id2" name="id" />
				<div class="md-3">
					<label class="form-label">Nome:</label>
					<input class="form-control" type="text" id="nome2" name="nome" readonly />
				</div>
				
				<div class="md-3">
					<label class="form-label">CPF:</label>
					<input class="form-control" type="text" id="cpf2" name="cpf" readonly />
				</div>
				
				<div class="md-3">
					<label class="form-label">CEP(sem hífen):</label>
					<input class="form-control" type="text" id="cep2" name="cep" readonly  />
				</div>
				<div class="md-3">
					<label class="form-label">Logradouro:</label>
					<input class="form-control" type="text" id="logradouro2" name="logradouro" readonly  />
				</div>
				<div class="md-3">
					<label class="form-label">Número:</label>
					<input class="form-control" type="text" id="numero2" name="numero" readonly  />
				</div>
				<div class="md-3">
					<label class="form-label">Bairro:</label>
					<input class="form-control" type="text" id="bairro2" name="bairro" readonly  />
				</div>
				<div class="md-3">
					<label class="form-label">Cidade:</label>
					<input class="form-control" type="text" id="cidade2" name="cidade" readonly  />
				</div>
				<div class="md-3">
					<label class="form-label">UF:</label>
					<input class="form-control" type="text" id="uf2" name="uf" readonly  />
				</div>	
			</div>
	      </div>
	      
	      <!-- footer -->
	      <div class="modal-footer">
	        <button type="button" class="btn btn-primary" data-bs-dismiss="modal">
	        	OK
	        </button>
	      </div>
	      </form>
	      
	    </div>
	  </div>
	</div> <!-- fim buscar (gambiarra) -->
	
			<!-- Modal Incluir -->
	<div class="modal fade" id="modalinc" tabindex="-1" 
			aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	    	<form action=<c:url value="/cadcliente" /> method="post">
	      <!-- header -->
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Novo Cliente</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      
	      <!-- body -->
	      <div class="modal-body">
			<div class="borda">
				<div class="md-3">
					<label class="form-label">Nome:</label>
					<input class="form-control" placeholder="nome completo" type="text" id="nome" name="nome"  />
				</div>
				
				<div class="md-3">
					<label class="form-label">CPF:</label>
					<input class="form-control" placeholder="apenas os números" type="text" id="cpf" name="cpf" />
				</div>
				
				<div class="md-3">
					<label class="form-label">CEP:</label>
					<input class="form-control" placeholder="apenas os números" type="text" id="cep" name="cep"  />
					<button type="button" class="btn btn-primary" id="btnBuscar">Buscar</button>
				</div>
				<div class="md-3">
					<label class="form-label">Logradouro:</label>
					<input class="form-control" type="text" id="logradouro" name="logradouro" readonly  />
				</div>
				<div class="md-3">
					<label class="form-label">Número:</label>
					<input class="form-control" type="text" id="numero" name="numero"  />
				</div>
				<div class="md-3">
					<label class="form-label">Bairro:</label>
					<input class="form-control" type="text" id="bairro" name="bairro" readonly  />
				</div>
				<div class="md-3">
					<label class="form-label">Cidade:</label>
					<input class="form-control" type="text" id="cidade" name="cidade" readonly />
				</div>
				<div class="md-3">
					<label class="form-label">UF:</label>
					<input class="form-control" type="text" id="uf" name="uf" readonly  />
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
				$('#cpf').val($(this).attr('data-cpf'));
				$('#acep').val($(this).attr('data-cep'));
				$('#alogradouro').val($(this).attr('data-logradouro'));
				$('#numero').val($(this).attr('data-numero'));
				$('#abairro').val($(this).attr('data-bairro'));
				$('#acidade').val($(this).attr('data-cidade'));
				$('#auf').val($(this).attr('data-uf'));
			});
			
			$('.busca').click(function() {
				$('#id2').val($(this).attr('data-id'));
				$('#nome2').val($(this).attr('data-nome'));
				$('#cpf2').val($(this).attr('data-cpf'));
				$('#cep2').val($(this).attr('data-cep'));
				$('#logradouro2').val($(this).attr('data-logradouro'));
				$('#numero2').val($(this).attr('data-numero'));
				$('#bairro2').val($(this).attr('data-bairro'));
				$('#cidade2').val($(this).attr('data-cidade'));
				$('#uf2').val($(this).attr('data-uf'));
			});
			
			$('#btnBuscar').click(function(){
					$.ajax({
						dataType: 'json',
						url: 'https://viacep.com.br/ws/' + $('#cep').val() + '/json/',
						method: 'GET',	
						success: function(resposta) {	
							console.log(resposta);
						
							$('#logradouro').val(resposta.logradouro);  
							$('#bairro').val(resposta.bairro);
							$('#cidade').val(resposta.localidade);
							$('#uf').val(resposta.uf);
						},		
						error: function(erro) {	
							console.log(erro.responseText);
						}
					});
				});	
			
			$('#btnRemover').click(function() {
				let url = "http://localhost:8080/ProjetoFinal_SpringMVC/cliente/remover/" + id;
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