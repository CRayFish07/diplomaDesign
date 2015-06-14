function check(){
	var checkInput = document.getElementsByTagName("input");
	var i;
	for(var i=0; i<checkInput.length; i++){
		if(checkInput[i].value == ""){
			alert(checkInput[i].name + " can't be null");
			return false;
		}
	}
	return true;
}


//检测修改密码
function confirmPassword(){
	var old = document.getElementById("newPassword").value;
	var ne = document.getElementById("newPasswordCon").value;
	var reg = /^[0-9A-Za-z]{6,20}$/; // '/^[1-9]d{4,10}$/';
	
	//判断密码的长度
	if( old.length > 20 || ne.length > 20 ){
		alert("输入的密码过长，不符合不符合要求");
		return false;
	}
	
	//正则表达式测试密码是6-20的字符和数字
	if( !reg.test(old) ){
		alert("密码只能是6-20的字符和数字");
		return false;
	}
	//判断密码是否相同
	if( old !== ne ){
		alert("输入的两次新密码不相同，请重新输入！");
		return false;
	}
	return true;
}