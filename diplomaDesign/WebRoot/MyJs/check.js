window.onload = function(){
	/*
	var ac = document.getElementById("sub");
	ac.onclick = function(){
		var old = document.getElementById("old").value;
		var ne = document.getElementById("ne").value;
		
		if( old !== ne){
			alert("�ַ�����ƥ��");
			return false;
		}
		return true;
	}
	*/
}

//����������ȷ�ϵ������ǲ�����ͬ
function confirmPassword(){
		var old = document.getElementById("old").value;
		var ne = document.getElementById("ne").value;
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

//�����û���ֻ������ĸ�����ֵ���ϣ��û����Ŀ�ʼֻ������ĸ
function confirmUserName(){
	var name = document.getElementById("name").value;
	var reg = /^[a-zA-Z][a-zA-Z0-9]{5,19}$/;
	
	//��֤�û������Ƿ��Ƿ��Ϲ���
	if( !reg.test(name) ){
		alert("�û���ֻ����6-20λ������ĸ��ͷ�����ֺ���ĸ�����");
		return false;
	}
	return true;
}

//�����������д�ǲ��Ƿ��Ϲ淶
function confirmEmail(){
	var email = document.getElementById("email").value;
	var reg = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
	
	if( !reg.test(email) ){
		alert("������֤�������������룡");
		return false;
	}
	return true;
}

//�����ֻ������ʽ�Ƿ���ȷ
function confirmPhone(){
	var phone = document.getElementById("phone").value;
	var reg = /^1\d{10}$/;
	
	if( !reg.test(phone) ){
		alert("�ֻ�����֤����ȷ��");
		return false;
	}
	return true;
}
