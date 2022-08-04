<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Usuários</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.2/font/bootstrap-icons.css">
<style>
	
	#interface{
	    width: 450px;
	    background-color: #dcdcdc;
	    margin: 100px auto 0px auto;
	    box-shadow: 10px 10px 10px rgba(0,0,0,.5);
	    padding: 10px 10px 10px 10px;
	    position: relative;
	}
	
	.borda{
		max-width: 400px;
		margin: auto;
	}
</style>
</head>
<body>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<div id="interface">
	<div class="container">
		<div class="borda">
			<h1 class="text-primary">Cadastro de Usuários</h1>
			<form action=<c:url value="/users/cadusuario" /> method="post">
				
				
				<div class="md-3">
					<label class="form-label">Username:</label> 
					<input class="form-control" type="text" name="login" />
				</div>

 				<div class="md-3">
					<label class="form-label">Password:</label> 
					<input class="form-control" type="password" name="password" />
				</div> 
				<button type="submit" class="btn btn-primary">Incluir Usuário</button>
			</form>
		</div>
	</div>
	</div>
</body>
</html>