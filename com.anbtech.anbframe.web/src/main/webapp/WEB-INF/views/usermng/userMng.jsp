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
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath }/css/Mng/userMng.css">
<script type="text/javascript"	src="${pageContext.request.contextPath }/resources/jquery.min.js"></script>
<script type="text/javascript"	src="${pageContext.request.contextPath }/resources/jquery.easyui.min.js"></script>
<script type="text/javascript"	src="${pageContext.request.contextPath }/resources/common/common.js"></script>
<head>
	<title>직원관리</title>
</head>
<body>

	<div style="width:700px;">
	  <div style="float:right; margin-bottom:5px;">		
	  		<select class="easyui-combobox" name="state" style="width:100px;">
		        <option value="empId">사용자아이디</option>
		        <option value="empName">사용자이름</option>
	        </select>
	        <input class="easyui-textbox" data-options="buttonText:'Search',buttonIcon:'icon-search',prompt:'Search...'" style="width:200px;height:24px;">
	  </div>
	  <div>
		  <table id="dg" title="직원목록" class="easyui-datagrid" style="width:100%; height:250px"
		            url="${pageContext.request.contextPath }/usermng/getListUser.do"
		            toolbar="#toolbar" pagination="true"
		            rownumbers="true" fitColumns="true" singleSelect="true">
		        <thead>
		            <tr>
		            	<th field="anbUserUserId" width="50">사용자 아이디</th>
		            	<th field="empName" width="50">사용자이름</th>
		                <th field="empEmail" width="50">이메일</th>               
		                <th field="empPhone" width="50">전화번호</th>
		                <th field="empAddress" width="50">주소</th>
		            </tr>
		        </thead>
		    </table>
		</div>
	</div>
    <div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">New User</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">Edit User</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">Remove User</a>
    </div>
    
     <div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
        <div class="ftitle">User Information</div>
        <form id="fm" method="post" novalidate>
     	<input type="hidden" id="mode" />
            <div class="fitem">
                <label>사용자 아이디</label>
                <input id="anbUserUserId" name="anbUserUserId" class="easyui-textbox" required="true" maxlength="20">
            </div>
            <div class="fitem">
                <label>사용자이름</label>
                <input name="empName" class="easyui-textbox" required="true">
            </div>
            <div class="fitem">
                <label>이메일</label>
                <input name="empEmail" class="easyui-textbox" validType="email">
            </div>
            <div class="fitem">
                <label>전화번호</label>
                <input name="empPhone" class="easyui-textbox">
            </div>
            <div class="fitem">
                <label>주소</label>
                <input name="empAddress" class="easyui-textbox">
            </div>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">Save</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
    </div>
</body>
</html>


<script type="text/javascript">
        var url;
        
        function newUser(){
            $('#dlg').dialog('open').dialog('setTitle','New User');
            $('#anbUserUserId').textbox('readonly',false);
            $('#fm').form('clear');
            $('#mode').val("0");
            url = '';
        }
        
        function editUser(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $('#dlg').dialog('open').dialog('setTitle','Edit User');
                $('#anbUserUserId').textbox('readonly',true);
                $('#fm').form('load',row);
            	$('#mode').val("1");
                
                url = '${pageContext.request.contextPath }/usermng/editUser.do';
            }else{
            	$.messager.alert('','수정할 row 를 선택하세요.','info');
            }
        }
        
        function saveUser(){
        	common.formSubmit('fm','${pageContext.request.contextPath }/usermng/insertUser.do',function(result){
            	if(result.duplication == "Y"){
                $.messager.show({
                	title: '아이디중복',
                    msg:   '중복되는 아이디 입니다.'
                               });            		
               	}else{
	                $('#dlg').dialog('close');        // close the dialog
    	            $('#dg').datagrid('reload');    // reload the user data
               	}            	
            });
        }
        
        
        function destroyUser(){
            var row = $('#dg').datagrid('getSelected');
            if (row.anbUserUserId != null){
                $.messager.confirm('Confirm','Are you sure you want to destroy this user?',function(r){
                    if (r){
                        $.post('${pageContext.request.contextPath }/usermng/deleteUser.do?user_id='+row.anbUserUserId
                        		,function(result){
                            $('#dg').datagrid('reload');    // reload the user data
                    	},'json');
                    }
                });
            }
        }
        
    </script>
