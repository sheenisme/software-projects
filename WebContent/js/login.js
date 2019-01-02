function checkusername(username){
	var Expression1=/^[a-zA-Z0-9_]{3,10}$/;     //3-10个 字母数字下划线 组成
	var objExp1=new RegExp(Expression1);
	//alert(username.value);
	//alert(objExp1);
	if(objExp1.test(username.value) == true){
		return true;
	}else{
		return false;
	}
}
	
function checkpassword(password){
	var Expression2=/^[A-Za-z]{1}([A-Za-z0-9]|[._]){5,19}$/; //6-20位字母数字下划线和点“.”组成
	var objExp2=new RegExp(Expression2);
	if(objExp2.test(password)==true){
		return true;
	}else{
		return false;
	}
}

function checkemail(){
	var email=document.getElementById("email");
	var Expression3=/^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
	var Reg3=new RegExp(Expression3);
	if(email==""){
		alert("请输入您的邮箱（用于找回密码）！");
		email.focus();
		return false;
	}else if(Reg3.test(email.value)==false){
		alert("您输入的邮箱格式有误！");
		return false;
	}else{
		return true;
	}
}

function checklogin(){
	var email=document.getElementById("email");
	var username=document.getElementById("username");
	var password=document.getElementById("password");
	//alert("开始检查");
	if(username.value==""){
		alert("请输入您的账号!");
		username.focus();
		return false;
	}
	if(!checkusername(username)){
		alert("您输入的账号不正确！-login.jsp");
		username.focus();
		return false;
	}
	if(password.value==""){
		alert("请输入密码！");
		password.focus();
		return false;
	}
	if(email==""){
		alert("请输入您的邮箱（用于找回密码）！");
		email.focus();
		return false;
	}
	if(!checkemail(eamil)){
		alert("您输入的邮箱格式有误！");
		email.focus();
		return false;
	}
	//alert("检查完成");
	//var userform=document.getElementByName("userform");
	//userform.submit();\
	return ture;
}