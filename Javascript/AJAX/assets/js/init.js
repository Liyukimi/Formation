window.onload = chargementPage;

function chargementPage()
{
	var btnAction = document.getElementById("validSupp");
	btnAction.onmouseover = afficheSupp;
	btnAction.onmouseout = effaceSupp;
	btnAction.onclick = validerSuppr;	
	
	var btnAfficheListe = document.getElementById("afficherListe");
	btnAfficheListe.onclick = chargementListe;
	
	var btnAfficheListeDynamique = document.getElementById("afficherListeDynamique");
	btnAfficheListeDynamique.onclick = affichageDynamique;
}

