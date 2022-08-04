<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Produto</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.2/font/bootstrap-icons.css">
<style>
	
	#interface{
	    width: 1200px;
	    background-color: #dcdcdc;
	    margin: 10px auto 0px auto;
	    box-shadow: 10px 10px 10px rgba(0,0,0,.5);
	    padding: 10px 10px 10px 10px;
	    position: relative;
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
	#rodape {
		clear: both;
		border-top: 1px solid #606060;
	}

	#rodape p {
		text-align: center;
	}
	
</style>
</head>
<body>
<div id="interface">
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<h3>Novo Produto</h3>
				<div>
					<div class="md-3">
						<label class="form-label">Nome:</label> 
						<input class="form-control"	type="text" name="nome" id="nome" />
					</div>
	
					<div class="md-3">
						<label class="form-label">Descrição:</label> 
						<input class="form-control"	type="text" name="descricao" id="descricao" />
					</div>
	
					<div class="md-3">
						<label class="form-label">Valor:</label> 
						<input class="form-control"	type="text" name="valor" id="valor" />
					</div>
					<button type="button" class="btn btn-primary"  id="btnIncluir">Incluir Produto</button>	
				</div>
				<div>
					<ul>
						<li><a href=<c:url value="/" />><i class="bi bi-house-door"></i> HOME</a></li>
						<li><a href=<c:url value="/produtos/inicio" />>Voltar</a></li>
					</ul>
				</div>

			</div>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<div class="col-sm-6">
				<h3>Lista de Produtos</h3>
				<table class="table table-striped" id="tabela">
					<thead>
						<tr>
							<th>NOME</th>
							<th>DESCRIÇÃO</th>
							<th>VALOR</th>
						</tr>
					</thead>
					<tbody>
					
					</tbody>
				</table>
			</div>
		</div>
	</div>
		<footer id="rodape">
			<p>Copyright 2022 - by Christian Souza</p>
			<p>
				<a href="https://www.facebook.com/christian.rod.927" target="_blank">Facebook</a>
				| <a href="https://www.instagram.com/christianrod44/"
					target="_blank">Instagram</a>
			</p>
		</footer>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
	
		function listarProdutos() {
			$.ajax({
				dataType: 'json',
				url: 'http://localhost:8080/ProjetoFinal_SpringMVC/api/produtos',
				method: 'GET',
				success: function(resposta) {
					$.each(resposta, function(index, item){
						let linha = $('<tr>');
						
						let colunas = '<td>' + item.nome + '</td>';
						colunas += '<td>' + item.descricao + '</td>';
						colunas += '<td>' + item.valor + '</td>';
						
						linha.append(colunas);
						
						$('#tabela > tbody').append(linha);
					})
				},
				error: function(erro) {
					console.log(erro.responseText);
				}
			});
		}
	
		$(document).ready(function() {
			listarProdutos();
			$('#btnIncluir').click(function() {
				$.ajax({
					headers: {
						"Accept": "application/json",
						"Content-Type": "application/json"
					},
					dataType: 'json',
					url: 'http://localhost:8080/ProjetoFinal_SpringMVC/api/produtos',
					method: 'POST',
					data: JSON.stringify ({
						nome: $('#nome').val(),
						descricao: $('#descricao').val(),
						valor: $('#valor').val()
					}),
					success: function(resposta) {
						window.alert('Dados Incluídos');
						listarProdutos();
					},
					error: function(erro) {
						window.alert('Erro:' + erro.responseText());
					}
				});
			});

		});
	</script>	
</body>
</html>