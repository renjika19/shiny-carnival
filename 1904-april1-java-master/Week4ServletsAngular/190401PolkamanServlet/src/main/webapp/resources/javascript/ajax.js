//The following is going to involve a bit of AJAX
function fetchPolkamanList(){
	let xhr = new XMLHttpRequest();
	let url ="/190401PolkamanServlet/FetchPolkamansServlet"; // this refers to
	//the fetch polkamans servlet resource
	
	let option = null;
	let polkamans = null;
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			polkamans = JSON.parse(xhr.response);
			
			console.log(polkamans);
			for(let index in polkamans){ //for each loop
				option = document.createElement("option");
				option.setAttribute("value", polkamans[index]["id"]);
				option.innerHTML=polkamans[index]["name"];
				document.getElementById("polkalist").appendChild(option);
			}
			document.getElementById("listdefault").innerHTML = 
				"----PICK A STARTER---";
		}
	}
	
	xhr.open("GET",url);
	xhr.send();
}

window.onload = function(){
	console.log("AJAX ready")
	fetchPolkamanList();
}