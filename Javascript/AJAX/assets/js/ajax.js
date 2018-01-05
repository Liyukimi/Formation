/************************************************
*	V14 : AJAX									*
************************************************/
function chargementListe()
{
	var listeClients;
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function()
	{
		if(xhr.readyState === 4 && xhr.status === 200)
		{
			var recup = xhr.responseText;
			//console.log(recup);
			
			// Création des lignes d'un tableau HTML depuis la liste objets JSON
			var objetJSON = JSON.parse(recup);
			console.log(listeClients);
			
			var listeClientsTableau = "";
			for(var i=0; i<objetJSON.clients.length; i+=1)
			{
				listeClientsTableau += "<tr>"+
											"<td>"+		objetJSON.clients[i].prenom 		+"</td>"+
											"<td>"+		objetJSON.clients[i].nom 		+"</td>"+
										"</tr>";
			}
			document.getElementById("ListeAJAX").innerHTML = listeClientsTableau;
		}
	};
	xhr.open("GET", "listeClients.json", true);
	xhr.send();	
}

/************************************************
*	AFFICHAGE/SUPPRESSION DYNAMIQUE				*
************************************************/
// Récupère un fichier JSON et lance la création d'un
// tableau à partir de ses valeurs
function affichageDynamique()
{
	var listeClients;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = creationTableau;
	
	// Le fichier JSON à récupérer
	xhr.open("GET", "listeClients.json", true);
	xhr.send();	
}
//Création du tableau depuis le fichier JSON 
//Obtenu via xhttprequest 
function creationTableau()
{
	//La requête a réussi
	if(xhr.readyState === 4 && xhr.status === 200)
	{
		var recup = xhr.responseText;
		// Création des lignes d'un tableau HTML depuis la liste objets JSON
		var objetJSON = JSON.parse(recup);
		console.log(listeClients);
		
		// Si le tableau existe déjà on le supprime
		var parent = document.getElementById("AffichageDynamique");
		if(parent.childNodes.length != 0)
		{
			var child = document.getElementById("listeClientsTableau");
			parent.removeChild(child);
		}
		else
		{			
			//Crée le noeud tableau avec un style css existant
			var tableau = document.createElement("table");
			tableau.className = "table table-striped";
			tableau.id = "listeClientsTableau";
			
			//Entête du tableau
				var entete = document.createElement("thead");
				//Crée une ligne
				var ligneEntete = document.createElement("tr");
				//Crée les colonnes 				
				var colonneNomEntete = document.createElement("th");
				var colonnePrenomEntete = document.createElement("th");
				//Texte des colonnes
				var nomEntete = document.createTextNode("Nom");
				var prenomEntete = document.createTextNode("Prenom");
				//Assigne le texte aux colonnes
				colonneNomEntete.appendChild(nomEntete);
				colonnePrenomEntete.appendChild(prenomEntete);
				//Assigne les colonnes à la ligne
				ligneEntete.appendChild(colonneNomEntete);
				ligneEntete.appendChild(colonnePrenomEntete);
				//Assigne la ligne à l'entête				
				entete.appendChild(ligneEntete);
				
			//Création du body du tableau
			var body = document.createElement("tbody");
			
			for(var i=0; i<objetJSON.clients.length; i+=1)
			{
				//Crée une ligne
				var ligne = document.createElement("tr");
				
				//Crée les colonnes 				
				var colonneNom = document.createElement("td");
				var colonnePrenom = document.createElement("td");
				//Texte des coionnes
				var nom = document.createTextNode(objetJSON.clients[i].nom);
				var prenom = document.createTextNode(objetJSON.clients[i].prenom);
				//Assigne les textes aux colonnes
				colonneNom.appendChild(nom);
				colonnePrenom.appendChild(prenom);
				
				//Création de l'arborescence du tableau						
				ligne.appendChild(colonneNom);
				ligne.appendChild(colonnePrenom);		
				body.appendChild(ligne);
			}
			
			//Assigne l'entête et le body au tableau
			tableau.appendChild(entete);
			tableau.appendChild(body);
			
			//Assigne le tableau à la div choisie
			document.getElementById("AffichageDynamique").appendChild(tableau);
		}
	}
}


