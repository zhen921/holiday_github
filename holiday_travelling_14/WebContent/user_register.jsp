<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>

     <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
      <link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-theme.css" rel="stylesheet">
   <link href="css/bootstrap-theme.min.css" rel="stylesheet">
      <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script src="jquery-1.11.1.js"></script>
<script src="js/bootstrap.min.js"></script>

<!-- Le styles -->
<link href="css/bootstrap-combined.min.css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.0/css/layoutit.css" rel="stylesheet">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span2">
		</div>
		<div class="span6">
			<form class="form-horizontal" method="post" action="regis!register" >
			
				<div class="control-group">
					 <label class="control-label" for="inputEmail">学号</label>
					<div class="controls">
						<input id="inputEmail" type="text" name="userInfor.sno"  />
					</div>
				</div>
				<div class="control-group">
					 <label class="control-label" for="inputPassword">密码</label>
					<div class="controls">
						<input id="inputPassword" type="password" name="userInfor.pwd" />
					</div>
				</div>
				<div class="control-group">
					 <label class="control-label" for="email">邮箱</label>
					<div class="controls">
						<input  id="email" type="text" name="userInfor.email" />
					</div>
					</div>
				<div class="control-group">
					 <label class="control-label" for="we" >微信</label>
					<div class="controls">
						<input id="we" type="text" name="userInfor.wechat" />
					</div>
				</div>
				<div class="control-group">
					 <label class="control-label" for="college">学校</label>
					<div class="controls">
						<input id="college" type="text" name="userInfor.college" />
					</div>
				</div>
				<div class="control-group">
					 <label class="control-label" for="de">学院</label>
					<div class="controls">
						<input id="de" type="text" name="userInfor.depart" />
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						男：<input name="userInfor.sex" type="radio" checked="checked" value="1" /> 
						女：<input name="userInfor.sex" type="radio" value="2" />
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						 <button class="btn" type="submit">注册</button> <button class="btn" type="submit">取消</button>
					</div>
				</div>
			</form>
		</div>
		<div class="span4">
		</div>
	</div>
</div>
  </body>
</html>
