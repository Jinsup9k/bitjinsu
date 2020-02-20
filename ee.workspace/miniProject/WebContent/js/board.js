$('#boardFormBtn').click(
		function() {
			$('#subjectDiv').empty();
			$('#contentDiv').empty();

			if ($('#subject').val() == '') {
				$('#subjectDiv').text('제목을 입력하세요').css('color', 'red').css(
						'font-size', '8pt').css('font-weight', 'bold');
			} else if ($('#content').val() == '') {
				$('#contentDiv').text('내용을 입력하세요').css('color', 'red').css(
						'font-size', '8pt').css('font-weight', 'bold');
			} else
				document.forms[0].submit();
		});

function checkAll(){
	let check = document.getElementsByName("check");
	if(document.getElementById("checkAll").checked){
		for(i=0; i<check.length; i++){
			check[i].checked = true;
		}
	}else{
		for(i=0; i<check.length.length; i++){
			check[i].checked = false;
		}
	}
	
}

function deleteCheck(){
	let check = document.getElementsByName("check");
	let count=0;
	for(i=0; i<check.length;i++){
		if(check[i].checked) count++;
	}
	
	if(count == 0){
		alert("항목을 선택하세요")
	}else{
		confirm("정말로 삭제 하겠습니까?");
	}
}




	