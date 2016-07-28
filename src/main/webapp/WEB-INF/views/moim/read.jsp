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
	<input type='hidden' name='id' value="${sayVO.id}">
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
							<span class='username'><a href="personelSay.html">${sayVO.nickname}</a></span>
							<span class='description'>[${sayVO.latitude},
								${sayVO.longitude}] - <fmt:formatDate pattern="yyyy-MM-dd HH:mm"
									value="${sayVO.created_at}" />
							</span>
						</div>
						<!-- /.user-block -->
						<div class='box-tools'>

							<button class='btn btn-box-tool' type="submit" id='goListBtn'>
								<i class='fa fa-chevron-left'></i>
							</button>
							<c:if test="${login.id == sayVO.user_id}">
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
						<p>${sayVO.body}</p>
						
						<div class="mailbox-attachments clearfix uploadedList"></div>
						
						<button class='btn btn-default btn-xs'>
							<i class='fa fa-share'></i> Share
						</button>
						<button class='btn btn-default btn-xs'>
							<i class='fa fa-thumbs-o-up'></i> Like
						</button>
						<span class='pull-right text-muted'>${sayVO.cnt_like} likes
							- <small id='replycnt'>${sayVO.cnt_comment}</small> comments</span>
					</div>
					<!-- /.box-body-->

					<div class="box-footer">
						
						<c:if test="${not empty login}">
							<img class="img-responsive img-circle img-sm"
								src="/resources/dist/img/user4-128x128.jpg" alt="alt text">
							<div class="img-push">
								<input type='hidden' id="newReplyId" value="${login.id}" readonly/>
								<input type='hidden' id="newReplyWriter" name="nickname"
									value="${login.nickname}" readonly> <input type="text"
									class="form-control input-sm" id="newReplyText"
									placeholder="Press enter to post comment">
							</div>
							<div class="box-footer">
								<button type="button" class="btn btn-xs btn-primary pull-right"
									id="replyAddBtn">ADD</button>
							</div>
						</c:if>

						<c:if test="${empty login}">

						</c:if>
						

					</div>
					<!-- /.box-footer -->
					<div class='box-footer box-comments' id="timeline">

						<div class='text-center'>
							<ul id="pagination" class="pagination pagination-sm no-margin ">

							</ul>
						</div>
					</div>

				</div>
				<!-- /.box -->
			</div>
		</div>
		<!-- /.row -->

		<!-- Modal -->
		<div id="modifyModal" class="modal modal-primary fade" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title"></h4>
					</div>
					<div class="modal-body" data-rno>
						<p>
							<input type="text" id="replytext" class="form-control">
						</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-info" id="replyModBtn">Modify</button>
						<button type="button" class="btn btn-danger" id="replyDelBtn">Delete</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- /.content -->

</div>
<!-- /.content-wrapper -->


