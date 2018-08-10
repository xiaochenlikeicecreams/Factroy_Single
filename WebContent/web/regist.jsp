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

      <form class="form-signin" action="<%=webPath %>/ps?op=regist" method="post">
        <h2 class="form-signin-heading">请注册</h2>
 
        <input type="text"  name="personName" class="form-control" placeholder="请输入用户名" required autofocus>
        <br/>
          <input type="email"  name="personEmail" class="form-control" placeholder="请输入邮件" required autofocus>
        <br/>
        
       
    
        <input type="password"  name="personPassword" class="form-control" placeholder="请输入密码" required>
         <label class="radio-inline">
          <input type="radio" name="personSex" checked="checked" value="man">先生
          </label>
      
          <label class="radio-inline">
          <input type="radio" name="personSex" value="woman">女士
          </label>
         
        <br/><br/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
      </form>

    </div> <!-- /container -->


</body>
</html>