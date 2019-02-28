<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
					<li><a href="plan!goReleasePage">make plan</a>
					</li>
					<li ><a href="plan!getMatchInfor">  通知</a>
					</li>
						<li ><a href="individual!checkCondition">荐友</a>
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
		</div>
	</div>
	<div class="row-fluid">
		<div class="span8">
			<div class="row-fluid">
				<div class="span2">
				</div>
				<div class="span6">
					<img alt="140x140" src="images/test.jpg" /><br />
				<h3>${userInfor.sno}</h3><br />
				<h3>${userInfor.sex}</h3><br />
					<h2>
						标题
					</h2>
					<p>
						本可视化布局程序在HTML5浏览器上运行更加完美, 能实现自动本地化保存, 即使关闭了网页, 下一次打开仍然能恢复上一次的操作.
					</p>
					<p>
						<a class="btn" href="#">查看更多 »</a>
					</p>
				</div>
				<div class="span4">
				</div>
			</div>
		</div>
		<div class="span4">
		</div>
	</div>
</div>

</body>
</html>