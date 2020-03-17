<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%String path=request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content=${g.keywords }>
<meta name="descrption" content=${g.original }>
<title>${g.title }</title>
<%-- <link  href="<%=request.getContextPath() %>/css/index3.css"     rel="stylesheet"   type="text/css">
 --%><script type="text/javascript"  src="<%=request.getContextPath() %>/js/jquery-3.2.1.js"></script>
<link rel="stylesheet" type="text/css"href="/bootstrap-4.4.1-dist/css/bootstrap.min.css" />
<script type="text/javascript"src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script> 
<script type="text/javascript"  src="<%=request.getContextPath() %>/My97DatePicker/WdatePicker.js"></script> 
</head>
<body>
	<!-- 文章详情页 -->
	<div class="container-fulid">
		<!-- head -->
		<div class="row">
			<div class="col-md-12"
				style="background-color: #222222; height: 34px">
				<font color="white" size="2px" style="margin-left: 10px">下载APP</font>
			</div>
			<div class="col-md-9">
				<div>
					<h1>标题：${g.title }</h1>
					<h6>作者：${g.user.username }</h6>
					<h6>来源：${g.original }</h6>
					${g.content }
					<hr>
					<div>
						<c:if test="${co==null }">
							<a href="javascript:show()">☆未收藏</a>
						</c:if>
						<c:if test="${co!=null }">
							<a href="javascript:deletes()">★取消收藏</a>
						</c:if>
					</div>
					<hr>
					<!-- 根据评论查询文章的排行 -->
					<c:if test="${sessionScope.user!=null }">
						<!-- 文章评论 -->
						<div>
							<h5>文章评论：</h5>
							<textarea rows="8" cols="20" style="width: 753px" name="content"></textarea>
			 				<button type="button" onclick="addComment()" class="btn btn-info">提交评论</button>
						</div>
					</c:if>
					
					<div>
						  <!-- 显示评论内容 -->
						  <c:forEach items="${list}" var="comment">
						   <h5> ${comment.user.username} ${comment.created}</h5>
						    
						    ${comment.content }
						  <hr>
						  </c:forEach>
					</div>
				</div>
			</div>
			
			<div class="col-md-3">
				<h6>评论排行榜</h6>
				<div class="card" style="width: 18rem">
					<c:forEach items="${ss }" var="ss" varStatus="i">
						<div class="card-body">
							<p class="card-text">${i.count }.${ss.title }</p>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		//发表评论  并跳转到方法中
		function addComment() {
			//获取文章id
			var articleId='${article.id}';
			//输入的文章内容获取
			var content=$("[name='content']").val();
			$.post("/comment/insert",{articleId:articleId,content:content},function(as){
				if(as>0){
					alert("评论成功");
					//刷新页面  window可省略
					window.location.reload();
				}else{
					alert("评论失败，需要登录后才能评论")
				}
			})
		}
		function show() {
			//获取文章标题
			var text='${g.title}';
			//获取收藏地址
			var url=location.href;
			//获取作者ID
			//var id='${g.user.id}';
			$.post(
				"/collect",
				{text:text,url:url},
				function(as) {
					if (as>0) {
						alert("收藏成功");
						location.reload();
					}else {
						alert("收藏失败，登录后才可以收藏")
					}
				}
			)
		}
		function deletes() {
			var id='${co.id}';
			$.post(
					"/deleteCollect",
					{id:id},
					function(as) {
						if (as>0) {
							alert("取消成功")
							location.reload();
						}else {
							alert("收藏失败，登录后才可以取消")
						}
					})
		}
		var id=${g.id}
		$.post(
				"/click",
				{id:id},
				function(img) {
					if (img>0) {
						
					}else {
						
					}
				})
	</script>
</body>
</html>