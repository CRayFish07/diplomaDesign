function check(){
	var checkInput = document.getElementsByTagName("input");
	var i;
	for(i=0; i<checkInput.length; i++){
		if(checkInput[i].value == ""){
			alert(checkInput[i].name + " can't be null");
			return false;
		}
	}
	return true;
}