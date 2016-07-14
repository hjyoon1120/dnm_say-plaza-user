<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
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
	
	.pagination {
	  width: 100%;
	}
	
	.pagination li{
	  list-style: none;
	  float: left; 
	  padding: 3px; 
	  border: 1px solid blue;
	  margin:3px;  
	}
	
	.pagination li a{
	  margin: 3px;
	  text-decoration: none;  
	}
</style>
</head>
<body>

	<h2>Ajax Test Page</h2>
	<div id="displayDiv">
	
	</div>
	
	<div>
		<div>
			Replyer <Input type='text' name='replyer' id='newReplyWriter'>
		</div>
		<div>
			Reply Text <input type='text' name='replytext' id='newReplyText'>
		</div>
		<button id='replyAddBtn'>Add Reply</button>
	</div>
	
	<div id='modDiv' style="display:none;">
		<div class='modal-title'></div>
		<div>
			<input type='text' id='replytext'>
		</div>
		<div>
			<button type="button" id='replyModBtn'>Modify</button>
			<button type="button" id='replyDelBtn'>Delete</button>
			<button type="button" id='closeBtn'>Close</button>
		</div>
	</div>
	
	<ul id="replies"></ul>
	
	<ul class='pagination'></ul>
	
	<script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.5/handlebars.js"></script>
	
	<script id="template" type="text/x-handlebars-template">
		{{#each .}}
		<li class="replyLi" data-rno={{rno}}>
			rno:<div>{{rno}}</div>
			writer:<div>{{replyer}}</div>
			text:<div class="replytext">{{replytext}}</div>
			date:<div>{{prettifyDate regdate}}</div>
			<button>Mod</button>
		</li>
		{{/each}}
	</script>
	
	<script>
		
		Handlebars.registerHelper("prettifyDate", function(timeValue){
			var dateObj = new Date(timeValue);
			var year = dateObj.getFullYear();
			var month = dateObj.getMonth() + 1;
			var date = dateObj.getDate();
			return year + "/" + month + "/" + date;
		});
		
		var printData = function(replyArr, target, templateObject){
			var template = Handlebars.compile(templateObject.html());
			
			var html = template(replyArr);
			
			$(".replyLi").remove();
			target.html(html);
			
		}
		
		var bno = 998;
		
		var replyPage = 1;
		
		function getPage(pageInfo){
			
			$.getJSON(pageInfo, function(data){
				printData(data.list, $("#displayDiv"), $('#template'));
				printPaging(data.pageMaker, $(".pagination"));
			});
		}
		
		var printPaging = function(pageMaker, target){
			
			var str = "";

			if (pageMaker.prev) {
				str += "<li><a href='" + (pageMaker.startPage - 1)
						+ "'> &laquo; </a></li>";
			}

			for (var i = pageMaker.startPage, len = pageMaker.endPage; i <= len; i++) {
				var strClass = pageMaker.cri.page == i ? 'class=active' : '';
				str += "<li "+ strClass + "><a href='" + i + "'>" + i + "</a></li>";
			}

			if (pageMaker.next) {
				str += "<li><a href='" + (pageMakeer.endPage + 1)
						+ "'> &raquo; </a></li>";
			}
			$('.pagination').html(str);
		}
		
		getPage("/replies/" + bno + "/1");
		
		$(".pagination").on("click", "li a", function(event) {
			event.preventDefault();
			
			replyPage = $(this).attr("href");
			getPage("/replies/" + bno + "/" + replyPage);
			console.log(replyPage);
			console.log("/replies/" + bno + "/" + replyPage);
		})
		
		$("#replyAddBtn").on("click", function(){
			
			var replyerObj = $("#newReplyWriter");
			var replytextObj = $("#newReplyText");
			var replyer = replyerObj.val();
			var replytext = replytextObj.val();
			
			$.ajax({
				type:'post',
				url:'/replies/',
				headers: {
					"Content-Type":"application/json",
					"X-HTTP-Method-Override": "POST"
				},
				dataType:'text',
				data: JSON.stringify({bno:bno, replyer:replyer, replytext:replytext}),
				success:function(result){
					console.log("result: " + result);
					if(result == 'SUCCESS'){
						alert("Add Success!!");
						replyPage = 1;
						getPage("/replies/" + bno + "/" + replyPage);
						replyerObj.val("");
						replytextObj.val("");
					}
				}
			});
		});
		
		$("#displayDiv").on("click", ".replyLi button", function(event){
			
			var reply = $(this).parent();
			var rno = reply.attr("data-rno");
			var replytext = reply.text();
			
			
			console.log(reply);
			//$("#replytext").val(reply.find('.replytext').text());
			$(".modal-title").html(rno);
			$("#replytext").val(replytext);
			
			$("#modDiv").show("slow");
		
		});
		
		$("#replyModBtn").on("click", function(){
			
			var rno = $(".modal-title").html();
			var replytext = $("#replytext").val();
			
			$.ajax({
				type:'put',
				url:'/replies/'+rno,
				headers: { 
				      "Content-Type": "application/json",
				      "X-HTTP-Method-Override": "PUT" },
				data:JSON.stringify({replytext:replytext}), 
				dataType:'text', 
				success:function(result){
					console.log("result: " + result);
					if(result == 'SUCCESS'){
						alert("Modify Success!!");
						 $("#modDiv").hide("slow");
						 getPage("/replies/" + bno + "/" + replyPage);
					}
			}});
		});
		
		$("#replyDelBtn").on("click", function(){
			
			var rno = $(".modal-title").html();
			var replytext = $("#replytext").val();
			
			$.ajax({
				type : 'delete',
				url : '/replies/' + rno,
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "DELETE"
				},
				dataType : 'text',
				success : function(result) {
					console.log("result: " + result);
					if (result == 'SUCCESS') {
						alert("Delete Success!!.");
						$("#modDiv").hide("slow");
						getPage("/replies/" + bno + "/" + replyPage);
					}
				}
			});
		});
		
		$("#closeBtn").on("click", function(){
			
			$("#modDiv").hide("slow");
		});
		
	</script>
	
</body>
</html>