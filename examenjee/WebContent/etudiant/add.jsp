<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title>AJOUTER UN ETUDIANT</title>
		<link rel="stylesheet" href="./css/bootstrap.min.css">
	</head>
	<body>
	<!--  Menu -->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<ul class="nav navbar-nav">
	 <li><a href="Etudiant?page=add">AJOUTER UN ETUDIANT</a></li>
				<li><a href="Etudiant?page=liste">LISTE DE TOUS LES ETUDIANTS</a></li>
		</ul>
	</div>
	
	<c:if test="${message !=null }">
		<c:if test="${message == 1 }">
 			<div class="alert alert-success" style="margin-top:75px;">Données ajoutées</div>
		</c:if>	
		<c:if test="${message == 0}">
 		<div class="alert alert-success" style="margin-top:75px;">Données non ajoutées</div>
		</c:if>	
	</c:if>

	
	<!--  Contenu -->
		<div class="container" style="margin-top:75px;">
			<div class="panel panel-default">
				<div class="panel-heading"> AJOUTER ETUDIANT</div>
				<div class="panel-body" >
				<form method="Post" action="Etudiant">
					<div class="form-group">
						<label class="control-label"> NOM  </label>
						<input class="form-control" type="text" name="nomU"/>
					</div>
					<div class="form-group">
						<label class="control-label"> PRENOM  </label>
						<input class="form-control" type="text" name="prenomU"/>
					</div>
					<div class="form-group">
						<label class="control-label"> TELEPHONE</label>
						<input class="form-control" type="text" name="telU"/>
					</div>
					
				
					<div class="form-group">
						<input class="btn btn-success " type="submit" name="action" value="Envoyer"/>
						<input class="btn btn-danger " type="reset" name="annuler" value="Annuler"/>
						
					</div>
				</form>
				</div>
			</div>
		</div>
	</body>
</html>