<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="<%=webPath%>/css/bootstrap.min.css" rel="StyleSheet"
	type="text/css" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${requestScope.persons != null}">
		<c:if test="${requestScope.persons.size() == 0}">
没有数据
</c:if>
		<c:if test="${requestScope.persons.size() > 0}">
			<div class="container">
				<div class="row">
					<div class="col-md-3"></div>

					<div class="col-md-6">
						<table class="table table-hover">
							<tr class="active">
								<td>编号</td>
								<td>姓名</td>
								<td>性别</td>
								<td>邮箱</td>
								<td>密码</td>
								<td>操作</td>
							<tr>
								<c:forEach items="${requestScope.persons}" var="person">
									<tr class="active" >
										<td class="success">${pageScope.person.personId }</td>
										<td class="success">${pageScope.person.personName }</td>
										<td class="success">${pageScope.person.personSex }</td>
										<td class="success">${pageScope.person.personEmail }</td>
										<td class="success">${pageScope.person.personPassword }</td>
										<td class="warning"><a href="${pageContext.request.contextPath}/ps?op=del&personId=${pageScope.person.personId}">删除</a></td>
									<tr>
								</c:forEach>
						</table>
					</div>

					<div class="col-md-3"></div>
				</div>
			</div>
		</c:if>
	</c:if>
	<c:if test="${requestScope.persons == null}">
		<c:redirect url="/ps?op=showPersons" />
	</c:if>
</body>
</html>