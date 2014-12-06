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
	                	if(callback) callback(result);
	                }
	            }
	        });
		}
}