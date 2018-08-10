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

      <form class="form-signin" action="<%=webPath%>/ps" method="post">
        <h2 class="form-signin-heading">请登录</h2>
 		 <input type="hidden" name="op" value="login"/>
        <input type="text" name="personEmail" class="form-control" placeholder="请输入账号" required autofocus>
        <br/>
    
        <input type="password" name="personPassword" class="form-control" placeholder="请输入密码" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
        <br>
        <a href="<%=webPath %>/web/regist.jsp">注册</a>
      </form>

    </div> <!-- /container -->


</body>
</html>