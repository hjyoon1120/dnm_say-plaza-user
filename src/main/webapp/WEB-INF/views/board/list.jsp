<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<%@ include file="../include/header.jsp"%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Main content -->
	<section class="content">

		<div class="row">
			<!-- left column -->
			<div class="col-md-12">
				<!-- general form elements -->

				<div class="box">
					<div class="box-header with-border">
						<h3 class="box-title">LIST ALL PAGE</h3>
						<button id='newBtn'>New Board</button>
					</div>
					<div class="box-body">

						<table class="table table-bordered">
							<tr>
								<th style="width: 10px">BNO</th>
								<th>TITLE</th>
								<th>WRITER</th>
								<th>REGDATE</th>
								<th style="width: 40px">VIEWCNT</th>
							</tr>


							<c:forEach items="${list}" var="boardVO">

								<tr>
									<td>${boardVO.bno}</td>
									<td><a
										href='/board/read${pageMaker.makeSearch(pageMaker.cri.page)}&bno=${boardVO.bno}'>${boardVO.title} <strong>[ ${boardVO.replycnt} ]</strong></a></td>
									<td>${boardVO.writer}</td>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
											value="${boardVO.regdate}" /></td>
									<td><span class="badge bg-red">${boardVO.viewcnt }</span></td>
								</tr>

							</c:forEach>

						</table>

					</div>
					<!-- /.box-body -->
					<div class="box-footer">
						<input type="text" name='keyword' id="keywordInput"
							value="${cri.keyword }">
						<button id='searchBtn'>Search</button>

						<div class="text-center">

							<ul class="pagination">

								<c:if test="${pageMaker.prev}">
									<li><a
										href="list${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
								</c:if>

								<c:forEach begin="${pageMaker.startPage }"
									end="${pageMaker.endPage }" var="idx">
									<li
										<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
										<a href="list${pageMaker.makeSearch(idx)}">${idx}</a>
									</li>
								</c:forEach>

								<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
									<li><a
										href="list${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
								</c:if>

							</ul>
						</div>

					</div>
					<!-- /.box-footer-->
				</div>
			</div>
			<!--/.col (left) -->
		</div>
		<!-- /.row -->

	</section>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<script>
	var result = '${msg}';

	if (result == 'reg') {
		alert("Registered Success!")
	} else if (result == 'del') {
		alert("Deleted Success!")
	} else if (result == 'mod') {
		alert("Modified Success!")
	}
</script>

<script>
	$(document).ready(function() {
/* 		$('#searchBtn').on("click", function(event){
			self.location = "list" + '${pageMaker.makeQuery(1)}' + "=" + $('#keywordInput').val();
		}); */
		
		$('#searchBtn').on("click", function(event){
			self.location = "list" + '${pageMaker.makeQuery(1)}' + "&keyword=" + $('#keywordInput').val();
		});
		
		$('#newBtn').on("click", function(event){
			self.location = "register";
		});
	})
</script>
<%@ include file="../include/footer.jsp"%>