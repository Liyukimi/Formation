<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Accueil</title>
</head>
<body>
<h1>
	Bienvenue ! 
</h1>

<P>  Nous sommes le ${serverTime}. </P>

<P><a href="/welcome">Page avec du CSS</a></P>
<P><a href="employes/listeEmployes">Liste des employés Objis</a></P>


<a href="http://www.objis.com"><img src="/logo_objis.png" border=0></a>

</body>
</html>