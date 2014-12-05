<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>개발센터 웹어플리케이션</title>
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath }/resources/foundation/css/normalize.css">
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath }/resources/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath }/resources/themes/icon.css">
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath }/resources/themes/color.css">

<script type="text/javascript"	src="${pageContext.request.contextPath }/resources/jquery.min.js"></script>
<script type="text/javascript"	src="${pageContext.request.contextPath }/resources/jquery.easyui.min.js"></script>
<script type="text/javascript"	src="${pageContext.request.contextPath }/resources/foundation/js/vendor/modernizr.js"></script>
<script type="text/javascript"	src="${pageContext.request.contextPath }/resources/foundation/js/foundation.min.js"></script>

<style>
	#display_area {
		margin : 20px;
	}
</style>

</head>
<body>

<ul>
	<li><a href="${pageContext.request.contextPath }/usermng/userMng.do">직원관리</a></li>
	<li><a href="${pageContext.request.contextPath }/rank/manage_rank.do">직급관리</a></li>
</ul>



<a href="${pageContext.request.contextPath }/usermng/userMng.do">직원관리</a>
<a href="${pageContext.request.contextPath }/department/departList.do">부서관리</a>
</body>
</html>