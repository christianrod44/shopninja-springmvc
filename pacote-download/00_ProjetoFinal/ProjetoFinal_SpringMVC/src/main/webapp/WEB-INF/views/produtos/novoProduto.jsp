<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Produtos</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
	.borda{
		max-width: 400px;
		margin: auto;
	}
</style>
</head>
<body>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<div class="container">
		<div class="borda">
			<h1 class="text-primary">Cadastro de Produtos</h1>
			<form action=<c:url value="/cadproduto" /> method="post">

				<div class="md-3">
					<label class="form-label">Nome:</label> 
					<input class="form-control"	type="text" name="nome" />
				</div>

				<div class="md-3">
					<label class="form-label">Descrição:</label> 
					<input class="form-control"	type="text" name="descricao" />
				</div>

				<div class="md-3">
					<label class="form-label">Valor:</label> 
					<input class="form-control"	type="text" name="valor" />
				</div>
				<button type="submit" class="btn btn-primary">Incluir Produto</button>
			</form>
		</div>
	</div>
</body>
</html>