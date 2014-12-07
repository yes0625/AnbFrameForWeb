var userMng = {
		// 직원 추가
		newUser : function(){
            $('#dlg').dialog('open').dialog('setTitle','New User');
            $('#anbUserUserId').textbox('readonly',false);
            $('#fm').form('clear');
            $('#mode').val("0");
        }
        
		// 직원 수정 
        ,editUser : function(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $('#dlg').dialog('open').dialog('setTitle','Edit User');
                $('#anbUserUserId').textbox('readonly',true);
                $('#fm').form('load',row);
            	$('#mode').val("1");
            }else{
            	$.messager.alert('','수정할 row 를 선택하세요.','info');
            }
        }
        
        // 직원 추가 / 저장 
        ,saveUser : function(){
        	common.formSubmit('fm','insertUser.do',function(result){
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
        
        // 직원 삭제
        ,deleteUser : function(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $.messager.confirm('Confirm','정말 삭제 하시겠습니까?',function(r){
                    if (r){
                        common.ajaxCall('deleteUser.do', {anbUserUserId:row.anbUserUserId}, function(){
                        	$('#dg').datagrid('reload');    // reload the user data
                        });
                    }
                });
            }else{
            	$.messager.alert('','삭제할 row 를 선택하세요.','info');
            }
        }
};
        