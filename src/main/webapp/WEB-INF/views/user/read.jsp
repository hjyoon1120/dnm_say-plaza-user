<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../include/header.jsp"%>
<style>
    .popup {position: absolute;}
    .back { background-color: gray; opacity:0.5; width: 100%; height: 300%; overflow:auto;  z-index:1201;}
    .front { 
       z-index:1210; opacity:1; boarder:1px; margin: auto; overflow:auto; 
      }
    .show{
       position:relative;
       max-width: 1200px; 
       max-height: 800px; 
       overflow: auto;       
     } 
#modDiv {
	width: 300px;
	height: 100px;
	background-color: gray;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-top: -50px;
	margin-left: -150px;
	padding: 10px;
	z-index: 1000;
}
</style>
<form role="form" action="modify" method="post">
	<input type='hidden' name='id' value="${userVO.id}">
	<input type='hidden' name='page' value="${cri.page}">
	<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
	<input type='hidden' name='keyword' value="${cri.keyword}">
</form>
<div class='popup back' style="display: none;"></div>
<div id="popup_front" class='popup front' style="display: none;">
	<img id="popup_img">
</div>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Main content -->
	<section class="content">
		
		<div class="row">
			<div class="col-md-10">
				<div class="box box-widget">
					<div class='box-header with-border'>
						<div class='user-block'>
							<img class='img-circle'
								src='/resources/dist/img/user1-128x128.jpg' alt='user image'>
							<span class='username'><a href="personelSay.html">${userVO.nickname}</a></span>
							<span class='description'>${userVO.town1} ${userVO.town2} ${userVO.town3} ${userVO.town4} ${userVO.town5}
							</span>
						</div>
						<!-- /.user-block -->
						<div class='box-tools'>

							<button class='btn btn-box-tool' type="submit" id='goListBtn'>
								<i class='fa fa-chevron-left'></i>
							</button>
							<c:if test="${login.id == userVO.id}">
								<button class='btn btn-box-tool' type="submit" id='modifyBtn'>
									<i class='fa fa-wrench'></i>
								</button>
								<button class='btn btn-box-tool' type="submit" id='removeBtn'>
									<i class='fa fa-times'></i>
								</button>
							</c:if>
						</div>
						<!-- /.box-tools -->
					</div>
					<!-- /.box-header -->
					<div class="box box-body">
						<div class="form-group">
							<label for="exampleInputEmail1">JOB</label>
							<input type="text" name='job' class="form-control" value="${userVO.job}" readonly>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Birthday</label>
							<input type="text" name='dob' class="form-control" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm"
											value='${userVO.dob}'/>" readonly>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">GENDER</label>
							<input type="text" name='sex' class="form-control" value="${userVO.sex}" readonly>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">COMMENTS</label>
							<input type="text" name='text' class="form-control" value="${userVO.text}" readonly>
						</div>
						
						<button class='btn btn-default btn-xs'>
							<i class='fa fa-share'></i> Follow
						</button>
						<button class='btn btn-default btn-xs'>
							<i class='fa fa-thumbs-o-up'></i> Like
						</button>
						<span class='pull-right text-muted'>${userVO.cnt_following} Followings
							- ${userVO.cnt_follower} Followers</span>
						<span class='pull-right text-muted'>${userVO.cnt_today} Todays
							- ${userVO.cnt_total} Totals</span>
					</div>
					<!-- /.box-body-->

					<div class="box-footer">
						<div class="mailbox-attachments clearfix uploadedList"></div>
					</div>
					<!-- /.box-footer -->

				</div>
				<!-- /.box -->
			</div>
		</div>
		<!-- /.row -->
	</section>
	<!-- /.content -->

</div>
<!-- /.content-wrapper -->

<!-- class="mailbox-attachment-info" -->
<script id="templateAttach" type="text/x-handlebars-template">
	<li data-src = '{{img_src}}'>
		<div class="mailbox-attachment-info">
			<a href="{{getLink}}" class="mailbox-attachment-name">
				<span class="mailbox-attachment-icon has-img"><img src="{{getLink}}" alt="Attachment">
				</span>
			</a>
		</div>
	</li>
</script>
	
<script>
	$(document).ready(function() {
		
		var formObj = $("form[role='form']");

		console.log(formObj);

		$("#modifyBtn").on("click", function() {
			formObj.attr("action", "/user/modify");
			formObj.attr("method", "get");
			formObj.submit();
		});

		$("#removeBtn").on("click", function() {

			var arr = [];
			
			$(".uploadedList li").each(function(index) {
				arr.push($(this).attr("data-src"));
			});

			if (arr.length > 0) {
				$.post("/deleteAllFiles", {
					files : arr
				}, function() {

				});
			}

			formObj.attr("action", "/user/remove");
			formObj.submit();
		});

		$("#goListBtn").on("click", function() {
			formObj.attr("method", "get");
			formObj.attr("action", "/user/list");
			formObj.submit();
		});

		var id = ${userVO.id};

		var template = Handlebars.compile($("#templateAttach").html());

		$.getJSON("/user/getAttach/" + id, function(list) {
			$(list).each(function() {

				var fileInfo = getFileInfo(this);

				var html = template(fileInfo);

				$(".uploadedList").append(html);
			});
		});

		$(".uploadedList").on("click", ".mailbox-attachment-info a",
				function(event) {
					var fileLink = $(this).attr("href");

					if (checkImageType(fileLink)) {

						event.preventDefault();

						var imgTag = $("#popup_img");
						imgTag.attr("src", fileLink);

						console.log(imgTag.attr("src"));

						$(".popup").show('slow');
						imgTag.addClass("show");
					}
				});

		$("#popup_img").on("click", function() {
			$(".popup").hide('slow');
		});
	});
</script>

<%@ include file="../include/footer.jsp"%>