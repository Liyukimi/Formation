window.onload = function(){
	var btnAction= document.getElementById("monBouton");
	console.log(btnAction);
	console.log('coucou');
	btnAction.onclick = myFunction;
}

function myFunction() {
    document.getElementById("demo").innerHTML = "Toto";
}