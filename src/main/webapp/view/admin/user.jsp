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
	<div class="form-group form-inline " style="margin-top: 5px">
		<form>
		 用户名称：
		 <input type="text" name="username" class="form-control form-control-sm" value="${us.username }"> &nbsp;&nbsp;
		审核状态：
		 <select name="locked" class="form-control form-control-sm col-sm-2">
		  <option value="0" ${us.locked=="0"?"selected":"" }>正常</option>
		  <option value="1" ${us.locked=="1"?"selected":"" }>禁用</option>
		 </select>
		 &nbsp;&nbsp;
		 <button type="button" onclick="query()" class="btn btn-warning btn-sm">查询</button>
		</form>
	</div>
		 <hr>
	<table class="table table-bordered table-hover table-sm">
		<tr>
			<td>序号</td>
			<td>用户名</td>
			<td>昵称</td>
			<td>生日</td>
			<td>性别</td>
			<td>注册时间</td>
			<td>用户状态</td>
		</tr>
		<c:forEach items="${g}" var="u" varStatus="i">
			<tr>
				<td>${i.count }</td>
				<td width="350px">${u.username }</td>
				<td>${u.nickname }</td>
				<td>
					<fmt:formatDate value="${u.birthday }" pattern="yyyy-MM-dd"/>
				</td>
				<td>
					<c:if test="${u.gender==1 }">男</c:if>
					<c:if test="${u.gender==0 }">女</c:if>
				</td>
				<td>
					<fmt:formatDate value="${u.created }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>
				  <c:if test="${u.locked==1}">
				   <button type="button" class="btn btn-danger btn-sm" onclick="up(${u.id})">禁用</button>
				  </c:if>
				 <c:if test="${u.locked==0}">
				   <button type="button" class="btn btn-info btn-sm" onclick="u(${u.id})">正常</button>
				  </c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
	<jsp:include page="/view/common/pages.jsp"></jsp:include>
</body>
<script type="text/javascript">
	function goPage(page) {
		var forms=$("form").serialize();
		$("#center").load("/admin/user?page="+page+"&user="+forms);
	}
	function query(){
		  var username=$("[name='username']").val();
		  var locked=$("[name='locked']").val();
		  $("#center").load("/admin/user?username="+username+"&locked="+locked);
	  }
	
	function up(id) {
		var page=${info.pageNum};
		alert(page);
		$.post(
			"/admin/up",
			{id:id},
			function(as) {
				if (as>0) {
					alert("操作成功！");
					var fprms=$("form").serialize();
					$("#center").load("/admin/user?page="+page+"&user="+forms);
				}else {
					alert("操作失败！");
				}
			}
		)
	}
	function u(id) {
		var page=${info.pageNum};
		alert(page);
		$.post(
			"/admin/u",
			{id:id},
			function(as) {
				if (as>0) {
					alert("操作成功！");
					var fprms=$("form").serialize();
					$("#center").load("/admin/user?page="+page+"&user="+forms);
				}else {
					alert("操作失败！");
				}
			}
		)
	}
</script>
</html>