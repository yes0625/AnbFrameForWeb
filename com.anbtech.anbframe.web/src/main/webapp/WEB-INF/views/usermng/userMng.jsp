<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>개발센터 웹어플리케이션</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/themes/icon.css">
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath }/resources/themes/color.css">
<script type="text/javascript"	src="${pageContext.request.contextPath }/resources/jquery.min.js"></script>
<script type="text/javascript"	src="${pageContext.request.contextPath }/resources/jquery.easyui.min.js"></script>
<head>
	<title>직원관리</title>
</head>
<body>
  <table id="dg" title="직원목록" class="easyui-datagrid" style="width:700px;height:250px"
            url="${pageContext.request.contextPath }/userMng/getListUser.do"
            toolbar="#toolbar" pagination="true"
            rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
            <tr>
            	<th field="empId" width="50">사용자 아이디</th>
            	<th field="empName" width="50">사용자이름</th>
                <th field="empEmail" width="50">이메일</th>               
                <th field="empPhone" width="50">전화번호</th>
                <th field="empAddress" width="50">주소</th>
            </tr>
        </thead>
    </table>


</body>
</html>
