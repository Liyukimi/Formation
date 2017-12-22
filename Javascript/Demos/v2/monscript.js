window.onload() = function(){
	var btnAction= document.getElementById("demo");
	btnAction.onclick = myFunction;
}

function myFunction() {
    document.getElementById("demo").innerHTML = Date();
}