<script id="template" type="text/x-handlebars-template">
{{#each .}}

<div class='box-comment' data-rno={{id}}>
<!-- User image -->
<img class='img-circle img-sm'
	src='/resources/dist/img/user3-128x128.jpg' alt='user image'>
{{#eqReplyer user_id}}
<a class="btn btn-primary btn-xs pull-right" data-toggle="modal" data-target="#modifyModal">Modify</a>
{{/eqReplyer}}
<div class='comment-text'>
	<span class="username"> {{nickname}} 
		<span class='text-muted pull-right'>{{prettifyDate created_at}}</span>
	</span>
	<!-- /.username -->
</div>
<div class='comment-text' id="replybody">{{body}}</div>
<!-- /.comment-text -->
</div>
{{/each}}
</script>
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
	console.log(Handlebars.compile);
	console.dir(Handlebars);

	Handlebars.registerHelper("eqReplyer", function(user_id, block) {
		var accum = '';
		if (user_id == '${login.id}') {
			accum += block.fn();
		}
		return accum;
	});

	Handlebars.registerHelper("prettifyDate", function(timeValue) {
		var dateObj = new Date(timeValue);
		var year = dateObj.getFullYear();
		var month = dateObj.getMonth() + 1;
		var date = dateObj.getDate();
		return year + "/" + month + "/" + date;
	});

	var printData = function(replyArr, target, templateObject) {

		var template = Handlebars.compile(templateObject.html());

		var html = template(replyArr);
		$(".box-comment").remove();
		target.prepend(html);
	}

	var sno = ${sayVO.id};

	var replyPage = 1;

	function getPage(pageInfo) {

		$.getJSON(pageInfo, function(data) {
			printData(data.list, $("#timeline"), $('#template'));
			printPaging(data.pageMaker, $(".pagination"));

			$("#modifyModal").modal('hide');
			$("#replycntSmall").html("[ " + data.pageMaker.totalCnt + " ]");

		});
	}

	var printPaging = function(pageMaker, target) {

		var str = "";

		if (pageMaker.prev) {
			str += "<li><a href='" + (pageMaker.startPage - 1)
					+ "'> << </a></li>";
		}

		for (var i = pageMaker.startPage, len = pageMaker.endPage; i <= len; i++) {
			var strClass = pageMaker.cri.page == i ? 'class=active' : '';
			str += "<li "+strClass+"><a href='"+i+"'>" + i + "</a></li>";
		}

		if (pageMaker.next) {
			str += "<li><a href='" + (pageMaker.endPage + 1)
					+ "'> >> </a></li>";
		}

		target.html(str);
	};

	getPage("/s_replies/" + sno + "/1");

	$(".pagination").on("click", "li a", function(event) {

		event.preventDefault();

		replyPage = $(this).attr("href");

		getPage("/s_replies/" + sno + "/" + replyPage);

	});

	$("#replyAddBtn").on("click", function() {
		var idObj = $("#newReplyId");
		var replyerObj = $("#newReplyWriter");
		var replytextObj = $("#newReplyText");
		var id = idObj.val();
		var replyer = replyerObj.val();
		var replytext = replytextObj.val();
		
		console.log(id);
		$.ajax({
			type : 'post',
			url : '/s_replies/',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType : 'text',
			data : JSON.stringify({
				say_id : sno,
				user_id : id,
				nickname : replyer,
				body : replytext
			}),
			success : function(result) {
				console.log("result: " + result);
				if (result == 'SUCCESS') {
					alert("Add Reply Success!");
					replyPage = 1;
					getPage("/s_replies/" + sno + "/" + replyPage);
					replyerObj.val();
					replytextObj.val("");
				}
			}
		});
	});

	$("#timeline").on("click", ".box-comment", function(event) {

		var reply = $(this);

		$("#replytext").val(reply.find('#replybody').text());
		$(".modal-title").html(reply.attr("data-rno"));

	});

	$("#replyModBtn").on("click", function() {

		var rno = $(".modal-title").html();
		var replytext = $("#replytext").val();

		$.ajax({
			type : 'put',
			url : '/s_replies/' + rno,
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "PUT"
			},
			data : JSON.stringify({
				body : replytext
			}),
			dataType : 'text',
			success : function(result) {
				console.log("result: " + result);
				if (result == 'SUCCESS') {
					alert("Modify Success");
					getPage("/s_replies/" + sno + "/" + replyPage);
				}
			}
		});
	});

	$("#replyDelBtn").on("click", function() {

		var rno = $(".modal-title").html();
		var replytext = $("#replytext").val();

		$.ajax({
			type : 'delete',
			url : '/s_replies/' + rno,
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "DELETE"
			},
			dataType : 'text',
			success : function(result) {
				console.log("result: " + result);
				if (result == 'SUCCESS') {
					alert("Remove Success");
					getPage("/s_replies/" + sno + "/" + replyPage);
				}
			}
		});
	});
</script>
<script>
	$(document).ready(function() {
		
		var formObj = $("form[role='form']");

		console.log(formObj);

		$("#modifyBtn").on("click", function() {
			formObj.attr("action", "/say/modify");
			formObj.attr("method", "get");
			formObj.submit();
		});

		$("#removeBtn").on("click", function() {

			var replyCnt = $("#replycnt").html();
			
			console.log(replyCnt);
			
			if (replyCnt > 0) {
				alert("댓글이 달린 게시물을 삭제할 수 없습니다.");
				return;
			}

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

			formObj.attr("action", "/say/remove");
			formObj.submit();
		});

		$("#goListBtn").on("click", function() {
			formObj.attr("method", "get");
			formObj.attr("action", "/say/list");
			formObj.submit();
		});

		var sno = ${sayVO.id};

		var template = Handlebars.compile($("#templateAttach").html());

		$.getJSON("/say/getAttach/" + sno, function(list) {
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