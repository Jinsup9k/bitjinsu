function checkBoardWriteForm() {
	if (document.getElementById("subject").value == "") {
		alert("제목을 입력하세요.");
	} else if (document.getElementById("content").value == "") {
		alert("내용을 입력하세요.");
	} else
		document.getElementById("boardWriteForm").submit();
}
function isLogin(id, seq, pg) {
	if (id =='null') {
		alert("먼저 로그인하세요.");
	} else {
		location.href = "boardViewer.jsp?seq="+seq+"&pg="+pg;
	}

}