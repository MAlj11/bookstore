//��֤�û����������֤��
function validate(){
	var nm = document.getElementsByName("name")[0];
	if(nm.value.trim()==""){
		alert("������������");
		nm.focus();
		return false;
	}
	var pwd = document.getElementsByName("password")[0];
	if(pwd.value.trim()==""){
		alert("�����������");
		pwd.focus();
		return false;
	}
	var code = document.getElementsByName("sCode")[0];
	if(code.value.trim()==""){
		alert("��֤���������");
		code.focus();
		return false;
	}
	return true;
}
