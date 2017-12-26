<%@ page contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Equipe société Objis </title>
</head>
<body>

	<h2>Employe : ${employe.prenom} ${employe.nom}</h2>
	<ul>
		<li><strong>Nom :</strong> ${employe.nom}</li>
		<li><strong>Prénom :</strong> ${employe.prenom}</li>
		<li><strong>Login :</strong> ${employe.login}"</li>
		<li><strong>Rôle :</strong> ${employe.role}</li>
		<li><strong>email :</strong> ${employe.email}</li>
	</ul>	
	
	
	<a href="http://www.objis.com"><img src="/logo_objis.png" border=0></a>

</body>
</html>	
