<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="base.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<%=webPath%>/css/bootstrap.min.css" rel="StyleSheet"
	type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<c:if test="${sessionScope.person != null }">
		<div class="container">
			<div class="row">
				<div class="col-md-3"></div>

				<div class="col-md-6">
					<table class="table table-hover">
						<tr>
							<td class="active">person name</td>
							<td class="success">${sessionScope.person.personName}</td>
						</tr>

						<tr>
							<td class="active">person Email</td>
							<td class="success">${sessionScope.person.personEmail}</td>
						</tr>

						<tr>
							<td class="active">person sex</td>
							<td class="success">${sessionScope.person.personSex}</td>
						</tr>
					</table>
				</div>

				<div class="col-md-3">
					<a
						href="<%=webPath%>/ps?op=show&personId=${sessionScope.person.personId}">修改用户信息</a>
				</div>
			</div>
		</div>
	</c:if>
	<c:if test="${sessionScope.person == null }">
		<c:redirect url="/web/login.jsp" />
	</c:if>
</body>
</html>