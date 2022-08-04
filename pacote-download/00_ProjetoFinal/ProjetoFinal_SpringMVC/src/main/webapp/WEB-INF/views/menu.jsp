<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.2/font/bootstrap-icons.css">
<style>
#interface {
	width: 1000px;
	background-color: #dcdcdc;
	margin: 10px auto 0px auto;
	box-shadow: 10px 10px 10px rgba(0, 0, 0, .5);
	padding: 10px 10px 10px 10px;
	position: relative;
}

a {
	color: #606060;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}

#cabecalho h1 {
	font-family: 'Arial', sans-serif;
	font-size: 30pt;
	color: #606060;
	text-shadow: 1px 1px 1px rgba(0, 0, 0, .6);
	margin-top: 10px;
	margin-bottom: 0px;
	padding: 0px;
}

#cabecalho h2 {
	font-family: 'Arial', sans-serif;
	font-size: 15pt;
	color: #888888;
	margin-top: 0px;
	padding: 0px;
}

#menu {
	display: block;
}

#menu ul {
	list-style: none;
	text-transform: uppercase;
	position: absolute;
	top: 10px;
	left: 300px;
}

#menu li {
	display: inline-block;
	background-color: #dddddd;
	padding: 10px;
	margin: 2px;
	transition: background-color 1s;
}

#menu li:hover {
	background-color: #606060;
}

#menu h1 {
	display: none;
}

#menu a {
	color: #000000;
	text-decoration: none;
}

#menu a:hover {
	color: #ffffff;
	text-decoration: underline;
}

#corpo {
	display: block;
	max-width: 550px;
	float: center;
	margin: auto;
}
video#filme {
    
    padding: 10px 10px 10px 10px;
    left: 90px;
    top: 85px;
    width: 440px;
}

#rodape {
	clear: both;
	border-top: 1px solid #606060;
}

#rodape p {
	text-align: center;
}
</style>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div id="interface">
		<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

		<header id="cabecalho">
			<hgroup>
				<h1>ShopNinja</h1>
				<h2>Materiais para treino</h2>
			</hgroup>
			<nav id="menu">
				<h1>Menu de Opções</h1>
				<ul>
					<li><a href=<c:url value="/venda/inicio" />>Venda</a></li>
					<li><a href=<c:url value="/produtos/inicio" />>Produtos</a></li>
					<li><a href=<c:url value="/cliente/listar" />>Clientes</a></li>
					<li><a href=<c:url value="/users/incluir" />>Cadastro de
							Usuários</a></li>
				</ul>
			</nav>
		</header>
		<section id="corpo">
			<div>
				    
				        <video id="filme" src="https://www.youtube.com/watch?v=UgS1xX9yYBw" /></video>
				    			
			</div>
		</section>
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