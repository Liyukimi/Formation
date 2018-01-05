/************************************************
*	V5 : Fonctions avec retour					*
************************************************/
function afficheBienvenu()
{
	return "Bienvenu Toto";
}

function afficheVisites()
{
	var nbVisite = 2+12;
	var phrase = "C'est votre "+nbVisite+ " visite"
	return phrase;
}
document.getElementById("bienvenu").innerHTML = afficheBienvenu();	
document.getElementById("visites").innerHTML = afficheVisites();

/************************************************
*	V7 : Test des variables globales/locales	*
************************************************/

var message = 'Ici la variable globale !';

function showMsg() {
    var message = 'Ici la variable locale !';
    alert(message);
}
showMsg();
alert(message);

/************************************************
*	V8 : Création et appel d'objet				*
*	V9 : Manipulation de tableaux
************************************************/
// Mode "à la main" format JSON
// Objet avec trois propriétés et une méthode
var person = {
		"prenom":"Bugs", 
		"nom":"Bunny", 
		"login":"Lapin", 
		"affichage":function(){return this.prenom + " " + this.nom + " le " + this.login}
	};
document.getElementById("nom").innerHTML = "Nom : "+person.nom;
document.getElementById("prenom").innerHTML = "Prenom : "+person.prenom;
document.getElementById("login").innerHTML = "Login : " + person.login;
document.getElementById("bonjour").innerHTML = "Bonjour " + person.affichage();

// Liste de personnes avec format JSON 
var clientsText = '{ "clients" : ' +
	'['+
		'{"nom": "Duck", "prenom":"Daffy"},'+
		'{"nom": "Minnet", "prenom":"Gros"}'+
	']'+
'}';
// Transforme la chaine de caractères (format JSON clé/valeur) en objet
var clientsObjet = JSON.parse(clientsText);

// Création d'objet "mode constructor/prototype"
function Client(nom,prenom)
{
	this.nom = nom;
	this.prenom = prenom;
}
var client1 = new Client("Bunny","Bugs");
var client2 = new Client("Bunny","Lola");
// Tableau d'objets
var suiteClients = [client1, client2];
	

// Création des lignes d'un tableau HTML depuis la liste objets JSON
var listeClients = "";
for(i=0; i<clientsObjet.clients.length; i++)
{
	listeClients += "<tr>"+
						"<td>"+		clientsObjet.clients[i].prenom 		+"</td>"+
						"<td>"+		clientsObjet.clients[i].nom 		+"</td>"+
					"</tr>";
}
// Ajout des objets client1 et client2 stockés dans le tableau suiteClients
for(i=0; i<suiteClients.length; i++)
{
	listeClients += "<tr>"+
						"<td>"+		suiteClients[i].prenom 		+"</td>"+
						"<td>"+		suiteClients[i].nom 		+"</td>"+
					"</tr>";
}		
document.getElementById("AffichageClients").innerHTML = listeClients;
	