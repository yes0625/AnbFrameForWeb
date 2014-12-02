<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/alopex/css/alopex-ui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/alopex/css/alopex-grid.css" />

<script type="text/javascript"	src="${pageContext.request.contextPath }/resources/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/alopex/script/alopex-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/alopex/script/alopex-grid.js"></script>
<script type="text/javascript"	src="${pageContext.request.contextPath }/resources/angular.min.js"></script>
<script type="text/javascript"	src="${pageContext.request.contextPath }/resources/app/rank.js"></script>
<script type="text/javascript"	src="${pageContext.request.contextPath }/resources/app/rank_alo.js"></script>

<style type="text/css">
	#wrapper {margin:50px;}
	#rank_grid {width : 80%; margin-left:100px; margin-top:30px;}
</style>

<title>직급관리</title>
</head>
<body ng-init="name='AlopexUI & AngularJS'">

<div id="wrapper">
<span>직급관리  by {{name}}</span>
	<div id="rank_grid">
        <div id="grid_todolist"></div>
    </div>
</div>
</body>
</html>