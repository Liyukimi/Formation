/************************************************
*	V14 : AJAX									*
************************************************/
function chargementListeRequete()
{
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = chargementListe;
}

function chargementListe()
{
	if(xhr.readyState == 4 && xhr.status == 200)
	{
		document.getElementById("ListeAJAX").innerHTML = xhr.responseText;
	}
	xhr.open("GET", "listeClients.json", true);
	xhr.send();
}

// Création des lignes d'un tableau HTML depuis la liste objets JSON
var listeClients = xhr.responseText;
var listeClientsTableau = "";
for(i=0; i<listeClients.length; i++)
{
	listeClientsTableau += "<tr>"+
								"<td>"+		listeClients[i].prenom 		+"</td>"+
								"<td>"+		listeClients[i].nom 		+"</td>"+
							"</tr>";
}