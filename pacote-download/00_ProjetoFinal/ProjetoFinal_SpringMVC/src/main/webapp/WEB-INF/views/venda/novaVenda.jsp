<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Venda</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.2/font/bootstrap-icons.css">
<style>
	#interface{
	    width: 480px;
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
	
	ul {
		list-style: none;
		text-transform: uppercase;
		top: 10px;
		left: 300px;
		text-align: center;
		padding: 20px 10px auto 10px;
		margin: 20px 30px 0px auto;
	}
	
	ul {
		list-style: none;
		text-transform: uppercase;
		top: 10px;
		left: 300px;
	}	
	li{
		display: inline-block;
	}
	a {
		color: #000000;
		text-decoration: none;
		
	}
	
	a:hover {
		color: #ffffff;
		text-decoration: underline;
	}
	#rodape {
		clear: both;
		border-top: 1px solid #606060;
		margin: 20px auto 0px auto;
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
		<div class="borda">
			<h1 class="text-primary">Realizar Compra</h1>
			<form action=<c:url value="/cadvenda" /> method="post">
				<div class="md-3">				
					<label class="form-label">Data:</label>
					<input class="form-control" type="date" id="dataatual" name="dataatual"/>
				</div>
				<div class="md-3">
					<label class="form-label" >Produto:</label>
  					<input class="form-control" type="text" id="produto_id" name="produto"/>
				</div>
				<div class="md-3">				
					<label class="form-label" >Cliente:</label>
					<input class="form-control" type="text" id="cliente_id" name="cliente"/>
				</div>

				<div class="md-3">
					<label class="form-label" >Total:</label> 
					<input class="form-control"	type="text" id="total" name="total"/>
				</div>
				<button type="submit" class="btn btn-primary">Concluir compra</button>
			<div>
				<ul>
					<li><a href=<c:url value="/venda/inicio" />>Voltar</a></li>
					<li><a href=<c:url value="/" />><i class="bi bi-house-door"></i>HOME</a></li>
				</ul>
			</div>
			</form>
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
	</div>
</body>
</html>