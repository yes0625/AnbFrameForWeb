var common = {
		
		// form submit 
		formSubmit : function(frm,url,callback){
			$('#'+frm).form('submit',{
	            url: url,
	            onSubmit: function(){
	                return $(this).form('validate');
	            },
	            success: function(result){
	            	var result = eval('('+result+')');
	                if (result.errorMsg){
	                    $.messager.show({
	                        title: 'Error',
	                        msg: result.errorMsg
	                    });
	                } else {
	                	 $.messager.show({
		                       title: 'SUCCESS',
		                       msg: '정상 처리 되었습니다.'
		                   				});
	                	if(callback) callback(result);
	                }
	            }
	        });
		}

		// call ajax
		,ajaxCall : function(url,param,callback){
			$.post(url,param,function(result){
                if (result.success){
                	  $.messager.show({
                        	title: 'SUCCESS',
                            msg  : '정상 처리 되었습니다.'
                                     });
                    if(callback) callback();
                    
                } else {
                    $.messager.show({    // show error message
                        title: 'Error',
                        msg: result.errorMsg
                    });
                }
            },'json');
		}
}