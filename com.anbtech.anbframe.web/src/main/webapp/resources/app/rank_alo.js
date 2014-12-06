$a.page({
	init : function(id, param) {
		// Todo List 조회를 위해서 서버 정보 세팅
		// $a.request.setup은 모든 reqeust에 공통으로 사용되므로 통신을 여러 번 사용하는 프로젝트에서는 각
		// 페이지에서 정의하지 않고 common.js 같은 파일에 따로 작성하여 사용하시면 됩니다.
		 $a.page.setEventListener();
		
		$a.request.setup({
			platform : 'NEXCORE.J2EE',
			url : 'rank_list.do', // 서버 URL
			method : 'GET',
			before : function(id, option) {
				$('body').progress(); // progress bar 시작
			},
			after : function(res) {
				$('body').progress().remove(); // progress 종료
			},

			fail : function(res) {
				alert('서버오류 입니다.');
				$('body').progress().remove(); // progress 종료
			},
			error : function(err) {
				alert('현재 네트워크 상태를 확인하세요.');
				$('body').progress().remove(); // progress 종료
			}
		});

		// 그리드 초기화
		$a.page.initGrid();

		// TodoList 조회 request
		$a.request('search', {
			data : {
				"id" : param['name']
			},
			success : '#grid_todolist'
		});
	},

	// 그리드 초기화
	initGrid : function() {
		$('#grid_todolist').alopexGrid({
			rowSingleSelect : false,
			rowClickSelect : true,
			rowInlineEdit : true,
			headerGroup : [ {
				fromIndex : 1,
				toIndex : 3,
				title : '직급정보'
			} ],
			columnMapping : [ {
				columnIndex : 0,
				selectorColumn : true,
				width : "5px"
			}, {
				columnIndex : 1,
				align : 'center',
				key : 'rankCode',
				title : '직급코드',
				width : '10px',
			}, {
				columnIndex : 2,
				align : 'center',
				key : 'rankName',
				title : '직급명',
				width : '30px',
				sorting : true
			}, {
				columnIndex : 3,
				align : 'center',
				key : 'rankOrder',
				title : '직급순서코드',
				width : '10px',
				sorting : true
			} ]
		});
	},
	
	setEventListener : function() {
        //next 버튼 클릭 이벤트 핸들러  
        $('#find_btn').click(function() {
        	if(!$('#textRank').validate()){
                alert($('#textRank').getErrorMessage());
            }
            else{
            	var rname = $("#textRank").val();
              //console.log(" "+rname);
              $a.request('find', {
      			data : {
      				"name" : rname
      			},
      			success : '#grid_todolist'
      		});
            }
      });  
    }
});