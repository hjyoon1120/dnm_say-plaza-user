<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
iframe {
	width: 0px;
	height: 0px;
	border: 0px
}
</style>
</head>
<body>


	<form id='form1' action="uploadForm" method="post"
		enctype="multipart/form-data" target="zeroFrame">
		<input type='file' name='file'> <input id="btn" type='submit'>
	</form>
	
	<div class="uploadedList"></div>
	<iframe name="zeroFrame"></iframe>
	
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script>
		function addFilePath(msg) {
			alert(msg);
			document.getElementById("form1").reset();
		}
		
		/* $("#btn").on("click", function(event){
			
			
			var files = event.originalEvent.dataTransfer.files;
			
			var file = files[0];
			
			console.log(file);
			
			var formData = new FormData();
			
			formData.append("file", file);
			
			$.ajax({
				url:'/uploadForm',
				data: formData,
				dataType:'text',
				processData: false,
				contentType: false,
				type: 'POST',
				success: function(data) {
					var str="";
					
					if(checkImageType(data)){
						
						str = "<div><img src='displayFile?fileName=" + data + "'/>" + data + "</div>";
						
					} else {
						
						str = "<div>" + data + "</div>";
					}
					
					$(".uploadedList").append(str);
				}
			});
		}) */
		
	</script>
	
</body>
</html>

