<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Produtos</title>
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
 	    display: inline-block;    /* organizar ao lado */
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
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   <!-- biblioteca que dá acesso aos elementos jstl -->
	<div id="interface">
		<h1>Gerenciamento de Produtos</h1>
		
		<ul>
			<li><a href=<c:url value="/" />><i class="bi bi-house-door"></i> HOME</a></li>
			<li><a href=<c:url value="/produtos/listar" />>Lista de Produtos</a> </li>  <!-- o c:url especifica rotas , o que tá em value vai direcionar para action que está msrcado como listar-->
			<li><a href=<c:url value="/produtos/incluirapi" />>Cadastro de Produtos via API</a></li>
		</ul>
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