var userMng = {
		
		contextPath : $('#contextPath').val()
		// 직원 추가
		,newUser : function(){
	            $('#dlg').dialog('open').dialog('setTitle','New User');
	            $('#anbUserUserId').textbox('readonly',false);
	            $('#fm').form('clear');
	            $('#mode').val("0");
	            $('#anbDivDivCode').combobox('reload', '${pageContext.request.contextPath }/com/getListCode.do?table=ANB_DIV&sel1=DIV_CODE&sel2=DIV_NAME');
	            $('#anbRankRankCode').combobox('reload', '${pageContext.request.contextPath }/com/getListCode.do?table=ANB_RANK&sel1=RANK_CODE&sel2=RANK_NAME');
	    },
	    
	    // 직원 수정    
	    editUser : function(){
	            var row = $('#dg').datagrid('getSelected');
	            if (row){
	                $('#dlg').dialog('open').dialog('setTitle','Edit User');
	                $('#anbUserUserId').textbox('readonly',true);
	                $('#fm').form('load',row);
	            	$('#mode').val("1");
	            	$('#anbDivDivCode').combobox('reload', userMng.contextPath+'/common/getListCode.do?table=ANB_DIV&sel1=DIV_CODE&sel2=DIV_NAME');
	                $('#anbRankRankCode').combobox('reload', userMng.contextPath+'/common/getListCode.do?table=ANB_RANK&sel1=RANK_CODE&sel2=RANK_NAME');
	            }else{
	            	$.messager.alert('','수정할 row 를 선택하세요.','info');
	            }
	     },
	     
	     // 저장 Action
	     saveUser : function(){
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
	     },
	        
	     // 삭제
	     removeUser : function(){
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
	     },
};

$( document ).ready(function() {
	
});
        