<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="base.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<%=webPath %>/css/bootstrap.min.css" rel="StyleSheet" type="text/css"/>
<link href="<%=webPath %>/css/signin.css" rel="StyleSheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

  <div class="container">

      <form class="form-signin" action="<%=webPath%>/as?op=adminLogin" method="post">
        <h2 class="form-signin-heading">管理员登录</h2>
 
        <input type="text" name="adminName" class="form-control" placeholder="请输入账号" required autofocus>
        <br/>
    
        <input type="password" name="adminPassword" class="form-control" placeholder="请输入密码" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
      </form>

    </div> <!-- /container -->


</body>
</html>