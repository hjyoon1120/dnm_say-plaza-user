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

			<div class="col-md-12">
				<input type="text" name='keyword' id="keywordInput"
					value="${cri.keyword}">
				<button id='searchBtn'>Search</button>
				
				<div class="box box-danger">
					<div class="box-header with-border">
						<h3 class="box-title">People</h3>
					</div>
					
					<div class="box box-body">
						<c:forEach items="${list}" var="userVO">
							<a href="/user/read${pageMaker.makeSearch(pageMaker.cri.page)}&id=${userVO.id}">
							<div class="col-md-3 col-xs-12">
                                <!-- Widget: user widget style 1 -->
                                <div class="box box-widget widget-user" style="border:1px solid red">
                                    <!-- Add the bg color to the header using any of the bg-* classes -->
                                    <!-- <div class="widget-user-header bg-black" style="background: url('/resources/dist/img/photo1.png') center center;"> -->
                                    <div class="widget-user-header bg-black">
                                        <h3 class="widget-user-username">${userVO.nickname}</h3>
                                        <h5 class="widget-user-desc">${userVO.town1} - ${userVO.town2}</h5>
                                    </div>
                                    <div class="widget-user-image">
                                        <img class="img-circle" src="/resources/dist/img/user1-128x128.jpg" alt="User Avatar">
                                    </div>
                                    <div class="box-footer">
                                        <div class="row">
                                            <div class="col-sm-6 col-xs-6 border-right">
                                                <div class="description-block">
                                                    <h5 class="description-header">${userVO.cnt_following}</h5>
                                                    <span class="description-text">FOLLOWINGS</span>
                                                </div><!-- /.description-block -->
                                            </div><!-- /.col -->
                                            <div class="col-sm-6 col-xs-6">
                                                <div class="description-block">
                                                    <h5 class="description-header">${userVO.cnt_follower}</h5>
                                                    <span class="description-text">FOLLOWERS</span>
                                                </div><!-- /.description-block -->
                                            </div><!-- /.col -->
                                            <div class="col-sm-6 col-xs-6 border-right">
                                                <div class="description-block">
                                                    <h5 class="description-header">${userVO.cnt_today}</h5>
                                                    <span class="description-text">TODAY</span>
                                                </div><!-- /.description-block -->
                                            </div><!-- /.col -->
                                            <div class="col-sm-6 col-xs-6">
                                                <div class="description-block">
                                                    <h5 class="description-header">${userVO.cnt_total}</h5>
                                                    <span class="description-text">TOTAL</span>
                                                </div><!-- /.description-block -->
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div>
                                </div><!-- /.widget-user -->
                            </div><!-- /.col -->
                            </a>
						</c:forEach>
					</div>
				</div>
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

<script id="templateAttach" type="text/x-handlebars-template">
	<li data-src = '{{img_src}}'>
		<div class="mailbox-attachment-info">
			<a href="{{getLink}}" class="mailbox-attachment-name">
				<span class="mailbox-attachment-icon has-img"><img src="{{imgsrc}}" alt="Attachment">
				</span>
			</a>
		</div>
	</li>
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
		
		
	});
		
</script>

<%@ include file="../include/footer.jsp"%>