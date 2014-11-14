<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>개발센터 웹어플리케이션</title>
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath }/resources/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath }/resources/themes/icon.css">
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath }/resources/themes/color.css">
<script type="text/javascript"	src="${pageContext.request.contextPath }/resources/jquery.min.js"></script>
<script type="text/javascript"	src="${pageContext.request.contextPath }/resources/jquery.easyui.min.js"></script>

<style>
	#display_area {
		margin : 20px;
	}
</style>

</head>
<body>

	<div id="content">
		<div style="margin: 20px 0"></div>
		<select id="cc" style="width: 150px"></select>
		<div id="sp">
			<div style="color: #99BBE8; background: #fafafa; padding: 5px;">팀 선택</div>
			<div style="padding: 10px">
				<input type="radio" name="lang" value="sjh"><span>서정환 차장 조</span><br />
				<input type="radio" name="lang" value="kys"><span>김영심 과장 조</span><br />
				<input type="radio" name="lang" value="khj"><span>권호진 과장 조</span><br />
			</div>
		</div>
		<button id="find">조회</button>
	</div>

<div id="display_area"></div>

	<script type="text/javascript">
		$(function() {
			$('#cc').combo({
				required : true,
				editable : false
			});
			$('#sp').appendTo($('#cc').combo('panel'));
			$('#sp input').click(
					function() {
						var v = $(this).val();
						var s = $(this).next('span').text();
						$('#cc').combo('setValue', v).combo('setText', s)
								.combo('hidePanel');
					});
			
			$("#find").click(function(){
				var key = $("#cc").combo('getValue');
				var url = "";
				var tit = "";
				
				if(key=="sjh"){
					url = "home_sjh.do";
					tit = "서정환 차장, 이서정 사원이  개발한 화면입니다.";
				}else if(key=="kys"){
					url = "home_kys.do";
					tit = "김영심 과장, 윤석완 사원이  개발한 화면입니다.";
				}else if(key=="khj"){
					url = "home_khj.do";
					tit = "권호진 과장, 김유원 사원이  개발한 화면입니다.";
				}
				
				$("#display_area").load(url);
				
				$.messager.show({
	                title:'개발 화면',
	                msg : tit,
	                showType:'show',
	                style : 'center'
	            });
				
			});
		});
	</script>

</body>
</html>