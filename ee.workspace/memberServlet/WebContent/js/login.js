function checkLoginForm() {
	if (document.loginForm.id.value == "")
		alert("아이디를 입력하세요")
	else if (document.loginForm.pwd.value == "")
		alert("비밀번호를 입력하세요")
	else
		document.loginForm.submit();
}