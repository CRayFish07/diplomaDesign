window.onload = function(){
	/*
	var ac = document.getElementById("sub");
	ac.onclick = function(){
		var old = document.getElementById("old").value;
		var ne = document.getElementById("ne").value;
		
		if( old !== ne){
			alert("字符串不匹配");
			return false;
		}
		return true;
	}
	*/
}

//检查新密码和确认的密码是不是相同
function confirmPassword(){
		var old = document.getElementById("old").value;
		var ne = document.getElementById("ne").value;
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

//测试用户名只能是字母和数字的组合，用户名的开始只能是字母
function confirmUserName(){
	var name = document.getElementById("name").value;
	var reg = /^[a-zA-Z][a-zA-Z0-9]{5,19}$/;
	
	//验证用户名的是否是符合规则
	if( !reg.test(name) ){
		alert("用户名只能是6-20位，由字母开头，数字和字母的组合");
		return false;
	}
	return true;
}

//测测试邮箱填写是不是符合规范
function confirmEmail(){
	var email = document.getElementById("email").value;
	var reg = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
	
	if( !reg.test(email) ){
		alert("邮箱验证有误，请重新输入！");
		return false;
	}
	return true;
}

//测试手机号码格式是否正确
function confirmPhone(){
	var phone = document.getElementById("phone").value;
	var reg = /^1\d{10}$/;
	
	if( !reg.test(phone) ){
		alert("手机号验证不正确！");
		return false;
	}
	return true;
}
