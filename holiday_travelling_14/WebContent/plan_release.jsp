<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>

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
<script src="AjaxUtilXML.js"></script>
<script type="text/javascript" charset="UTF-8" >
	function test(para) {
		sendAjaxReq("post", "plan!getCity", "para=" + para.value, true,
				function(data) {
					document.getElementById("div1").innerHTML = data;
				});
}
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#">首页</a></li>
					<li><a href="#">资料</a></li>
					<li class="disabled"><a href="#">信息</a></li>
					<li class="dropdown pull-right"><a class="dropdown-toggle"
						href="#" data-toggle="dropdown">下拉<strong class="caret"></strong>
					</a>
						<ul class="dropdown-menu">
							<li><a href="#">操作</a></li>
							<li><a href="#">设置栏目</a></li>
							<li><a href="#">更多设置</a></li>
							<li class="divider"></li>
							<li><a href="#">分割线</a></li>
						</ul></li>
				</ul>
				<div class="row-fluid">
					<div class="span8">
						<div class="alert">
							<button class="close" type="button" data-dismiss="alert">×</button>
							<h4>提示!</h4>
							<strong>警告!</strong> 请注意你的个人隐私安全.
						</div>
						<div class="row-fluid">
							<form class="form-horizontal" method="post"
								action="plan!releasePlan">
								<div class="span6">
									<div class="control-group">
										<label class="control-label" for="inputEmail">来个标题</label>
										<div class="controls">
											<input id="inputEmail" type="text" name="userPlan.title" />
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="inputEmail">目的省/市：</label> <select
											name="userPlan.province">

											<!-- <s:iterator value="list" >
												<option value="code"><s:property value="name"/></option>
											</s:iterator>-->

											<c:forEach items="${list}" var="s">
												<option value="${s.code}" name="para" onclick="test(this);">${s.name}</option>
											</c:forEach>
										</select>
									</div>
									<div class="control-group">
										<label class="control-label" for="inputEmail">目的市/区：</label>
										<div id="div1">
											<select name="userPlan.city">
												<option value="1">北京</option>
											</select>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="inputPassword">目的景点：</label>
										<div class="controls">
											<input id="inputPassword" type="text" name="userPlan.view" />
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="inputEmail">计划旅友人数：</label>
										<select name="userPlan.totalperson">
											<option value="1" >一两个</option>
											<option value="3">三四个</option>
											<option value="5">五六个</option>
											<option value="7">七八个</option>
											<option value="9">更多</option>
										</select>
									</div>
									<div class="control-group">
										<label class="control-label" for="inputEmail">旅游时长：</label> <select
											name="userPlan.totaltime">
											<option value="1">1天</option>
											<option value="2">2天</option>
											<option value="3">3天</option>
											<option value="4">4天</option>
											<option value="5">5天</option>
											<option value="6">6天</option>
											<option value="7">7天</option>
											<option value="8">更久</option>
										</select>
									</div>
									<div class="control-group">
										<label class="control-label" for="inputEmail">计划个人旅游花费：</label> <select
											name="userPlan.totalcost">
											<option value="1">0~200</option>
											<option value="3">200~400</option>
											<option value="5">400~600</option>
											<option value="7">600~800</option>
											<option value="9">800+</option>
										</select>
									</div>
								</div>
								<div class="span6">
									<div class="control-group">
										<label class="control-label" for="inputEmail">旅友性别：</label> <select
											name="userPlan.companysex">
											<option value="1">男</option>
											<option value="2">女</option>
											<option value="3">都行</option>

										</select>
									</div>
									<div class="control-group">
										<label class="control-label" for="inputEmail">旅游时间：</label> <select
											name="userPlan.startdate">
											<option value="1">本周</option>
											<option value="2">下周</option>
											<option value="3">这个月</option>
											<option value="4">国庆</option>
											<option value="5">中秋</option>
											<option value="6">元旦</option>
										</select>
									</div>
									<div class="control-group">
										<label class="control-label" for="inputEmail">补充内容：</label>
										<textarea rows="10" cols="30" name="userPlan.introduce">
										我是一个文本框。
									</textarea>
									</div>
									<div class="control-group">
										<div class="controls">
											<button class="btn" type="submit">发布计划</button>
										</div>
									</div>

								</div>
							</form>
						</div>
					</div>
					<div class="span4"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>