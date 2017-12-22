<%@ page contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Equipe société Objis </title>
</head>
<body>

	<h2>Employe : ${employe.prenom} ${employe.nom}</h2>
	<ul>
		<li><strong>Nom :</strong> <c:out value="${employe.nom}"/></li>
		<li><strong>Prénom :</strong> <c:out value="${employe.prenom}"/></li>
		<li><strong>Login :</strong> <c:out value="${employe.login}" /></li>
		<li><strong>Rôle :</strong> <c:out value="${employe.role}"/> </li>
		<li><strong>email :</strong> <c:out value="${employe.email}"/></li>
	</ul>	
	
	
	<a href="http://www.objis.com"><img src="/logo_objis.png" border=0></a>

</body>
</html>	
