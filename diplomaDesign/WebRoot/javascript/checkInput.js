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


//����޸�����
function confirmPassword(){
	var old = document.getElementById("newPassword").value;
	var ne = document.getElementById("newPasswordCon").value;
	var reg = /^[0-9A-Za-z]{6,20}$/; // '/^[1-9]d{4,10}$/';
	
	//�ж�����ĳ���
	if( old.length > 20 || ne.length > 20 ){
		alert("�������������������ϲ�����Ҫ��");
		return false;
	}
	
	//������ʽ����������6-20���ַ�������
	if( !reg.test(old) ){
		alert("����ֻ����6-20���ַ�������");
		return false;
	}
	//�ж������Ƿ���ͬ
	if( old !== ne ){
		alert("��������������벻��ͬ�����������룡");
		return false;
	}
	return true;
}