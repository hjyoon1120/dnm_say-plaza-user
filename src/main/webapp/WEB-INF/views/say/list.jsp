<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../include/header.jsp"%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Main content -->
	<section class="content">
		<!-- Premium row -->

		<div class="row">

			<div class="col-md-10">
				<input type="text" name='keyword' id="keywordInput"
					value="${cri.keyword}">
				<button id='searchBtn'>Search</button>
				<button id='newBtn'>New Board</button>

				<c:forEach items="${list}" var="sayVO">
					<div class="box box-widget">
						<div class='box-header with-border'>
							<div class='user-block'>
								<img class='img-circle'
									src='/resources/dist/img/user1-128x128.jpg' alt='user image'>
								<span class='username'><a href="personelSay.html">${sayVO.user_id}</a></span>
								<span class='description'>[${sayVO.latitude},
									${sayVO.longitude}] - <fmt:formatDate
										pattern="yyyy-MM-dd HH:mm" value="${sayVO.created_at}" />
								</span>
							</div>
							<!-- /.user-block -->
							<div class='box-tools'>
								<button class='btn btn-box-tool' data-toggle='tooltip'
									title='Mark as read'>
									<i class='fa fa-circle-o'></i>
								</button>
								<button class='btn btn-box-tool' data-widget='collapse'>
									<i class='fa fa-minus'></i>
								</button>
								<button class='btn btn-box-tool' data-widget='remove'>
									<i class='fa fa-times'></i>
								</button>
							</div>
							<!-- /.box-tools -->
						</div>
						<!-- /.box-header -->
						<a href="/say/read${pageMaker.makeSearch(pageMaker.cri.page)}&id=${sayVO.id}">
						<div class="box box-body">
							<p>${sayVO.body}</p>
							<img class="img-responsive pad"
								src="/resources/dist/img/photo2.png" alt="Photo">
							<button class='btn btn-default btn-xs'>
								<i class='fa fa-share'></i> Share
							</button>
							<button class='btn btn-default btn-xs'>
								<i class='fa fa-thumbs-o-up'></i> Like
							</button>
							<span class='pull-right text-muted'>${sayVO.cnt_like} likes - ${sayVO.cnt_comment} comments</span>
						</div>
						<!-- /.box-body-->
						</a>
						<div class='box-footer box-comments'>
							<!-- <div class='box-comment'>
							User image
							<img class='img-circle img-sm'
								src='/resources/dist/img/user3-128x128.jpg' alt='user image'>
							<div class='comment-text'>
								<span class="username"> Maria Gonzales <span
									class='text-muted pull-right'>8:03 PM Today</span>
								</span>
								/.username
								It is a long established fact that a reader will be distracted
								by the readable content of a page when looking at its layout.
							</div>
							/.comment-text
						</div>
						/.box-comment -->
						</div>
						<!-- /.box-footer -->
						<div class="box-footer">
							<!-- <form action="#" method="post">
							<img class="img-responsive img-circle img-sm"
								src="/resources/dist/img/user4-128x128.jpg" alt="alt text">
							.img-push is used to add margin to elements next to floating images
							<div class="img-push">
								<input type="text" class="form-control input-sm"
									placeholder="Press enter to post comment">
							</div>
						</form> -->
						</div>
						<!-- /.box-footer -->
					</div>
					<!-- /.box -->
				</c:forEach>


			</div>

		</div>
		<!-- /.row -->

		<div class="text-center">
			<ul class="pagination">
				<c:if test="${pageMaker.prev}">
					<li><a
						href="list${pageMaker.makeSearch(pageMaker.startPage-1)}">
							&laquo;</a></li>
				</c:if>

				<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}"
					var="idx">
					<li
						<c:out value="${pageMaker.cri.page == idx ? 'class = active ' : ''}"/>>
						<a href="list${pageMaker.makeSearch(idx)}">${idx}</a>
					</li>
				</c:forEach>

				<c:if test="${pageMaker.next && pageMaker.endPage >0}">
					<li><a
						href="list${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
				</c:if>
			</ul>
			<!-- /.pagination -->
		</div>
		<!-- /.text-center -->

	</section>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<script>
	var result = '${msg}';

	if (result == 'reg') {
		alert("Register Success!!")
	} else if (result == 'del') {
		alert("Remove Success!!")
	} else if (result == 'mod') {
		alert("Modify Success!!")
	}
</script>

<script>
	$(document).ready(function() {
		
		$('#searchBtn').on("click", function(event) {
			
			self.location = "list" + '${pageMaker.makeQuery(1)}'
			+ "&keyword=" + $('#keywordInput').val();
			});
		
		$('#newBtn').on("click", function(event) {
			
			self.location = "register";
			
			});
		})
		
		
</script>

<%@ include file="../include/footer.jsp"%>