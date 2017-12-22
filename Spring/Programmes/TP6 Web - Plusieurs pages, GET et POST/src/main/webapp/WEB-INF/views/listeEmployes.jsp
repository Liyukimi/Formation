<%@ page contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Equipe société Objis </title>
</head>
<body>
<h2>Ils vont vous faire aimer Java :</h2>

<c:if test = "${!empty listeEmployes}">
	<form action="detailEmploye" method="Post">
		<table class="table table-striped">						
			<thead>
				<tr>
					<th>Choix</th>
					<th>Nom</th>
					<th>Prénom</th>
					<th>eMail</th>
				</tr>
			</thead> 
			<tbody>							
				<c:forEach items="${listeEmployes}" var="employe" >
					<tr>
						<td><input class="form-check-input" type="radio" name="idSelect" id="${employe.id}" value="${employe.id}"></td>						
						<td>${employe.nom}</td>
						<td>${employe.prenom}</td>									
						<td>${employe.email}</td>							
					</tr>
				</c:forEach>								
			</tbody>				
		</table>	
		
		<button type=submit class="btn btn-primary" name="action" value="ClientSelect">Voir les informations de l'employé</button>

	</form>
	</c:if>

<a href="http://www.objis.com"><img src="resources/logo_objis.png" border=0></a>
</body>
</html>	
