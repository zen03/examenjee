<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>LISTE DE TOUS LES UTILISATUERS</title>
	<link rel="stylesheet" href="./css/bootstrap.min.css">
	<script type="text/javascript" src="./js/script.js"></script>
</head>
<body>
   <!--  Menu -->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<ul class="nav navbar-nav">
			 <li><a href="Etudiant?page=add">AJOUTER UN ETUDIANT</a></li>
			<li><a href="Etudiant?page=liste">LISTE DE TOUS LES ETUDIANTS</a></li>
		
		</ul>
	</div>
	<!--  Contenu -->
	<div class="container" style="margin-top:75px;">
		<div class="panel panel-default">
			<div class="panel-heading"> LISTE DES ETUDIANTS</div>
			<div class="panel-body" >
				<table class="table table-bordered table-striped">
					 <tr>
					 		<td>MATRICULE ETUDIANT</td>
					 		<td>NOM</td>
					 		<td>PRENOM </td>
					 		<td>TELEPHONE</td>
					 	
					 		<td>Action</td>
					 		<td>Action</td>
					 		
					 </tr>

					<c:forEach items="${etudiants}" var="etudiant">
					
						 <tr>
						 		<td>${etudiant.mat}</td>
						 		<td>${etudiant.nom}</td>
						 		<td>${etudiant.prenom}</td>
						 		<td>${etudiant.tel}</td>
						 		
						 		<td><a href="Etudiant?page=edit&mat=${etudiant.mat }">Ajouter un note</a></td>
						 		
						 		<td><a href="Etudiant?page=delete&mat=${etudiant.mat }" onclick="return confirmation();">Supprimer</a></td>
						 	
						 </tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

</body>
</html>