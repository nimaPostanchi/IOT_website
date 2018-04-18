var randomSandwichRequest = new XMLHttpRequest();

function getAvailableSandwiches(){
	randomSandwichRequest.open("GET", "Controller", true);
	randomSandwichRequest.onreadystatechange = getSandwichCallBack;
	randomSandwichRequest.send(null);
}

function getSandwichCallBack(){
	if (randomSandwichRequest.status == 200) {
		if (randomSandwichRequest.readyState == 4) {
			var serverRsponse = JSON.parse(randomSandwichRequest.responseText);
//			console.log(serverRsponse);
			
			var sandwichDiv = document.getElementById("available");
			var sandwichParagraph = sandwichDiv.childNodes[0];
			
			if (sandwichParagraph == null) {
				sandwichParagraph = document.createElement('p');
				sandwichParagraph.id = "sandwichText";
				var sandwichText = document.createTextNode(serverRsponse);
				sandwichParagraph.appendChild(sandwichText);
				sandwichDiv.appendChild(sandwichParagraph);
			}
			else {
				var sandwichText = document.createTextNode(serverRsponse);
				sandwichParagraph.removeChild(sandwichParagraph.childNodes[0]);
				sandwichParagraph.appendChild(sandwichText);
			}
			setTimeout("getAvailableSandwiches()", 5000);
		}
	}
}