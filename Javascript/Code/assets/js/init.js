window.onload = chargementPage;

function chargementPage()
{
	var btnAction = document.getElementById("validSupp");
	btnAction.onmouseover = afficheSupp;
	btnAction.onmouseout = effaceSupp;
	btnAction.onclick = validerSuppr;	
	
	document.getElementById("bienvenu").innerHTML = afficheBienvenu();	
	document.getElementById("visites").innerHTML = afficheVisites();	
}

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


// Test des variables globales/locales
var message = 'Ici la variable globale !';

function showMsg() {
    var message = 'Ici la variable locale !';
    alert(message);
}

showMsg();

alert(message);