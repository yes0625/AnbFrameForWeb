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
	<title>부서관리</title>
</head>
<body>
  <table id="dg" title="부서목록" class="easyui-datagrid" style="width:700px;height:250px"
            url="${pageContext.request.contextPath }/departList/getDeptList.do"
            toolbar="#toolbar" pagination="true"
            rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
            <tr>
            	<th field="dept_name" width="50">부서명</th>
            	<th field="dept_code" width="50">부서코드</th>
                <th field="dept_parent" width="50">상위부서</th>               
            </tr>
        </thead>
    </table>


</body>
</html>
