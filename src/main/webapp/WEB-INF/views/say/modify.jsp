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
    .popup {position: absolute;}
    .back { background-color: gray; opacity:0.5; width: 100%; height: 300%; overflow:hidden;  z-index:1101;}
    .front { 
       z-index:1110; opacity:1; boarder:1px; margin: auto; 
      }
     .show{
       position:relative;
       max-width: 1200px; 
       max-height: 800px; 
       overflow: auto;       
     } 
</style>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-md-10">
				<!-- general form elements -->
				<div class="box box-primary">
					<!-- /.box-header -->
					<form role="form" action="modify" method="post">
						<input type='hidden' name='id' value="${sayVO.id}">
						<input type='hidden' name='page' value="${cri.page}">
						<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
						<input type='hidden' name='keyword' value="${cri.keyword}">
						
					
						<div class='box-header with-border'>
							<div class='user-block'>
								<input type="text" name='user_id' class="form-control"
									value='${sayVO.user_id}' readonly>
							</div>
							<!-- /.user-block -->
						</div>
						<!-- /.box-header -->
						<div class="box-body">
							<div class="form-group">
								<textarea class="form-control" name="body" rows="5"
									placeholder="What's on your mind?">${sayVO.body}</textarea>
							</div>
							
							<div class="form-group">
								<label for="exampleInputEmail1">File Drop Here</label>
								<div class="fileDrop"></div>
							</div>
						</div>
						<!-- /.box-body -->

						<div class="box-footer">
							<div>
								<hr>
							</div>

							<ul class="mailbox-attachments clearfix uploadedList"></ul>
							<button type="submit" class="btn btn-primary">Submit</button>
							<button type="submit" class="btn btn-warning">Cancel</button>
						</div>
						<!-- /.box-footer -->
					</form>

				</div>
				<!-- /.box -->
			</div>
			<!-- /.col -->

		</div>
		<!-- /.row -->
		
		<div class='popup back' style="display:none;"></div>
		<div id="popup_front" class='popup front' style="display:none;">
			<img id="popup_img">
		</div>

	</section>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<script id="template" type="text/x-handlebars-template">
	<li>
		<span class="mailbox-attachment-icon has-img"><img src="{{imgsrc}}" alt="Attachment"></span>
		<div class="mailbox-attachment-info">
			<a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a>
			<a href="{{img_src}}" class="btn btn-default btn-xs pull-right delbtn"><i class="fa fa-fw fa-remove"></i></a>
		</div>
	</li>
</script>

<script>
$(document).ready(function() {
	
	var formObj = $("form[role='form']");
	
	formObj.submit(function(event){
		event.preventDefault();
		
		var that = $(this);
		
		var str="";
		$(".uploadedList .delbtn").each(function(index){
			str += "<input type='hidden' name='files[" + index + "]' value='"
			+ $(this).attr("href") + "'> ";
		});
		
		that.append(str);
		
		console.log(str);
		
		that.get(0).submit();
	});

	$(".btn-warning").on("click", function() {
		
		self.location = "/say/list?page=${cri.page}$perPageNum=${cri.perPageNum}&keyword=${cri.keyword}";
		
	});
	
/* 		$(".btn-primary").on("click", function() {
		
		formObj.submit();
	}); */

});

var template = Handlebars.compile($("template").html());

$(".fileDrop").on("dragenter dragover", function(event){
	event.preventDefault();
});

$(".fileDrop").on("drop", function(event){
	event.preventDefault();
	
	var files = event.originalEvent.dataTransfer.files;
	
	var file = files[0];
	
	var formData = new FormData();
	
	formData.append("file", file);
	
	$.ajax({
		url: '/uploadAjax',
		data: formData,
		dataType: 'text',
		processData: false,
		contentType: false,
		type:'POST',
		success: function(data){
			
			var fileInfo = getFileInfo(data);
			var html = template(fileInfo);
			
			$(".uploadedList").append(html);
		}
	});
});

$(".uploadedList").on("click", ".delbtn", function(event){
	event.preventDefault();
	
	var that = $(this);
	
	$.ajax({
		url: '/deleteFile',
		type:'POST',
		data: {fileName:$(this).attr("href")},
		dataType: 'text',
		success:function(result){
			if(result == 'deleted'){
				that.closest("li").remove();
			}
		}
	});
});

var sno = ${sayVO.id};
var template = Handlebars.compile($("#template").html());

$.getJSON("/say/getAttach/" + sno, function(list){
	$(list).each(function(){
		
		var fileInfo = getFileInfo(this);
		var html = template(fileInfo);
		
		$(".uploadedList").append(html);
	});
});

$(".uploadedList").on("click", ".mailbox-attachment-info a", function(event){
	
	var fileLink = $(this).attr("href");
	
	if(checkImageType(fileLink)){
		event.preventDefault();
		
		var imgTag = $("#popup_img");
		imgTag.attr("src", fileLink);
		
		console.log(imgTag.attr("src"));
		
		$(".popup").show('slow');
		imgTag.addClass("show");
	}
});

$("#popup_img").on("click", function(){
	$(".popup").hide('slow');
});
</script>

<%@ include file="../include/footer.jsp"%>