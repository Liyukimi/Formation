window.onload = chargementPage;

function chargementPage()
{
	var btnAction = document.getElementById("validSupp");
	btnAction.onmouseover = afficheSupp;
	btnAction.onmouseout = effaceSupp;
	btnAction.onclick = validerSuppr;	
}

