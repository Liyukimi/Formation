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

