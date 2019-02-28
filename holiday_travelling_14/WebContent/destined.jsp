<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- bootstrap 引入 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-theme.css" rel="stylesheet">
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script src="jquery-1.11.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="css/bootstrap-combined.min.css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet">
<link
	href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.0/css/layoutit.css"
	rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<ul class="nav nav-tabs">
				<li class="active">
					<a href="#">首页</a>
				</li>
				<li>
					<a href="#">资料</a>
				</li>
				<li class="disabled">
					<a href="#">信息</a>
				</li>
				<li class="dropdown pull-right">
					 <a class="dropdown-toggle" href="#" data-toggle="dropdown">下拉<strong class="caret"></strong></a>
					<ul class="dropdown-menu">
						<li>
							<a href="#">操作</a>
						</li>
						<li>
							<a href="#">设置栏目</a>
						</li>
						<li>
							<a href="#">更多设置</a>
						</li>
						<li class="divider">
						</li>
						<li>
							<a href="#">分割线</a>
						</li>
					</ul>
				</li>
			</ul>
			<div class="alert">
				 <button class="close" type="button" data-dismiss="alert">×</button>
				<h4>
					提示!
				</h4>
				<p>
					根据您的计划我们为您推荐的同伴如下
				</p>
				
			</div>
			<table class="table">
				<thead>
					<tr>
						<th>学号</th>
							<th>性别</th>
							<th>学校</th>
							<th>微信号</th>
							<th>个人介绍</th>
							
							
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}"  var="u">
							<tr>
								<td>${u.sno}</td>
								<td>${u.sex}</td>
								<td>${u.college}</td>
								<td>${u.wechat}</td>
								<td>${u.introduce}</td>
							</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>