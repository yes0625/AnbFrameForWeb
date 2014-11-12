<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>에이앤비테크(주) 개발센터 웹어플리케이션</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/themes/color.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/jquery.easyui.min.js"></script>
</head>
<body>

<div class="easyui-calendar" style="width:250px;height:250px;"></div>
	<ul>
		<li><a href="home.do">현재시간 바로가기</a></li>
		<li><a href="user_all.do">사용자 정보 테스트</a></li>
	</ul>

<table class="easyui-datagrid" title="Basic DataGrid" style="width:700px;height:250px"
            data-options="singleSelect:true,collapsible:true,url:'user_all.do',method:'get'">
        <thead>
            <tr>
                <th data-options="field:'userId',width:80">Item ID</th>
                <th data-options="field:'userName',width:100">Product</th>
            </tr>
        </thead>
    </table>

</body>
</html>