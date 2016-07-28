<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>

<style>
.fileDrop {
	width: 80%;
	height: 100px;
	border: 1px dotted gray;
	background-color: lightslategrey;
	margin: auto;
}
</style>
<div class="content-wrapper">
	<!-- Main content -->
	<section class="content">
		<body class="hold-transition register-page">
			<div class="register-box">
				<div class="register-box-body">
					<p class="login-box-msg">Register a new membership</p>

					<form role="form" method="post">

						<div class="form-group has-feedback">
							<input type="email" class="form-control" placeholder="EMAIL"
								name="email"> <span
								class="glyphicon glyphicon-envelope form-control-feedback"></span>
						</div>

						<div class="form-group has-feedback">
							<input type="password" class="form-control"
								placeholder="Password" name="pw"> <span
								class="glyphicon glyphicon-lock form-control-feedback"></span>
						</div>

						<div class="form-group has-feedback">
							<input type="password" class="form-control"
								placeholder="Retype password"> <span
								class="glyphicon glyphicon-log-in form-control-feedback"></span>
						</div>

						<div class="form-group has-feedback">
							<input type="text" class="form-control" placeholder="NICKNAME"
								name="nickname"> <span
								class="glyphicon glyphicon-user form-control-feedback"></span>
						</div>

						<div class="form-group has-feedback">
							<input type="text" class="form-control" placeholder="EX)서울특별시"
								name="town1"> <span
								class="glyphicon glyphicon-user form-control-feedback"></span> <input
								type="text" class="form-control" placeholder="EX)마포구"
								name="town2"> <span
								class="glyphicon glyphicon-user form-control-feedback"></span> <input
								type="text" class="form-control" placeholder="EX)합정동"
								name="town3"> <span
								class="glyphicon glyphicon-user form-control-feedback"></span> <input
								type="text" class="form-control" placeholder="EX)..."
								name="town4"> <span
								class="glyphicon glyphicon-user form-control-feedback"></span> <input
								type="text" class="form-control" placeholder="EX)..."
								name="town5"> <span
								class="glyphicon glyphicon-user form-control-feedback"></span>
						</div>

						<div>
							<label for="select">성별</label> <select name="sex">
								<option value="male">Male</option>
								<option value="female">Female</option>
							</select>
						</div>

						<div class="form-group">
							<label for="exampleInputEmail1">File Drop Here</label>
							<div class="fileDrop"></div>
						</div>

						<ul class="mailbox-attachments clearfix uploadedList"></ul>

						<div class="row">
							<div class="col-xs-8">
								<div class="checkbox icheck">
									<label> <input type="checkbox"> I agree to the
										<a href="#">terms</a>
									</label>
								</div>
							</div>
							<!-- /.col -->
							<div class="col-xs-4">
								<button type="submit" class="btn btn-primary btn-block btn-flat">Register</button>
							</div>
							<!-- /.col -->
						</div>
					</form>

					<!-- <div class="social-auth-links text-center">
          <p>- OR -</p>
          <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign up using Facebook</a>
          <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Sign up using Google+</a>
        </div> -->

					<!--   <a href="login.html" class="text-center">I already have a membership</a> -->
				</div>
				<!-- /.form-box -->
			</div>
			<!-- /.register-box -->
		</body>
	</section>
</div>

<script id="template" type="text/x-handlebars-template">
<li>
	<span class="mailbox-attachment-icon has-img"><img src="{{imgsrc}}" alt="Attachment"></span>
	<div class="mailbox-attachment-info">
		<a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a>
		<a href="{{img_src}}"
			class="btn btn-default btn-xn pull-right delbtn"><i class="fa fa-fw fa-remove"></i></a>
	</div>
</li>
</script>

<script>
	var template = Handlebars.compile($("#template").html());
	
	$(".fileDrop").on("dragenter dragover", function(event){
		event.preventDefault();
	});
	
	$(".fileDrop").on("drop", function(event){
		event.preventDefault();
		
		var files = event.originalEvent.dataTransfer.files;
		console.log(files);
		var file = files[0];
		console.log(file);
		var formData = new FormData();
		console.log(formData);
		formData.append("file", file);
		
		$.ajax({
			url:'/uploadAjax',
			data: formData,
			dataType: 'text',
			processData : false,
			contentType : false,
			type: 'POST',
			success: function(data){
				var fileInfo = getFileInfo(data);
				var html = template(fileInfo);
				
				$(".uploadedList").append(html);
			}
		});
		
	});

	$("#registerForm").submit(function(event) {
		
		event.preventDefault();
		
		var that = $(this);
		
		var str = "";
		
		$(".uploadedList .delbtn").each(function(index) {
			
			str += "<input type='hidden' name='files[" + index
					+ "]' value='" + $(this).attr("href") + "'> ";
		});
		
		that.append(str);
		that.get(0).submit();
		
	});
	
	$(".uploadedList").on("click", ".delbtn", function(event){
		event.preventDefault();
		
		var that = $(this);
		
		$.ajax({
			url:"/deleteFile",
			type:"POST",
			data:{fileName:$(this).attr("href")},
			dataType:"text",
			success:function(result){
				if(result == 'deleted'){
					that.closest("li").remove();
				}
			}
		});
	});
</script>


<%@ include file="../include/footer.jsp"%>
