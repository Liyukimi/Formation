// V13 : confirmation d'envoie de formulaire
function validerSuppr()
{
	if (confirm('La suppression est definitive. Etes vous sur de vouloir supprimer le client?'))
		return true;
	else
		return false;
}

function afficheSupp()
{
	document.getElementById("validSupp").innerHTML = "Confirmer la suppression?"	
}

function effaceSupp()
{
	document.getElementById("validSupp").innerHTML = "Supprimer le client"	
}

// V7 : Test de la variable globale du fichier tp.js (doit être importé avant dans le html sinon message n'est pas défini)
//alert("Test autre fichier message = " + message);
