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

//密码修改的时候点击“重置”，消除掉填写的信息。
function clearInput(){
	var inpu = document.getElementsByTagName("input");
	for(var i=0; i<inpu.length; i++){
		inpu[i].value = "";
	}
	return false;	
}

//增加用户界面的手机号码、QQ号码、email的校验、非空校验
function confirmEmployee(){
	//校验输入非空
	var inpu = document.getElementsByTagName("input");
	for(var i=0; i<inpu.length; i++){
		if(inpu[i].value == ""){
			alert("请输入全部信息！");
			return false;
		}
	}
	//校验手机号码
	var phone = document.getElementById("phone").value;
	var regPhone = /^1\d{10}$/;
	if( !regPhone.test(phone) ){
		alert("手机号验证不正确！");
		return false;
	}
	
	//校验QQ密码，只能是4-10位QQ号码
	var QQ = document.getElementById("QQ").value;
	var regQQ = /^\d{4,10}$/;
	if( !regQQ.test(QQ) ){
		alert("QQ号码为4-10位的数字");
		return false;
	}
	
	//校验email格式
	var email = document.getElementById("email").value;
	var regEmail = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
	
	if( !regEmail.test(email) ){
		alert("邮箱验证有误，请重新输入！");
		return false;
	}
	//校验通过，返回正确
	return true;
}

//退出时使用的确认提醒
function exitConfirm(){
	if(confirm("是否退出当前登录?")){
		return true;
	}
	return false;
}

//删除时使用的确认提醒
function deleteConfirm(){
	if(confirm("是否删除数据?")){
		return true;
	}
	return false;
}

//修改时使用的确认提醒
function updateConfirm(){
	if(confirm("是否修改数据?")){
		return true;
	}
	return false;
}

//增加登录账号时使用的确认提醒
function addCountConfirm(){
	//校验输入非空
	var inpu = document.getElementsByTagName("input");
	for(var i=0; i<inpu.length; i++){
		if(inpu[i].value == ""){
			alert("请输入全部信息！");
			return false;
		}
	}
	
	if(confirm("确认增加用户登录信息?")){
		return true;
	}
	return false;
}

//需改房间时使用的确认提醒
function updateRoomConfirm(){
	//校验输入非空
	var inpu = document.getElementsByTagName("input");
	for(var i=0; i<inpu.length; i++){
		if(inpu[i].value == ""){
			alert("请输入全部信息！");
			return false;
		}
	}
	
	if(confirm("确认修改房间信息？")){
		return true;
	}
	return false;
}

//总经理审批时使用的确认提醒
function passConfirm(){
	if( confirm("确认通过这次申请？") ){
		 return true;
	}
	return false;
}

//部门经理会议申请校验
function confirmApplication(){
	var startD = document.getElementById("startD").value;
	var hourS = document.getElementById("hourS").value;
	var miniteS = document.getElementById("miniteS").value;
	
	var endD = document.getElementById("endD").value;
	var hourE = document.getElementById("hourE").value;
	var miniteE = document.getElementById("miniteE").value;
	
	var remarks = document.getElementById("remarks").value;
	var capacity = document.getElementById("capacity").value;
	
	//判断是否为空
	if( startD == ""){
		alert("开始时间不能为空");
		return false;
	}
	if( hourS == "" ){
		alert("开始时间小时不能为空");
		return false;
	}
	if( miniteS == ""){
		alert("开始时间分钟不能为空");
		return false;
	}
	if( endD == ""){
		alert("结束时间不能为空");
		return false;
	}
	if( hourE == ""){
		alert("结束时间小时不能为空");
		return false;
	}
	if( miniteE == ""){
		alert("结束时间分钟不能为空");
		return  false;
	}
	if( remarks == ""){
		alert("会议主题不能为空");
		return false;
	}
	if( capacity == ""){
		alert("会议室大小不能为空");
		return false;
	}
	
	var timeS = startD + hourS + miniteS;
	var timeE = endD + hourE + miniteE;
	
	timeS = timeS.replace("-", "");
	timeS = timeS.replace("-", "");
	timeE = timeE.replace("-", "");
	timeE = timeE.replace("-", "");
	
	if( timeS >= timeE ){
		alert("结束时间不能比开始时间早");
		return false;
	}
	
	return true;
}

