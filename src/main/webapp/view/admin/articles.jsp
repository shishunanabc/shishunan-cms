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
<title>Insert title here</title>
<%-- <link  href="<%=request.getContextPath() %>/css/index3.css"     rel="stylesheet"   type="text/css">
 --%><script type="text/javascript"  src="<%=request.getContextPath() %>/js/jquery-3.2.1.js"></script>
<link rel="stylesheet" type="text/css"href="/bootstrap-4.4.1-dist/css/bootstrap.min.css" />
<script type="text/javascript"src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script> 
<script type="text/javascript"  src="<%=request.getContextPath() %>/My97DatePicker/WdatePicker.js"></script> 
</head>
<body>
	<div class="form-group form-inline " >
		<form>
		 文章标题：
		 <input type="text" name="title" class="form-control form-control-sm" value="${article.title }"> &nbsp;&nbsp;
		审核状态：
		 <select name="status" class="form-control form-control-sm col-sm-2">
		  <option value="0" ${article.status=="0"?"selected":"" }>待审</option>
		  <option value="1" ${article.status=="1"?"selected":"" }>已审</option>
		  <option value="-1" ${article.status=="-1"?"selected":"" }>驳回</option>
		 </select>
		 &nbsp;&nbsp;
		 <button type="button" onclick="query()" class="btn btn-warning btn-sm">查询</button>
		</form>
	</div>
		 <hr>
	<table class="table table-bordered table-hover table-sm">
		<tr>
			<td>序号</td>
			<td>标题</td>
			<td>作者</td>
			<td>发布时间</td>
			<td>所属栏目</td>
			<td>所属分类</td>
			<td>是否热门</td>
			<td>点击量</td>
			<td>其他</td>
		</tr>
		<c:forEach items="${g}" var="article" varStatus="i">
			<tr>
				<td>${i.count }</td>
				<td width="350px">${article.title }</td>
				<td>${article.user.username }</td>
				<td><fmt:formatDate value="${article.created}" pattern="yyyy-MM-dd HH:mm:ss"/>
				${article.created }
				</td>
				<td>${article.channel.name }</td>
				<td>${article.category.name }</td>
				<td>
				  <c:if test="${article.hot==0}">
				   <button type="button" class="btn btn-info btn-sm" onclick="upda(${article.id})">否</button>
				  </c:if>
				 <c:if test="${article.hot==1}">
				   <button type="button" class="btn btn-danger btn-sm" onclick="upd(${article.id})">是</button>
				  </c:if>
				</td>
				<td>${article.hits }</td>
				<td>
					<div>
						<!-- Button trigger modal -->
						<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" onclick="cha(${article.id})">
		  					详情
						</button>
					</div>
				</td>
			</tr>
		</c:forEach>
     	
	</table>
	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel"><span id="title"></span></h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body" id="content">
	        
	      </div>
	      <div class="modal-footer">
	      <span id="msg"></span>
	      	<button type="button" class="btn btn-success" onclick="pass()">通过</button>
			<button type="button" class="btn btn-danger" onclick="pas()">驳回</button>
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
	      </div>
	    </div>
	  </div>
	</div>
	<jsp:include page="/view/common/pages.jsp"></jsp:include>
</body>
<script type="text/javascript">
	function goPage(page) {
		var forms=$("form").serialize();
		$("#center").load("/admin/articles?page="+page+"&article="+forms);
	}
	function query(){
		  var status=$("[name='status']").val();
		  var title=$("[name='title']").val();
		  $("#center").load("/admin/articles?status="+status+"&title="+title);
	  }
	function upda(id) {
		var page=${info.pageNum};
		alert(page);
		$.post(
			"/admin/upda",
			{id:id},
			function(as) {
				if (as>0) {
					alert("操作成功！");
					$("#center").load("/admin/articles?page="+page);
				}else {
					alert("操作失败！");
				}
			}
		)
	}
	function upd(id) {
		var page=${info.pageNum};
		alert(page);
		$.post(
			"/admin/upd",
			{id:id},
			function(as) {
				if (as>0) {
					alert("操作成功！");
					$("#center").load("/admin/articles?page="+page);
				}else {
					alert("操作失败！");
				}
			}
		)
	}
	var idd
	function cha(id) {
		idd=id;
		$.post(
			"/my/articlecha",
			{id:id},
			function (a) {
				$("#content").empty();
				$("#title").empty();
				$("#msg").empty();
				$("#title").append(a.title);
				$("#content").append(a.content);
			})
	}
	function pass(id) {
		$.post(
			"/admin/pass",
			{id:idd},
			function(as) {
				if (as>0) {
					$("#msg").append("操作成功！");
				}else {
					$("#msg").append("操作失败！");
				}
			}
		)
	}
	function pas(id) {
		$.post(
			"/admin/pas",
			{id:idd},
			function(as) {
				if (as>0) {
					$("#msg").append("驳回成功！");
				}else {
					$("#msg").append("驳回失败！");
				}
			}
		)
	}
</script>
</html>