$('#boardFormBtn').click(function(){
	$('#subjectDiv').empty();
	$('#contentDiv').empty();
	
	if($('#subject').val()==''){
		$('#subjectDiv').text('제목을 입력하세요')
						.css('color','red')
						.css('font-size','8pt')
						.css('font-weight','bold');
	}else if('#content'.val()==''){
		$('#contentDiv').text('내용을 입력하세요')
						.css('color','red')
						.css('font-size','8pt')
						.css('font-weight','bold');	
	}else
		document.forms[0].submit();
});